package com.example.demo.Controllers;


import com.example.demo.Contracts.WindshieldEntity;
import com.example.demo.Service.ShieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//api layer



@RestController
@RequestMapping("api")
public class ShieldController {

    private ShieldService shieldService;

    @Autowired
    public ShieldController(ShieldService shieldService) {
        this.shieldService = shieldService;
    }

    @GetMapping("/hello")
    public String home(){
        return "Hello world";
    }
    @GetMapping("/all")
    public Iterable<WindshieldEntity> findAll(){
        return shieldService.findAll();
    }
    @GetMapping("/shield/{id}")
    public WindshieldEntity returnWindShield(@PathVariable String id){
        return shieldService.findById(id);
    }
    @PostMapping("/shield/add")
    public void addShieldToDB(@RequestBody WindshieldEntity windshieldEntity){
        shieldService.save(windshieldEntity);
    }
    @GetMapping("/shield/delete/{id}")
    public ResponseEntity<String> id(@PathVariable String id){
        if (shieldService.findById(id)==null){
            return new ResponseEntity<>("Unfortunatly we couldn't find windshield with that id", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("We have succsefully delted user ",HttpStatus.OK);
    }
}

