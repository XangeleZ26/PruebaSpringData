
package com.google.EjemploSpringData.repositorio;

import com.google.EjemploSpringData.modelo.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IVehiculosRepository extends CrudRepository<Vehiculo, String>{
    @Query(value="SELECT v.* FROM vehiculos v JOIN cuenta cu ON cu.dia_creacion=v.cuenta_dia JOIN cliente c ON c.cuenta_dia=cu.dia_creacion JOIN credencial cr ON cr.correo=c.credencial_correo WHERE c.nombres=?",nativeQuery = true) 
  List<Vehiculo> buscarVehiculos(String name);
    
}
