package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.User;
//import org.springframework.data.repository.CrudRepository;


public interface UserRepository{
    public User findByEmail(String email);

    public void saveUser(User user);

}
