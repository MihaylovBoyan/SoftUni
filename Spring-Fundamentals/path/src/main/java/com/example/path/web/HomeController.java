package com.example.path.web;

import com.example.path.model.entity.Picture;
import com.example.path.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final PictureService pictureService;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("pictures", pictureService.findAllUrls());

        return "index";
    }


    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
