package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.repositories.base.PhotoRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PhotoRepositoryImpl implements PhotoRepository {
    private static SessionFactory factory;

    @Autowired
    public PhotoRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addPhoto(Photo photo) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(photo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
