package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import org.hibernate.Query;
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
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Dog");
            dogs = query.list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return dogs;
    }

    @Override
    public void addDog(Dog dog) {
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(dog);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Dog findById(int id) {
        Dog dog = null;
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            dog = (Dog) session.get(Dog.class, id);
            dog.getOwner().getFirstName();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return dog;
    }

    @Override
    public void update(Dog updateDog) {
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(updateDog);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Breed> getBreeds(){
        List<Breed> breeds = new ArrayList<>();
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            breeds = session.createQuery("FROM Breed").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return breeds;
    }
}
