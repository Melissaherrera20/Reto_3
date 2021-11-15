/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto_3.servicios;

import Reto3.Reto_3.modelo.Cloud;
import Reto3.Reto_3.repositorio.RepositorioCloud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServiciosCloud {
     @Autowired
    private RepositorioCloud metodosCrud;
    
    public List<Cloud> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Cloud> getCloud(int idCloud){
        return metodosCrud.getCloud(idCloud);
    }
    
    public Cloud save(Cloud cloud){
        if(cloud.getId()==null){
            return metodosCrud.save(cloud);
        }else{
            Optional<Cloud> evt=metodosCrud.getCloud(cloud.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cloud);
            }else{
                return cloud;
            }
        }
    }
    public Cloud update(Cloud cloud){
        if(cloud.getId()!=null){
            Optional<Cloud> e=metodosCrud.getCloud(cloud.getId());
            if(!e.isEmpty()){
                if(cloud.getName()!=null){
                    e.get().setName(cloud.getName());
                }
                if(cloud.getBrand()!=null){
                    e.get().setBrand(cloud.getBrand());
                }
                if(cloud.getYear()!=null){
                    e.get().setYear(cloud.getYear());
                }
                if(cloud.getDescription()!=null){
                    e.get().setDescription(cloud.getDescription());
                }
                if(cloud.getCategory()!=null){
                    e.get().setCategory(cloud.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cloud;
            }
        }else{
            return cloud;
        }
    }
    
    public boolean deleteCloud(int cloudId) {
        Boolean aBoolean = getCloud(cloudId).map(cloud -> {
            metodosCrud.delete(cloud);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
