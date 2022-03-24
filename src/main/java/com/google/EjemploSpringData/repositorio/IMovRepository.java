
package com.google.EjemploSpringData.repositorio;

import com.google.EjemploSpringData.modelo.Movimiento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IMovRepository extends CrudRepository<Movimiento, String> {
    @Query(value="SELECT m.* FROM movimientos m JOIN cuenta cu ON cu.dia_creacion=m.cuenta_dia JOIN cliente c ON c.cuenta_dia=cu.dia_creacion JOIN credencial cr ON cr.correo=c.credencial_correo WHERE c.nombres=?",nativeQuery = true) 
  List<Movimiento> buscarMov(String name);
}
