/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.services;


import com.reto3.reto3.app.entities.Client;
import com.reto3.reto3.app.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author peter.talero
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;

    /**
     *GET
     *@return
     */
    public List<Client> getClients() {
        return repository.findAll();
    }

    /**
     *POST
     *@param client
     *@return
     */
    public Client saveClient(Client client) {
        return repository.save(client);
    }  
}
