/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.cibertec.service;

import edu.cibertec.beans.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Nicolas Cruz https://profesionaljava.com
 */
/*@Service
@DependsOn(value = {
        "vehiculoAutomovil",
        "vehiculoAutobus"
    })*/
public class VehiculoService {
    @Autowired
    @Qualifier("vehiculoAutomovil")
    private Vehiculo vehiculo;

    public VehiculoService() {
    }
    
    @Autowired
    public VehiculoService(@Qualifier("vehiculoAutomovil") Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public void imprimirDocumento(){
        System.out.println(this.vehiculo.imprimir()); 
    }

    public Vehiculo getVehiculo() {
        return  this.vehiculo;
    }

    public void setDocumento(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
