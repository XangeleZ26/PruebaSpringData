package com.google.EjemploSpringData;

import com.google.EjemploSpringData.modelo.Cliente;
import com.google.EjemploSpringData.modelo.Movimiento;
import com.google.EjemploSpringData.modelo.Vehiculo;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.EjemploSpringData.repositorio.*;

@SpringBootApplication
public class EjemploSpringDataApplication implements CommandLineRunner{

    @Autowired
    IClienteRepository personaDAO;
    @Autowired
    IVehiculosRepository vehiculosDAO;
    @Autowired
    IMovRepository movimientosDAO;
	public static void main(String[] args) {
		SpringApplication.run(EjemploSpringDataApplication.class, args);
                
	}

    @Override //esta función se implementa gracias a CommandLineRunner, dentro podemos escribir todo lo q deseamos que corra en el programa
    public void run(String... args) throws Exception {
        
    Cliente personales = new Cliente();
    
    //esto ya me da todo, incluido tarjeta
    personales=personaDAO.buscarPorNombre("jose@gmail.com","123");
    
    //para vehiculos (hubiera guardado datos usando la de @OneToMany o viceversa, pero considero que no me ayudaría pq supongo q afectaría al orden que tengo de los atributos, según el diagrama de clases antiguo de este proyecto
    List<Vehiculo> vehiculos=new ArrayList<>();
    vehiculos=vehiculosDAO.buscarVehiculos("jose");
    for(int i=0;i<vehiculos.size();i++){
        personales.getCuenta().getVehiculos().registrarVehiculo(vehiculos.get(i));
        personales.getCuenta().getVehiculos().getVehiculo(i).setDueño(personales);
    }
    
  
    //para movimientos
    List<Movimiento> movimientos=new ArrayList<>();
    movimientos=movimientosDAO.buscarMov("jose");
    
//    for(int i=0;i<movimientos.size();i++){
//        personales.getCuenta().getMovimientos().registrarMovimiento(movimientos.get(i));
//        personales.getCuenta().getVehiculos().getVehiculo(i).setDueño(personales);
//    }


      //PONGAMOS A PRUEBA LA REFERENCIACIÓN ENTRE OBJETOS
        personales.setNombres("Pedro");
    
 show(personales);
    
    
    
    //CON ESTO DEMOSTRAMOS QUE LOS VEHICULOS DE JOSE SE TRAJERON CON EXITO, SOLO FALTARÍA METERLOS DENTRO DE Cuenta, PERO ESO YA NO DEPENDE DE SPRING, LO HAREMOS MANUALMENTE
    //mostrarVehiculos(vehiculos);
    }
    
    
    
    //metodo
   private void show(Cliente personas) {
            System.out.println(personas.getNombres()+" "+personas.getCredencial().getContraseña()+" "+personas.getCredencial().getCorreo());
            System.out.println("CUENTA:");
            System.out.println(personas.getCuenta().getMesCreacion());
            System.out.println("DIRECCION:");
            System.out.println(personas.getDireccion().getDepartamento());
            System.out.println("TARJETA:");
            System.out.println(personas.getCuenta().getTarjeta().getMedioPago());
            System.out.println("VEHICULOS: ");
            System.out.println(personas.getCuenta().getVehiculos().getVehiculo(0).getMarca()+" "+personas.getCuenta().getVehiculos().getVehiculo(1).getAño()+" "+personas.getCuenta().getVehiculos().getVehiculo(1).getDueño().getNombres());
            System.out.println("MOVIMIENTOS:");
            
   }

}
