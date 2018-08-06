package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.repositories.base.BreedRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BreedRepositoryImpl implements BreedRepository {
    private static SessionFactory factory;

    @Autowired
    public BreedRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
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
