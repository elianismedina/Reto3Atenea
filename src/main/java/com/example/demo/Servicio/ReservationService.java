/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
    
        return reservationRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
    
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null) {
          return reservationRepository.save(reservation);
            
        } else {
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isEmpty()) {
                return reservationRepository.save(reservation);                
            } else {
                return reservation;
            }
            
        }
        
    }
    public Reservation update(Reservation reservation){
    
        if (reservation.getIdReservation()!=null) {
            
            Optional<Reservation> reservationEncontrado = getReservation(reservation.getIdReservation());
            if (reservationEncontrado.isPresent()) {
                
                if (reservation.getStartDate()!=null) {
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());                    
                }
                if (reservation.getDevolutionDate()!=null) {
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());                    
                }
                if (reservation.getStatus()!=null) {
                    reservationEncontrado.get().setStatus(reservation.getStatus());                    
                }
                return reservationRepository.save(reservationEncontrado.get());
                
            } else{
                return reservation;
            }            
        }else{        
            return reservation;
        }
    }
    public boolean deleteReservation(int id){
        Boolean respuesta = getReservation(id).map(reservation ->{
          reservationRepository.delete(reservation);
          return true;
        }).orElse(false);
        
        return respuesta;        
    }
    
}

