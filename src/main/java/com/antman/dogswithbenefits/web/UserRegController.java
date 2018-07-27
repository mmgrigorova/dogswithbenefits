package com.antman.dogswithbenefits.web;


import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.services.base.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class UserRegController {
    private UserRegService userRegService;

    @Autowired
    public UserRegController(UserRegService userRegService){
        this.userRegService = userRegService;
    }

    @GetMapping("/user")
    public void getUser(){
        User user = userRegService.getUser("georgi@dogs.coom");
       // System.out.println(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void saveUser(){

    }
}
