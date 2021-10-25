/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.services;

import com.reto3.reto3.app.entities.Reservation;
import com.reto3.reto3.app.repositories.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter.talero
 */
@Service
public class ReservationService {
     
    @Autowired
    private ReservationRepository repository;

    /**
     *GET
     *@return
     */
    public List<Reservation> getReservations() {
        return repository.findAll();
    }
    /**
     *POST
     *@param reservation
     *@return
     */
    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }
    
    /**
    *PUT
    *@param reservation
    *@return
    */
    public Reservation updateReservation(Reservation reservation) {
        Reservation existingReservation = repository.findById(reservation.getIdReservation()).orElse(null);
        existingReservation.setStartDate(reservation.getStartDate());
        existingReservation.setDevolutionDate(reservation.getDevolutionDate());
        return repository.save(existingReservation);
    }
    
    /**
    *DELETE
    *@param id
    *@return
    */
    public String deleteReservation(int id){
        repository.deleteById(id);
        return "Mensaje eliminado" + id;
    }    
}
