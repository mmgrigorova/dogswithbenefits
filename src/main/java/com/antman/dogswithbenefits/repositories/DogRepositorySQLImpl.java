package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
            Query<Dog> query = session.createQuery("FROM Dog");
            dogs = query.getResultList();
//            for (Dog dog : dogs) {
//                String ownername = dog.getOwner().getFirstName();
//            }
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

    @Override
    public List<Breed> getBreeds(){
        List<Breed> breeds = new ArrayList<>();
        try(Session session = factory.openSession()){
            session.beginTransaction();
            breeds = session.createQuery("FROM Breed").list();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }

        return breeds;
    }
}
