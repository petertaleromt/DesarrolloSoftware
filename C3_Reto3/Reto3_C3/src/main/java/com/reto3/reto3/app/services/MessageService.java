/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.services;

import com.reto3.reto3.app.entities.Message;
import com.reto3.reto3.app.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter.talero
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository repository;
    
    /**
     *GET
     *@return
     */
    public List<Message> getMessages(){
        return repository.findAll();
    }
    
    /**
     *POST
     *@param message
     *@return
     */
    public Message saveMessage(Message message){
         return repository.save(message);   
    }

    /**
    *PUT
    *@param message
    *@return
    */
    public Message updateMessage(Message message) {
        Message existingMessage = repository.findById(message.getIdMessage()).orElse(null);
        existingMessage.setMessageText(message.getMessageText());
        return repository.save(existingMessage);
    }
    
    /**
    *DELETE
    *@param id
    */
    public void deleteMessage(int id){
        repository.deleteById(id);
    }   
}
