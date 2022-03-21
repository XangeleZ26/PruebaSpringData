package com.google.EjemploSpringData;

import com.google.EjemploSpringData.modelo.Persona;
import com.google.EjemploSpringData.repositorio.IPersonaDAO;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemploSpringDataApplication implements CommandLineRunner{

    @Autowired
    IPersonaDAO personaDAO;
    
	public static void main(String[] args) {
		SpringApplication.run(EjemploSpringDataApplication.class, args);
                
	}

    @Override //esta función se implementa gracias a CommandLineRunner, dentro podemos escribir todo lo q deseamos que corra en el programa
    public void run(String... args) throws Exception {
        
    Persona personales = new Persona();

    personales=personaDAO.buscarPorNombre("Juan");
    show(personales);
    
    }
    
    
    
    //metodo
   private void show(Persona personas) {
            System.out.println(personas.getApellido());
  }
}
