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
    
    public static boolean agregarEquipo(EquipoAgricola equipo){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "INSERT INTO equipo_agricola VALUES(null,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getCodigo());
            ps.setString(2, equipo.getAdquisicion());
            ps.setString(3, equipo.getMarca());
            ps.setString(4, equipo.getModelo());
            ps.setString(5, equipo.getDescripcion());
            ps.setLong(6, equipo.getId_tipo());
            ps.setLong(7, equipo.getId_estado());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipo agregado con éxito");
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al agregar el nuevo equipo: "+e.getMessage());
            return false;
        }
    }
    
    public static ArrayList<String> obtenerTodosEstados(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<String> estados = new ArrayList<>();
        try{
            String sql = "SELECT nombre_estado FROM estado_equipo ORDER BY id_estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                estados.add(rs.getString("nombre_estado"));
            }
            return estados;
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener un estado de un equipo"); //NO DEBERIA PASAR
            return estados;
        }
    }
    
    public static Long obtenerIdEstadoPorNombre(String nombre){
        
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT id_estado FROM estado_equipo WHERE nombre_estado = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
           
            if(rs.next()){
                return rs.getLong("id_estado");
            } else{
                JOptionPane.showMessageDialog(null, "Error al obtener un estado de un equipo"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener un estado de un equipo"); //NO DEBERIA PASAR
            return null;
        }
    }
    
    public static String obtenerEstadoPorId(Long id_estado){
        
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT nombre_estado FROM estado_equipo WHERE id_estado = ?";
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
    
    public static Long obtenerIdTipoPorNombre(String nombre){
        
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT id_tipo FROM tipo_equipo WHERE nombre = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
           
            if(rs.next()){
                return rs.getLong("id_tipo");
            } else{
                JOptionPane.showMessageDialog(null, "Error al obtener un tipo de un equipo"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener un tipo de un equipo"); //NO DEBERIA PASAR
            return null;
        }
    }
    
    public static String obtenerTipoPorId(Long id_tipo){
        
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT nombre FROM tipo_equipo WHERE id_tipo = ?";
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
    
    public static ArrayList<String> obtenerTodosTipos(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<String> tipos = new ArrayList<>();
        try{
            String sql = "SELECT nombre FROM tipo_equipo ORDER BY nombre";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                tipos.add(rs.getString("nombre"));
            }
            return tipos;
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener los tipos de equipos"); //NO DEBERIA PASAR
            return tipos;
        }
    }
    
}
