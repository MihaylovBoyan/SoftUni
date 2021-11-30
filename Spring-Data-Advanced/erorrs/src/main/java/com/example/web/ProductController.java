package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/products/{id}/details")
    public String showDetails(@PathVariable("id") String productId){

        throw new ProductNotFoundException("product with id  " +  productId + " was not found");
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ModelAndView handleDbExceptions(ProductNotFoundException e ){
        ModelAndView modelAndView = new ModelAndView("product-not-found");
        modelAndView.addObject("message", e.getMessage());

        return modelAndView;

    }

}
