/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.model;

import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Rent {
    private Long id_renta;
    private String fecha_inicio;
    private String fecha_fin;
    private Double costo;
    private Long id_cliente;
    private Long id_empleado;
    private ArrayList<Long> equipos = new ArrayList<>();

    public Long getId_renta() {
        return id_renta;
    }

    public void setId_renta(Long id_renta) {
        this.id_renta = id_renta;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public ArrayList<Long> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Long> equipos) {
        this.equipos = equipos;
    }

    
    
    
}
