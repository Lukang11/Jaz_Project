package com.example.demo.Controllers;

import com.example.demo.Contracts.WindshieldEntity;
import com.example.demo.Service.ShieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShieldViewController {

    private ShieldService shieldService;

    @Autowired
    public ShieldViewController(ShieldService shieldService) {
        this.shieldService = shieldService;
    }
    

    @GetMapping("windshield/add")
    public String showAddForm(Model model){
         model.addAttribute("windshield",new WindshieldEntity());
         return "shieldAdded";
    }
    @PostMapping("/formcompl")
    public String submitShieldAddForm(@ModelAttribute WindshieldEntity windshield,Model model){
        shieldService.save(windshield);
        model.addAttribute("windshield",new WindshieldEntity());
        return "shieldAdded";
    }
    @GetMapping("search")
    public String showSearchForm(Model model){
        model.addAttribute("windshield",new WindshieldEntity());
        return "searchView";
    }
}
