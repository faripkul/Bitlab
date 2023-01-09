package com.example.demo.controller.task1;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeContoller {
    @GetMapping(value = "/itemss")
    public String home(Model model){
        ArrayList<Items> items = DBManager.getItems();
        model.addAttribute("itemz", items);
        return "/task1/items";
    }

    @PostMapping(value = "/addItem")
    public String addItem(){


    }

}
