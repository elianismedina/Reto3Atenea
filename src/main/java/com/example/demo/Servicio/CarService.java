/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Car;
import com.example.demo.Repositorio.CarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;
    
    public List<Car> getAll(){
    
        return carRepository.findAll();
    }
    public Optional<Car> getCar(int id){
    
        return carRepository.getCar(id);
    }
    public Car save(Car car){
        if(car.getIdCar()==null) {
          return carRepository.save(car);
            
        } else {
            Optional<Car> carEncontrado = getCar(car.getIdCar());
            if (carEncontrado.isEmpty()) {
                return carRepository.save(car);                
            } else {
                return car;
            }
            
        }
        
    }
    public Car update(Car car){
    
        if (car.getIdCar()!=null) {
            
            Optional<Car> carEncontrado = getCar(car.getIdCar());
            if (carEncontrado.isPresent()) {
                if (car.getName()!=null) {
                    carEncontrado.get().setName(car.getName());                    
                }
                if (car.getBrand()!=null) {
                    carEncontrado.get().setBrand(car.getBrand());
                }
                if (car.getYear()!=null) {
                    carEncontrado.get().setYear(car.getYear());                    
                }
                if (car.getDescription()!=null) {
                    carEncontrado.get().setDescription(car.getDescription());                    
                }
                return carRepository.save(carEncontrado.get());
                
            } else{
                return car;
            }            
        }else{        
            return car;
        }
    }
    public boolean deleteCar(int id){
        Boolean respuesta = getCar(id).map(car ->{
          carRepository.delete(car);
          return true;
        }).orElse(false);
        
        return respuesta;        
    }
}

