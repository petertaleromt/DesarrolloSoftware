/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.services;

import com.reto3.reto3.app.entities.Admin;
import com.reto3.reto3.app.repositories.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter.talero
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository repository;

    /**
     *GET
     *@return
     */
    public List<Admin> getAdmins() {
        return repository.findAll();
    }
    /**
     *POST
     *@param admin
     *@return
     */
    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }
    
    /**
    *PUT
    *@param admin
    *@return
    */
    public Admin updateAdmin(Admin admin) {
        Admin existingAdmin = repository.findById(admin.getIdAdmin()).orElse(null);
        existingAdmin.setName(admin.getName());
        existingAdmin.setPassword(admin.getPassword());
        return repository.save(existingAdmin);
    }
    
    /**
    *DELETE
    *@param id
    */
    public void deleteAdmin(int id){
        repository.deleteById(id);
    }
}
