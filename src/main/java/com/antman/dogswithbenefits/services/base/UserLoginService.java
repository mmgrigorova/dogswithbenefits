package com.antman.dogswithbenefits.services.base;

import com.antman.dogswithbenefits.models.User;

public interface UserLoginService {
    public User getUser(String mail);
}
