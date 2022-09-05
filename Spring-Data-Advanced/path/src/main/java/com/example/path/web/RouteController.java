package com.example.path.web;

import com.example.path.model.binding.RouteAddBindingModel;
import com.example.path.model.service.RouteServiceModel;
import com.example.path.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final ModelMapper modelMapper;

    public RouteController(RouteService routeService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String routes(Model model){


        model.addAttribute("routes", routeService.findAllRoutesView());

        return "routes";
    }

    @GetMapping("/add")
    public String addRoute(){

//        if(currentUser.getId() == null){
//            return "redirect:/users/login";
//        }


        return "add-route";
    }

    @PostMapping("/add")
    public String addRouteConfirm(@Valid RouteAddBindingModel routeAddBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("routeAddBindingModel", routeAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.routeAddBindingModel", bindingResult);

            return "redirect:add";
        }
        RouteServiceModel routeServiceModel = modelMapper.map(routeAddBindingModel, RouteServiceModel.class);
        routeServiceModel.setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));


        routeService.addNewRoute(routeServiceModel);

        return "redirect:all";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model){

        model.addAttribute("route", routeService.findRouteById(id));

        return "route-details";
    }



    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel(){
        return new RouteAddBindingModel();
    }

}
