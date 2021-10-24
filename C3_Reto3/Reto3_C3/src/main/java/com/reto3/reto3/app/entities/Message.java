/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.reto3.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="message")
public class Message implements Serializable{
    
    /* -- Estructura Tabla - Vista -- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    @Column(length=250)
    private String messageText;
    
    /* -- Joins -- */
    @ManyToOne
    @JoinColumn(name="machineId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Machine machine;
    
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;
}
