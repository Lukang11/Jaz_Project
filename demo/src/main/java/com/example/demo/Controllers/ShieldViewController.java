package com.example.demo.Controllers;

import com.example.demo.Contracts.WindshieldEntity;
import com.example.demo.Service.ShieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShieldViewController {

    private ShieldService shieldService;

    @Autowired
    public ShieldViewController(ShieldService shieldService) {
        this.shieldService = shieldService;
    }

    @GetMapping("/home")
    public String home(){
        return "hello";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
         model.addAttribute("windshield",new WindshieldEntity());
         return "shieldAdded";
    }
    @PostMapping("/formcompl")
    public String submitShieldAddForm(@ModelAttribute WindshieldEntity windshield,Model model){
        shieldService.save(windshield);
        model.addAttribute("windshield",new WindshieldEntity());
        return "shieldAddedComplete";
    }
    @GetMapping("/search")
    public String showSearchForm(@ModelAttribute  WindshieldEntity windshieldEntity, Model model){
        model.addAttribute("windshield",new WindshieldEntity());
        return "searchView";
    }
    @GetMapping("/all")
    public String getWindshield(Model model){
        model.addAttribute("windshield",shieldService.findAll());
        return "shields";
    }
    @PostMapping("/search")
    public String showSearchedList(@ModelAttribute  WindshieldEntity windshieldEntity, Model model){
        model.addAttribute("windshield", shieldService.returnListOfSearchedShield(windshieldEntity.getBrand()));
        return "shields";
    }
    @PostMapping("/searchWithModel")
    public String showSearchedWithModelList(@ModelAttribute  WindshieldEntity windshieldEntity, Model model){
        model.addAttribute("windshield", shieldService.returnListOfSearchedShield(
                windshieldEntity.getBrand(),
                windshieldEntity.getModel()));
        return "shields";
    }

}
