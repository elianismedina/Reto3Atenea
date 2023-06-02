/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.DTOs.CompletedAndCancelled;
import com.example.demo.Modelo.DTOs.TotalAndClient;
import com.example.demo.Modelo.Reservation;
import com.example.demo.Repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    //Reporte1
    public List<Reservation> getReservationsBetweenDatesReport(String fechaA,String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);

        }catch (ParseException exception){
            exception.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    //Reporte 2
    public CompletedAndCancelled getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");

        Long cantidadCompletada = (long) completed.size();
        Long cantidadCancelada = (long) cancelled.size();

        CompletedAndCancelled respuesta = new CompletedAndCancelled(cantidadCompletada,cantidadCancelada);
        return respuesta;
    }
    //Reporte 3
    public  List<TotalAndClient> getTopClientsReport(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationRepository.getTotalReservationsByClient();

        for (Object[] pareja:reporte
             ) {
            respuesta.add(new TotalAndClient((Long) pareja[1],(Client) pareja[0]));
        }
        return respuesta;
    }



    
}

