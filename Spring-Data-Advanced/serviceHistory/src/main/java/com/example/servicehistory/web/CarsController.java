package com.example.servicehistory.web;

import com.example.servicehistory.model.binding.CarAddBindingModel;
import com.example.servicehistory.model.binding.CarUpdateBindingModel;
import com.example.servicehistory.model.service.CarAddServiceModel;
import com.example.servicehistory.model.view.CarView;
import com.example.servicehistory.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CarsController {

    private final CarService carService;
    private final ModelMapper modelMapper;

    public CarsController(CarService carService, ModelMapper modelMapper) {
        this.carService = carService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/cars/all")
    public String cars(Model model) {

        model.addAttribute("cars", carService.findAllCars());

        return "cars";
    }


    @GetMapping("/cars/add")
    public String addCar() {
        return "car-add";
    }

    @GetMapping("/cars/{id}/details")
    public String details(@PathVariable Long id, Model model) {

        model.addAttribute("car", carService.findById(id));

        return "details";
    }

    @PostMapping("/cars/add")
    public String postCar(@Valid CarAddBindingModel carAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("carAddBindingModel", carAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.carAddBindingModel", bindingResult);

            return "redirect:/cars/add";
        }

        carService.saveCar(carAddBindingModel);

        return "redirect:/cars/all";
    }

    @ModelAttribute
    public CarAddBindingModel carAddBindingModel() {
        return new CarAddBindingModel();
    }

    @GetMapping("/cars/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {

        CarView carView = carService.findById(id);

        model.addAttribute("car", carView);

        return "update";
    }

    @GetMapping("/cars/{id}/edit/errors")
    public String editCarErrors(@PathVariable Long id, Model model) {

        return "update";
    }

    @PutMapping("/cars/{id}/edit")
    public String editCar(@PathVariable Long id, @Valid CarUpdateBindingModel car, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("car", car);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.car", bindingResult);

            return "redirect:/cars/" + id + "/edit/errors";
        }

        CarAddServiceModel updatedCar = modelMapper.map(car, CarAddServiceModel.class);
        updatedCar.setId(id);
        carService.updateCar(updatedCar);

        return "redirect:/cars/all";
    }


    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable Long id) {

        carService.deleteById(id);

        return "redirect:/cars/all";
    }


}
