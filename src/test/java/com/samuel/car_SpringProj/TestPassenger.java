package com.samuel.car_SpringProj;

import com.samuel.car_SpringProj.model.Car;
import com.samuel.car_SpringProj.service.Car_interface;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPassenger {


    private Car_interface car_service;
    @Autowired
    public TestPassenger(Car_interface car_service) {
        this.car_service = car_service;
    }


    @Test
    @Order(1)
    public void test_Save(){
        Car imodoka = new Car();
        imodoka.setPlateNumber(2222);
        imodoka.setName("Samuel");
        imodoka.setModel("Mupagasi");
        imodoka.setType("yamaha");

        Car savedCar =  car_service.save(imodoka);
        assertEquals("Samuel", savedCar.getName());
    }

    @Test
    @Order(2)
    public void test_Update(){

        Optional<Car> optionalCar = car_service.getCar(3);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            car.setName("Updated Samuel");
            car_service.update(car);

            Optional<Car> updatedCar = car_service.getCar(3);
            assertTrue(updatedCar.isPresent());
            assertEquals("Updated Samuel", updatedCar.get().getName());
        } else {
            fail("Car not found");
        }

    }

    @Test
    @Order(3)
    public void test_FindAll(){
        List<Car> imodoka = car_service.getCars();

        assertEquals(1, imodoka.size());
    }

    @Test
    @Order(4)
    public void test_FindById(){
        Optional<Car> imodoka = car_service.getCar(3);

        assertNotNull(imodoka);
        assertEquals("Updated Samuel", imodoka.get().getName());
    }

    @Test
    @Order(5)
    public void test_Delete(){
        Optional<Car> imodoka = car_service.getCar(3);

        car_service.delete(3);
        Optional<Car> deletedCar = car_service.getCar(3);
        assertFalse(deletedCar.isPresent());
    }


}
