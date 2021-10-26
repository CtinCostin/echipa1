package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa1.entities.Continent;
import ro.sda.echipa1.service.ContinentService;
import ro.sda.echipa1.service.CountryService;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @Autowired
    private CountryService countryService;


    @GetMapping("/continent")
    public String showContinentsPage(Model model) {

        List<Continent> continentList = continentService.findAll();
        model.addAttribute("continentsInView", continentList);

        return "continent-list";
    }

    @GetMapping("/continent/add")
    public String showAddForm(Model model) {
        Continent newContinent = new Continent();
        model.addAttribute("continent", newContinent);
        model.addAttribute("countries",countryService.findAll());
        return "continent-add";
    }

    @PostMapping("/continent/add")
    public String addNewContinent(@Valid Continent continent, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "continent-add";
        }
        continentService.save(continent);
        return "redirect:/continent";
    }

    @GetMapping("/continent/{id}/delete")
    public String delete(@PathVariable Long id) {
        continentService.delete(id);
        return "redirect:/continent";
    }
}
