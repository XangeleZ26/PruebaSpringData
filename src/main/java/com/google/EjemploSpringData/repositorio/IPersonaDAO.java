
package com.google.EjemploSpringData.repositorio;

import com.google.EjemploSpringData.modelo.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDAO extends CrudRepository<Persona,Long>{
    
    @Query(value="SELECT p.* FROM personas p WHERE p.id_persona=?",nativeQuery = true) //nativeQuery se pone cuando usamos sintaxis explicita de SQL, como el "*"
  List<Persona> buscarPorId(int id);
  
  @Query(value="SELECT p.* FROM personas p WHERE p.nombre=?",nativeQuery = true) 
  Persona buscarPorNombre(String name);
}
