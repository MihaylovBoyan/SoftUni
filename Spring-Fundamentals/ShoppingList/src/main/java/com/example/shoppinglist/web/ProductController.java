package com.example.shoppinglist.web;

import com.example.shoppinglist.model.binding.AddProductBindingModel;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/buy/all")
    public String buyAll(){

        productService.buyAll();

        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable Long id){

        productService.buyProduct(id);

        return "redirect:/";
    }


    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){

        if(httpSession.getAttribute("user") == null){
            return "redirect:/login";
        }

        if(!model.containsAttribute("addProductBindingModel")){

            model.addAttribute("addProductBindingModel",new AddProductBindingModel());

        }

        return "product-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid AddProductBindingModel addProductBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, HttpSession httpSession){


        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("addProductBindingModel", addProductBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProductBindingModel", bindingResult);


            return "redirect:add";
        }

        productService.addProduct(modelMapper.map(addProductBindingModel, ProductServiceModel.class));


        return "redirect:/";
    }

}
