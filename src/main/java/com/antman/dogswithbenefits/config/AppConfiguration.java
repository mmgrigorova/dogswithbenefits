package com.antman.dogswithbenefits.config;

import com.antman.dogswithbenefits.models.*;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfiguration {
    @Bean
    public SessionFactory createSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Dog.class)
                .addAnnotatedClass(Breed.class)
                .buildSessionFactory();
    }

    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate4Module();
    }

}
