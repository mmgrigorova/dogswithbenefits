package com.antman.dogswithbenefits.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, RedirectAttributes redirectAttributes) {

        String referer = request.getHeader("referer");
        String origin = request.getHeader("origin");
        String viewName = referer.replace(origin, "");

        String redirectionPath = "redirect:" + viewName;
        System.out.println("---->>> HTTP VIEW: " + viewName);

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select an image to upload");
            return redirectionPath;
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" +
                    file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return redirectionPath;
    }

}
