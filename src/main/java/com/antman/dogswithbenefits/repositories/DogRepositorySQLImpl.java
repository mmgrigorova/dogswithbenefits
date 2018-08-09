package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.City;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

// TODO - Create separate repository for photos

import static org.springframework.http.HttpHeaders.FROM;

@Repository
public class DogRepositorySQLImpl implements DogRepository {
    private static SessionFactory factory;
    private static int allDogsCount = 0;

    @Autowired
    public DogRepositorySQLImpl(SessionFactory factory) {
        this.factory = factory;
        setAllDogsCount();
    }

    public int getAllDogsCount() {
        return allDogsCount;
    }

    public void setAllDogsCount() {
        Session session = null;
        try {
            Long tempDogsCount = 0l;
            session = factory.openSession();
            session.beginTransaction();
            tempDogsCount = (Long) session.createCriteria(Dog.class)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();
           allDogsCount = toIntExact(tempDogsCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static Criteria getCriteria(final Session session) {
        Criteria criteria = session.createCriteria(Dog.class);
        criteria.add(Restrictions.isNotNull("name"));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("name")));
        criteria.addOrder(Order.asc("name"));

        return criteria;
    }

    @Override
    public List<Dog> getAllDogs() {
        List<Dog> dogs = new ArrayList<>();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Dog");
            dogs = query.list();
            for (Dog dog : dogs) {
                dog.getPhoto();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dogs;
    }

    @Override
    public List<Dog> getPageOfDogs(int startPosition, int rowsCount) {
        List<Dog> dogs = new ArrayList<>();
        Session session = null;
        int totalRecords = 0;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Dog.class);
            criteria.setFirstResult(startPosition);
            criteria.setMaxResults(rowsCount);
            dogs = (List<Dog>) criteria.list();
            for (Dog dog : dogs) {
                dog.getPhoto();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dogs;
    }

    @Override
    public void addDog(Dog dog) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(dog);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Dog findById(int id) {
        Dog dog = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            dog = (Dog) session.get(Dog.class, id);
            dog.getOwner().getFirstName();
            dog.getOwner().getPhoneNumber();
            dog.getOwner().getAddress().getCity().getName();
            dog.getPhotos().forEach(photo -> photo.getPath());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dog;
    }

    @Override
    public boolean update(Dog updateDog) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(updateDog);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Dog deleteDog) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(deleteDog);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public List<Dog> searchFilter(String input, String choice) {
        List<Dog> dogs = null;
        switch (choice){
            case "breed": dogs = findByBreed(input);
            break;
            case "name": dogs = findByName(input);
            break;
            case "gender": dogs = findBySex(input);
            break;
            case "city": dogs = findByCity(input);
            default:
                break;
        }
        return dogs;
    }

    public List<Dog> findByBreed(String input){
        List<Dog> dogs = new ArrayList<>();
        Session session = null;
        try {
            session =factory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Breed as b where b.name =:input")
                    .setParameter("input",input);
        Breed breed = (Breed)q.uniqueResult();

            for (int i = 0; i < breed.getDogs().size(); i++) {
                dogs.addAll(breed.getDogs());
            }

        }catch (Exception e){e.printStackTrace();}
        return dogs;
    }

    public List<Dog> findByName(String input){
        List<Dog> dogs = new ArrayList<>();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            dogs = session.createQuery("from Dog as d where d.name=:input")
                    .setParameter("input",input).list();
        }catch (Exception e){e.printStackTrace();}
        return dogs;
    }

    public List<Dog> findBySex(String input){
        List<Dog> dogs = new ArrayList<>();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            String hql = "from Dog as d where d.gender = '" + input + "'";
            dogs = session.createQuery(hql).list();

        }catch (Exception e){e.printStackTrace();}
        return dogs;
    }

    public List<Dog> findByCity(String input){
        List<Dog> dogs = new ArrayList<>();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Query q = session.createQuery("from City as c where c.name=:input")
                    .setParameter("input",input);

            City c = (City)q.uniqueResult();

            for (int i = 0; i <c.getAddresses().size() ; i++)
            {
                dogs.addAll(c.getAddresses().get(i).getUser().getDogs());
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dogs;
    }
}