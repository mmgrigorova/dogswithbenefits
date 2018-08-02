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

    private void addEntity(T t){
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addDog(Dog dog) {
        addEntity((T) dog);
    }

    @Override
    public Dog findById(int id) throws NullPointerException {
        Dog dog = null;
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            dog = (Dog) session.get(Dog.class, id);
            if (dog == null){
                throw new NullPointerException();
            }
            dog.getOwner().getFirstName();
            dog.getPhotos().forEach(photo -> photo.getPath());
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
    public void addPhoto(Photo photo) {
        addEntity((T) photo);
    }

    @Override
    public List<Photo> getDogPhotos(Dog dog) {
        List<Photo> photos = new ArrayList<>();
        try{
            Session session = factory.openSession();
            session.beginTransaction();
            photos = dog.getPhotos();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return photos;
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
