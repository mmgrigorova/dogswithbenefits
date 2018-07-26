package com.antman.dogswithbenefits.config;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public SessionFactory createSessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Dog.class)
                .addAnnotatedClass(Breed.class)
                .buildSessionFactory();
    }

}
