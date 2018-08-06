package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/dogs")
public class DogWebController {
    private DogService service;

    @Autowired
    public DogWebController(DogService service) {
        this.service = service;
    }

    @GetMapping("/list/{page}")
    public ModelAndView listDogs(@PathVariable(name = "page", required=false) Optional<Integer> pageNumber){
        ModelAndView mav = new ModelAndView("dogs/dogs");
        mav.addObject("title", "Our Dogs");
        if(pageNumber.isPresent()){
            mav.addObject("dogs", service.getPageOfDogs(1));
        } else {
            int page = pageNumber.get();
            mav.addObject("dogs", service.getPageOfDogs(page));
        }
//        mav.addObject("dogs", service.getAllDogs());
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteDog(@PathVariable("id") int dogId, Model model) {
        String deleteMessage = "Dog has been successfully deleted";
        service.delete(dogId);
        model.addAttribute("deleteMessage", deleteMessage);
        return "redirect:/dogs/list";
    }

    @GetMapping("/dog_profile")
    public ModelAndView dogProfileIndex(@RequestParam("dogId") int dogId){
        Dog dog = service.fingById(dogId);
        ModelAndView mav = new ModelAndView("dogs/dog_profile");

        mav.addObject("dog", dog);
        mav.addObject("title", dog.getName());
        mav.addObject("newPhoto", new Photo(dog, null));

        return mav;
    }
}
