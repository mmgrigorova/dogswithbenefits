package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// TODO - Create separate repository for photos

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
            session = factory.openSession();
            session.beginTransaction();
            allDogsCount = (Integer) session.createCriteria(Dog.class)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();
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
//            ScrollableResults scrollableResults = getCriteria(session).scroll();
//            scrollableResults.last();
//            scrollableResults.close();

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


}
