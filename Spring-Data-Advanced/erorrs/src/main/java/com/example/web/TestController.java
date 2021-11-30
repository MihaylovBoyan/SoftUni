package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping
    public String test() {

        if (true) {
            throw new NullPointerException("woo fuck it man");
        }

        return "hello";
    }

}
