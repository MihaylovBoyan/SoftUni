package com.example.andreys.web;

import com.example.andreys.model.binding.ItemAddBindingModel;
import com.example.andreys.model.service.ItemServiceModel;
import com.example.andreys.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemsController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addItem(Model model) {

        if(!model.containsAttribute("itemAddBindingModel")){

            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());

            return "add-item";
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addItemConfirm(@Valid @ModelAttribute ItemAddBindingModel itemAddBindingModel, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel",bindingResult);

            return "redirect:add";
        }

        itemService.addItem(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") Long id, ModelAndView modelAndView){

        modelAndView.addObject("item", itemService.findById(id));
        modelAndView.setViewName("details-item");
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){

        itemService.delete(id);

        return "redirect:/";

    }

}
