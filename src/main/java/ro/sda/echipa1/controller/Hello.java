//package ro.sda.echipa1.controller;
//
//import jdk.jfr.Registered;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import ro.sda.echipa1.service.AirportService;
//import ro.sda.echipa1.service.CountryService;
//
//import java.time.LocalDate;
//
//@Controller
//
//public class Hello {
//
//    @Autowired
//    private CountryService countryService;
//
////    @GetMapping("/test")
////    public String testMethod() {
////        return "user-select-tour-offer";
////    }
//
//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        Hello hello = new Hello();
//        model.addAttribute("countries", countryService.findAll());
//        model.addAttribute("departureDate", LocalDate.now());
//        model.addAttribute("dateOfReturn", LocalDate.now());
//    return hello.testMethod();
//    }
//
//}


