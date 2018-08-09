package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.SearchParams;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class SearchController {
    private DogService dogService;

    @Autowired
    public SearchController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/search")
    public String getSearchForm(Model model){
        model.addAttribute("params",new SearchParams());
        return "search";
    }
    @PostMapping("/search")
    public String searchSubmit(@ModelAttribute SearchParams params, Model model){
       List<Dog> dogs = dogService.searchFilter(params.getSearchInput(), params.getSearchType());

        for (Dog dog: dogs)
        {
            System.out.print(dog.getName());
        }
        model.addAttribute("params",new SearchParams());
        //model.addAttribute("dogs", dogs);
        return "search";
    }

}
