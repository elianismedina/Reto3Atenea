/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> findAll(){
    
        return (List<Reservation>) reservationCrudRepository.findAll();
        
    }
    
    public Optional<Reservation> getReservation(int id){
    
        return reservationCrudRepository.findById(id);
                
    }
    
    public Reservation save(Reservation reservation){
    
        return reservationCrudRepository.save(reservation);
        
    }
    
    public void delete(Reservation reservation){
    
        reservationCrudRepository.delete(reservation);
    }
    public List<Reservation> getReservationsBetweenDates(Date fechaA,Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA,fechaB);
    }

    public  List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public  List<Object[]> getTotalReservationsByClient(){
        return reservationCrudRepository.getTotalReservationsByClient();
    }

    
}

