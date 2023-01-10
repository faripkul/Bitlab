package com.example.demo.controller.testZad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String home(){
        return "home";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }

}
