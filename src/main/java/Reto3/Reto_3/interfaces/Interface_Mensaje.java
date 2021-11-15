/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3.Reto_3.interfaces;

import Reto3.Reto_3.modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface Interface_Mensaje extends CrudRepository<Mensaje,Integer> {
    
}
