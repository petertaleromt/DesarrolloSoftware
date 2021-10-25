/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.services;

import com.reto3.reto3.app.entities.Machine;
import com.reto3.reto3.app.repositories.MachineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter.talero
 */
@Service
public class MachineService {

    @Autowired
    private MachineRepository repository;

    /**
     *GET
     *@return
     */
    public List<Machine> getMachines() {
        return repository.findAll();
    }

    /**
     *POST
     *@param machine
     *@return
     */
    public Machine saveMachine(Machine machine) {
        return repository.save(machine);
    }
    
     /**
     *PUT
     *@param machine
     *@return
     */
    public Machine updateMachine(Machine machine) {
        Machine existingMachine = repository.findById(machine.getId()).orElse(null);
        existingMachine.setName(machine.getName());
        existingMachine.setBrand(machine.getBrand());
        existingMachine.setYear(machine.getYear());
        existingMachine.setDescription(machine.getDescription());
        return repository.save(existingMachine);
    }
    
    /**
    *DELETE
    *@param id
    */
    public void deleteMachine(int id){
        repository.deleteById(id);
    }
}