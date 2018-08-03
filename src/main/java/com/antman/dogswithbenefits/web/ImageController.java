package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ImageController {
    private DogService dogService;

    @Autowired
    public ImageController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/attach")
    public String attachImage(@ModelAttribute(name = "path") String path,
            @RequestParam("dogId") int dogId,
                              RedirectAttributes redirectAttributes,
                              HttpServletRequest request) {

        String referer = request.getHeader("referer");
        String origin = request.getHeader("origin");
        String viewName = referer.replace(origin, "");

        String redirectionPath = "redirect:" + viewName;
        System.out.println("---->>> HTTP VIEW: " + viewName);

        if (path != null && path.length() == 0) {
            redirectAttributes.addFlashAttribute("errormessage", "Please select an image to upload");
            return redirectionPath;
        }

        try {
            redirectAttributes.addFlashAttribute("message", "Your image has been successfully uploaded");
            Dog dog = dogService.fingById(dogId);
            Photo newPhoto = new Photo(dog, path);
            dogService.addPhoto(newPhoto);
        } catch (Exception e){
            System.out.println("There has been a problem");
        }

        return redirectionPath;
    }
}
