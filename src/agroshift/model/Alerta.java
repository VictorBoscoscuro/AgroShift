/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.model;

/**
 *
 * @author victo
 */
public class Alerta {
    
    private Long id_alerta;
    private String nombre;
    private String descripcion;
    private String fecha_creacion;
    private String fecha_inicio_en_curso;
    private String fecha_fin;
    private boolean visualizada;

    public Long getId_alerta() {
        return id_alerta;
    }

    public void setId_alerta(Long id_alerta) {
        this.id_alerta = id_alerta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_inicio_en_curso() {
        return fecha_inicio_en_curso;
    }

    public void setFecha_inicio_en_curso(String fecha_inicio_en_curso) {
        this.fecha_inicio_en_curso = fecha_inicio_en_curso;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isVisualizada() {
        return visualizada;
    }

    public void setVisualizada(boolean visualizada) {
        this.visualizada = visualizada;
    }
    
    
}
