/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto_3.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import Reto3.Reto_3.modelo.Cloud;
import Reto3.Reto_3.servicios.ServiciosCloud;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/Cloud")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebCloud {
    
    @GetMapping("/helloWorld")
    public String saludad(){
    return "Hello Melissa Herrera";
    }
    
    @Autowired
    private ServiciosCloud servicio;
    @GetMapping("all")
    public List <Cloud> getCloud(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Cloud> getCloud(@PathVariable("id") int idCloud) {
        return servicio.getCloud(idCloud);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud save(@RequestBody Cloud cloud) {
        return servicio.save(cloud);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cloud update(@RequestBody Cloud cloud) {
        return servicio.update(cloud);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int cloudId) {
        return servicio.deleteCloud(cloudId);
    }
    
}
