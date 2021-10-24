/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author peter.talero
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

/* -- Acceso Tabla Machine -- */
@Table(name="machine")
public class Machine implements Serializable{
   
    /* -- Estructura Tabla - Vista -- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=45)
    private String name;
    @Column(length=45)
    private String brand;
    private Integer year;
    @Column(length=250)
    private String description;
    
    /* -- Joins -- */
    @ManyToOne
    @JoinColumn(name = "categoryId")    
    @JsonIgnoreProperties("machines")
    private Category category;
    
    @Column (nullable=true) 
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="machine")
    @JsonIgnoreProperties({"machine", "client"})
    private List<Message> messages;
    
    @Column (nullable=true) 
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="machine")
    @JsonIgnoreProperties({"machine", "messages"})
    private List<Reservation> reservations;
}