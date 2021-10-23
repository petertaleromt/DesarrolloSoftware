/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.repositories.crud;
import com.reto3.reto3.app.entities.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author peter.talero
 */
public interface ScoreCrudRepository extends CrudRepository <Score, Integer>{
    
}
