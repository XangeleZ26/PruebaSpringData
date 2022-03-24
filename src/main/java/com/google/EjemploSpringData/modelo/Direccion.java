
package com.google.EjemploSpringData.modelo;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String avenida;
    private String departamento;
    private String provincia;
    private String distrito;
    private int numero;
    private String referencia;
    private String telefono;

    public Direccion(){
        
    }
    
    public Direccion(String departamento, String provincia, String distrito, String avenida, int numero, String referencia, String telefono) {
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.avenida = avenida;
        this.numero = numero;
        this.referencia = referencia;
        this.telefono = telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "***Direccion de cliente***" + "\n" +
               "Departamento: " + departamento + "\n" +
               "Provincia: " + provincia + "\n" +
               "Distrito: " + distrito + "\n" +
               "Avenida: " + avenida + "\n" +
               "Numero: " + numero + "\n" +
               "Referencia: " + referencia + "\n" +
               "Telefono: " + telefono;
    }
    
}
