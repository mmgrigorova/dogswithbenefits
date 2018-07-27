package com.antman.dogswithbenefits.repositories;

import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.repositories.base.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;

    public UserRepositoryImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public User findByEmail(String email) {
        User user = null;
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            user = session.get(User.class, email);
            session.getTransaction().commit();
        }catch (Exception e){e.printStackTrace();}

        return user;
    }
}
