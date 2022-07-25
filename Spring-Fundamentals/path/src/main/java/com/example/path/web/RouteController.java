package com.example.path.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/routes")
    public String routes(){


        return "routes";
    }

}
