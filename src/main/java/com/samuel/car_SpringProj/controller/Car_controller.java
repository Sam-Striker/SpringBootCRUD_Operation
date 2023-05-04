package com.samuel.car_SpringProj.controller;


import com.samuel.car_SpringProj.model.Car;
import com.samuel.car_SpringProj.service.Car_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/24239/car")
public class Car_controller {

    @Autowired
    private Car_service car_service;

    @PostMapping("/save")
    public Car addCar(@RequestBody Car imodoka){
        return car_service.save(imodoka);
    }

    @GetMapping(path = "/find/{id}")
    public Optional<Car> getCar(@PathVariable int id) {
        return car_service.getCar(id);
    }

    @PutMapping(path ="/update")
    public Car updateCar(@RequestBody Car imodoka){
        return car_service.update(imodoka);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCar(@PathVariable int id){
        return car_service.delete(id);
    }

    @GetMapping(path = "/listall")
    public List<Car> listCars() {
        return car_service.getCars();
    }


    public Car_service getCar_service() {
        return car_service;
    }
    public void setCar_service(Car_service car_service) {
        this.car_service = car_service;
    }
}
