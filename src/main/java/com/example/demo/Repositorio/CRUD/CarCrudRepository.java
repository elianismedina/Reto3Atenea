/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repositorio.CRUD;

import com.example.demo.Modelo.Car;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface CarCrudRepository extends CrudRepository<Car, Integer>{
    
}
