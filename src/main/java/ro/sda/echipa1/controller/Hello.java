package ro.sda.echipa1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {
    @GetMapping("/test")
    public String testMethod(){
        return "user-select-tour-offer";
    }

}


