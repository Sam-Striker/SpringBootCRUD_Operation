package com.samuel.car_SpringProj.service;

import com.samuel.car_SpringProj.model.Car;
import java.util.List;
import java.util.Optional;


public interface Car_interface {
    List<Car> getCars();
    Optional<Car> getCar(int id);
    Car save(Car imodoka);
    Car update(Car imodoka);
    String delete(int id);

}
