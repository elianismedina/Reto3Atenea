/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repositorio.CRUD;

import com.example.demo.Modelo.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);
    public List<Reservation> findAllByStatus(String status);
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();


    
}
