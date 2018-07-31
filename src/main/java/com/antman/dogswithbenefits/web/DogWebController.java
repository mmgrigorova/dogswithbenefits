package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dogs")
public class DogWebController {
    private DogService service;

    @Autowired
    public DogWebController(DogService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView listDogs(){
        ModelAndView mav = new ModelAndView("dogs/dogs");
        mav.addObject("title", "Our Dogs");
        mav.addObject("dogs", service.getAllDogs());
        return mav;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddDogForm(Model model) {
        model.addAttribute("title", "Add Dog");
        model.addAttribute("breeds", service.getBreeds());
        model.addAttribute(new Dog());
        return "dogs/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddDogForm(@ModelAttribute Dog newDog,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Dog");
            return "dogs/add";
        }

        service.addDog(newDog);
        return "redirect:list";
    }
}
