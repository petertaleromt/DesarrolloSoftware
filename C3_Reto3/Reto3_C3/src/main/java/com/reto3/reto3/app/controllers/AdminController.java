/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.controllers;

import com.reto3.reto3.app.entities.Admin;
import com.reto3.reto3.app.services.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author peter.talero
 */
@RestController
@RequestMapping("Admin")
public class AdminController {
    
    @Autowired
    private AdminService service;
    
    @GetMapping("/all")
    public List<Admin> findAllAdmin(){
        return service.getAdmins();
    }
    
    @PostMapping("/save")
    public ResponseEntity addAdmin(@RequestBody Admin admin){
        service.saveAdmin(admin);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateAdmin(@RequestBody Admin admin){
        service.updateAdmin(admin);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable("id") Integer id){
        service.deleteAdmin(id);
        return ResponseEntity.status(204).build();
    } 
}
