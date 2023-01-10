package com.example.demo.controller.task1;


import com.example.demo.beans.Somebean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @Autowired

  private Somebean somebean;

    @GetMapping(value = "/other-bean")
    public String otherBean(Model model){

        model.addAttribute("result", somebean.getData());
        return "/testZad/test";
    }

    @GetMapping(value = "/change-data")
    public String changeData(){
        somebean.setName("Leo");
        somebean.setAmount(66);
        return "redirect:/other-bean";
    }

}
