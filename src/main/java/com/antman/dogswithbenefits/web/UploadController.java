package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    private static String UPLOAD_FOLDER = "src/main/resources/static/images/";
    private static String SOURCE_PATH = "/images/";
    private DogService dogService;

    @Autowired
    public UploadController(DogService dogService) {
        this.dogService = dogService;
    }

//    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("dogId") int dogId,
                                   HttpServletRequest request,
                                   RedirectAttributes redirectAttributes,
                                   Model model) {

        String referer = request.getHeader("referer");
        String origin = request.getHeader("origin");
        String viewName = referer.replace(origin, "");

        String redirectionPath = "redirect:" + viewName;
        System.out.println("---->>> HTTP VIEW: " + viewName);

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("errormessage", "Please select an image to upload");
            return redirectionPath;
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" +
                    file.getOriginalFilename() + "'");

            Dog dog = dogService.fingById(dogId);
            String photoLocation = SOURCE_PATH + file.getOriginalFilename();
            Photo photo = new Photo(dog, photoLocation);
            dogService.addPhoto(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return redirectionPath;
    }

}
