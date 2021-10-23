/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.services;

import com.reto3.reto3.app.entities.Category;
import com.reto3.reto3.app.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter.talero
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    /**
     *GET
     *@return
     */
    public List<Category> getCategorys() {
        return repository.findAll();
    }
    /**
     *POST
     *@param category
     *@return
     */
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

   
}
