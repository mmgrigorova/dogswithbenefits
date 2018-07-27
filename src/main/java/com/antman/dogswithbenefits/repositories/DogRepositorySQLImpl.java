package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepositorySQLImpl implements DogRepository {
    private static SessionFactory factory;

    @Autowired
    public DogRepositorySQLImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Dog> getAllDogs() {
        List<Dog> dogs = new ArrayList<>();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            dogs = session.createQuery("FROM Dog").list();
            dogs.forEach(dog -> dog.getOwner().getFirstName());
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        return dogs;
    }

    @Override
    public void addDog(Dog dog) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(dog);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
