package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.repositories.base.UserRepository;
import com.antman.dogswithbenefits.services.base.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegServiceImpl implements UserRegService {
    private UserRepository userRepository;
    private User newUser;

    @Autowired
    public UserRegServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(newUser);
    }
}
