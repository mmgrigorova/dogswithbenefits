package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepositorySQLImpl<T> implements DogRepository {
    private static SessionFactory factory;

    @Autowired
    public DogRepositorySQLImpl(SessionFactory factory) {
        this.factory = factory;
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
        try{
            session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Dog");
            query.setFirstResult(startPosition);
            query.setMaxResults(rowsCount);
            dogs =  (List<Dog>) query.list();
            for (Dog dog : dogs) {
                dog.getPhoto();
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        return dogs;
    }


    private void addEntity(T t) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void addDog(Dog dog) {
        addEntity((T) dog);
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
    public void addPhoto(Photo photo) {
        addEntity((T) photo);
    }

    @Override
    public List<Breed> getBreeds() {
        List<Breed> breeds = new ArrayList<>();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            breeds = session.createQuery("FROM Breed").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return breeds;
    }
}
