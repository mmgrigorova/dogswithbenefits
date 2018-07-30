package com.antman.dogswithbenefits.web;


import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.services.base.UserLoginService;
import com.antman.dogswithbenefits.services.base.UserRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRegController {
    private UserRegService userRegService;

    @Autowired
    public UserRegController(UserRegService userRegService){
        this.userRegService = userRegService;
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute User user) {
        System.out.println(user.getFirstName());
        userRegService.saveUser(user);
        return "registration";
    }

}
