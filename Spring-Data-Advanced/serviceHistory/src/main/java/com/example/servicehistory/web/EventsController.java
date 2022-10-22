package com.example.servicehistory.web;

import com.example.servicehistory.model.binding.EventBindingModel;
import com.example.servicehistory.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EventsController {

    private final CarService carService;

    public EventsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{id}/events")
    public String events(@PathVariable Long id, Model model){

        model.addAttribute("car", carService.findById(id));

        return "events";
    }

    @GetMapping("/events/add")
    public String addEvent(){

        return "event-add";
    }

    @PostMapping("/events/add")
    public String addConfirm(@Valid EventBindingModel eventBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){



        return "redirect:/cars/all";
    }

    @ModelAttribute
    public EventBindingModel eventBindingModel(){
        return new EventBindingModel();
    }

}
