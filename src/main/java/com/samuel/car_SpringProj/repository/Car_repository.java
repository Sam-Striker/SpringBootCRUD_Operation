package com.samuel.car_SpringProj.repository;

import com.samuel.car_SpringProj.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Car_repository extends JpaRepository<Car, Integer> {

}
