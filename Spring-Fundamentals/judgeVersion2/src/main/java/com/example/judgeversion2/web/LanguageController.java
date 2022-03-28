package com.example.judgeversion2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LanguageController {

    private final String defaultLang = "bg";
    private final List<String> allLang = List.of("en", "bg", "de");

    @PostMapping("/save")
    public String save(@RequestParam String lang,
                       //HttpServletResponse response){
    HttpSession httpSession){

//        Cookie cookie = new Cookie("langCookie", lang);
//        response.addCookie(cookie);

        httpSession.setAttribute("lang", lang);

        return "redirect:/all";
    }

    @GetMapping("/all")
    public String allLangs(Model model, HttpSession httpSession
                  //         ,@CookieValue(value = "langCookie", required = false, defaultValue = defaultLang) String lang)
    )
    {

   //    model.addAttribute("preferredLang", lang);
        Object preferredLang = httpSession.getAttribute("lang");
        if(preferredLang == null){
            preferredLang = defaultLang;
        }

        model.addAttribute("all", allLang);

        return "languages";
    }

}
