package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.repositories.base.UserRepository;
import com.antman.dogswithbenefits.services.base.UserLoginService;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    private UserRepository userRepository;

    public UserLoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String mail) {
        return userRepository.findByEmail(mail);
    }
}
