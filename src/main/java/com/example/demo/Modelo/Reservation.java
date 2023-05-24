/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "reservation")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    
//Generamos los getters and setters

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //Car
    @ManyToOne
    @JoinColumn(name = "carId")
    @JsonIgnoreProperties("reservations")
    private Car car;
        
    //Client
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;
    
    //Score
    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;
    
    
    
    
}
