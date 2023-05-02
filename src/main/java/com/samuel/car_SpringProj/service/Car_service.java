package com.samuel.car_SpringProj.service;
import com.samuel.car_SpringProj.model.Car;
import com.samuel.car_SpringProj.repository.Car_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Car_service implements Car_interface{


    private final Car_repository car_repo;
    @Autowired
    public Car_service(Car_repository car_repo) {
        this.car_repo = car_repo;
    }

    @Override
    public List<Car> getCars() {
        return car_repo.findAll();
    }

    @Override
    public Optional<Car> getCar(int id) {
        return car_repo.findById(id);
    }

    @Override
    public Car save(Car imodoka) {
        return car_repo.save(imodoka);
    }

    @Override
    public Car update(Car imodoka) {
        Car imo = car_repo.findById(imodoka.getId()).get();

        imo.setPlateNumber(imodoka.getPlateNumber());
        imo.setName(imodoka.getName());
        imo.setModel(imodoka.getModel());
        imo.setType(imodoka.getType());

        return car_repo.save(imo);
    }


    @Override
    public String delete(int id) {
         car_repo.deleteById(id);
         return "Entity Delete" + id;
    }
}
























//
//public class Car_service {
//
//    @Autowired
//    private Car_repository car_repository;
//
//    public Car save(Car imodoka) {
//        return car_repository.save(imodoka);
//    }
//
//    public Car getCar(int id) {
////        return car_repository.findById(id).get();
//        return car_repository.findById(id).get();
//
//    }
//
//    public List<Car> list(){
//        return car_repository.findAll();
//    }
//
//    public Car update(Car imodoka) {
//        Car imo = car_repository.findById(imodoka.getId()).get();
//
//        imo.setPlateNumber(imodoka.getPlateNumber());
//        imo.setName(imodoka.getName());
//        imo.setModel(imodoka.getModel());
//        imo.setType(imodoka.getType());
//
//        return car_repository.save(imo);
//    }
//
//    public String delete(int id) {
//         car_repository.deleteById(id);
//         return "Entity Delete" + id;
//    }
//
//
//    public Car_repository getCar_repository() {
//        return car_repository;
//    }
//    public void setCar_repository(Car_repository car_repository) {
//        this.car_repository = car_repository;
//    }
//
//
//
//}
