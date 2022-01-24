package com.example.demo.Service;

import com.example.demo.Contracts.WindshieldEntity;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShieldService {

    private ShieldRepository shieldRepository;

    public ShieldService(ShieldRepository shieldRepository) {
        this.shieldRepository = shieldRepository;
    }

    public WindshieldEntity findById(String id){

        return shieldRepository.findById(Integer.parseInt(id));
    }
    public Iterable<WindshieldEntity> findAll(){
        return shieldRepository.findAll();
    }
    public WindshieldEntity  save(WindshieldEntity windshieldEntity){
       return shieldRepository.save(windshieldEntity);
    }
    public void deleteById(String id){

        shieldRepository.deleteById(Integer.parseInt(id));
    }
    public List<WindshieldEntity> getShieldFromRepo(){
        return shieldRepository.findAll();
    }
    public List<WindshieldEntity> returnListOfSearchedShield(String brand){
        return shieldRepository.findAll().stream()
                .filter(x->x.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
    public List<WindshieldEntity> returnListOfSearchedShield(String brand,String model){
        return shieldRepository.findAll().stream()
                .filter(x->x.getBrand().equalsIgnoreCase(brand))
                .filter(x->x.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new WindshieldEntity(1,1234,"BMW","E45","GREEN",713.1));
        save(new WindshieldEntity(2,1235,"Mercedes","c245","GREEN",813.1));
    }
}
