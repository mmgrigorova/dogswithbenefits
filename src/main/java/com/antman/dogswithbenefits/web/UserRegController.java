package com.antman.dogswithbenefits.web;


import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.services.base.UserLoginService;
import com.antman.dogswithbenefits.services.base.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class UserRegController {
    private UserLoginService userLoginService;

    @Autowired
    public UserRegController(UserLoginService userLoginService){
        this.userLoginService = userLoginService;
    }

    @GetMapping("/user")
    public void getUser(){
        User user = userLoginService.getUser("georgi@dogs.com");
        System.out.println(user.getFirstName());
    }

}
