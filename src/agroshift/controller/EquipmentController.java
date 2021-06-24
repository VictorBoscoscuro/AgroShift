/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.model.EquipoAgricola;
import agroshift.util.MyConnectionDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class EquipmentController {
   
    public static ArrayList<EquipoAgricola> obtenerTodosEquipos(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<EquipoAgricola> equipos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM equipo_agricola";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                EquipoAgricola equipo = new EquipoAgricola();
                equipo.setCodigo(rs.getString("codigo_equipo"));
                equipo.setDescripcion(rs.getString("descripcion"));
                equipo.setId_equipo(rs.getLong("id_equipo"));
                equipo.setId_estado(rs.getLong("id_estado"));
                equipo.setId_tipo(rs.getLong("id_tipo"));
                equipo.setMarca(rs.getString("marca"));
                equipo.setModelo(rs.getString("modelo"));
                equipos.add(equipo);
            }
            return equipos;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener los equipos");
            return equipos;
        }
    }
    
    public static String obtenerEstadoPorId(Long id_estado){
        
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT nombre_estado FROM estado_agricola WHERE id_estado = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, id_estado);
            rs = ps.executeQuery();
           
            if(rs.next()){
                return rs.getString("nombre_estado");
            } else{
                JOptionPane.showMessageDialog(null, "Error al obtener un estado de un equipo"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener un estado de un equipo"); //NO DEBERIA PASAR
            return null;
        }
    }
    
    public static String obtenerTipoPorId(Long id_tipo){
        
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT nombre FROM tipo_agricola WHERE id_tipo = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, id_tipo);
            rs = ps.executeQuery();
           
            if(rs.next()){
                return rs.getString("nombre");
            } else{
                JOptionPane.showMessageDialog(null, "Error al obtener un tipo de un equipo"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener un tipo de un equipo"); //NO DEBERIA PASAR
            return null;
        }
    }
}
