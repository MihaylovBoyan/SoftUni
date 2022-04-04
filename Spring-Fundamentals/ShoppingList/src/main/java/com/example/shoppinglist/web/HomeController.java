package com.example.shoppinglist.web;

import com.example.shoppinglist.model.entity.enums.CategoryNameEnum;
import com.example.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){

        if(httpSession.getAttribute("user") == null ){
            return "index";
        }

        model.addAttribute("totalSum", productService.findTotalProductsSum());
        model.addAttribute("drinks", productService.findAllProductsByCategoryName(CategoryNameEnum.DRINK));
        model.addAttribute("food", productService.findAllProductsByCategoryName(CategoryNameEnum.FOOD));
        model.addAttribute("households", productService.findAllProductsByCategoryName(CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("others", productService.findAllProductsByCategoryName(CategoryNameEnum.OTHER));

        return "home";
    }


}
