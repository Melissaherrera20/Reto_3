/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto_3.repositorio;

import Reto3.Reto_3.interfaces.Interface_Cloud;
import Reto3.Reto_3.modelo.Cloud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioCloud {
     @Autowired
    private Interface_Cloud crud;
    

    public List<Cloud> getAll(){
        return (List<Cloud>) crud.findAll();       
    }
    
    public Optional <Cloud> getCloud(int id){
        return crud.findById(id);
    }
    
    public Cloud save(Cloud cloud){
        return crud.save(cloud);
    }
      public void delete(Cloud cloud){
        crud.delete(cloud);
    }
    
}
