
package com.google.EjemploSpringData.repositorio;

import com.google.EjemploSpringData.modelo.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;

public interface IClienteRepository extends CrudRepository<Cliente, String>{

  @Query(value="SELECT c.*,cr.* FROM cliente c \n" +
"JOIN credencial cr ON c.credencial_correo=cr.correo WHERE cr.correo=? AND cr.contrasena=?",nativeQuery = true) 
  Cliente buscarPorNombre(String correo,String contra);
 //EL ORDEN DE LOS PARAMETROS IMPORTA, EL PRIMER '?' CORRESPONDE AL PRIMER PARAMETRO, Y ASÍ SUCESIVAMENTE
}
