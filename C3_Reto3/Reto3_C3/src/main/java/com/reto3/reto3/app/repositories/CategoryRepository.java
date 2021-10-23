/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.repositories;

import com.reto3.reto3.app.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author peter.talero
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
