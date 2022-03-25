package com.google.EjemploSpringData.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String fecha;

    private float monto;
    private String tipo;
    @Column(name = "estacion_nombre")
    private String nombreEstacion;

    @Column(name = "vehiculo_placa")
    private String vehiculoPlaca;
    
    @Transient
    private Vehiculo vehiculo;
    @Transient
    private Cuenta cuenta;

    public Movimiento(String fecha, float monto, String tipo, String nombreEstacion, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.vehiculo = vehiculo;
        this.nombreEstacion = nombreEstacion;
    }

    public Movimiento(String fecha, String tipo, float monto) {
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = fecha;

    }

    public Movimiento() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public String getVehiculoPlaca() {
        return vehiculoPlaca;
    }

    public void setVehiculoPlaca(String vehiculoPlaca) {
        this.vehiculoPlaca = vehiculoPlaca;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getNombreEstacion() {
        return nombreEstacion;
    }

    public void setNombreEstacion(String nombreEstacion) {
        this.nombreEstacion = nombreEstacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void mostrarBoleta(String fecha, float monto) {

    }

    /*
    public void agregarMovimiento(Date fecha, float monto) {
           
    }
     */
 /*
    @Override
    public String toString() {
        return  "***Datos del movimiento***" + "\n" +
                "Fecha: " + fecha + "\n" +
                "Monto: " + monto + "\n"
                "Vehiculo: " + vehiculo.getPlaca() + " " + vehiculo.getMarca() + " " + vehiculo.getModelo() + "\n" +
                "Estacion: " + estacion.getCodigoEstacion() + " " + estacion.getNombreEstacion();
    }
     */

    @Override
    public String toString() {
        return "Movimiento{" + "fecha=" + fecha + ", monto=" + monto + ", tipo=" + tipo + ", nombreEstacion=" + nombreEstacion + ", vehiculo=" + vehiculo.getPlaca() + '}';
    }

    public String imprimirMovimientoSimple() {
        if (this.vehiculo != null && this.nombreEstacion != null) {
            return "***Datos del movimiento***" + "\n"
                    + "Fecha: " + fecha + "\n"
                    + "Monto: " + monto + "\n"
                    + "Vehiculo: " + vehiculo.getPlaca() + " " + vehiculo.getMarca() + " " + vehiculo.getModelo() + "\n"
                    + "Estacion: " + nombreEstacion;
        } else if (this.vehiculo == null && this.nombreEstacion == null) {
            return "***Datos del movimiento***" + "\n"
                    + "Fecha: " + fecha + "\n"
                    + "Monto: " + monto;
        } else {
            return "El movimiento no existe";
        }
    }
}
