/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.model.Alerta;
import agroshift.util.MyConnectionDB;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class AlertController {

    public static ArrayList<Alerta> obtenerTodasAlertas(){
        ArrayList<Alerta> lista = new ArrayList<>();
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM alerta";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Alerta alerta = new Alerta();
                alerta.setId_alerta(rs.getLong("id_alerta"));
                alerta.setDescripcion(rs.getString("descripcion"));
                alerta.setFecha_creacion(rs.getString("fecha_creacion"));
                alerta.setFecha_fin(rs.getString("fecha_fin"));
                alerta.setFecha_inicio_en_curso(rs.getString("fecha_inicio_en_curso"));
                alerta.setNombre(rs.getString("nombre_alerta"));
                alerta.setVisualizada(rs.getBoolean("visualizada"));
                lista.add(alerta);
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error obteniendo las alertas | getAllAlerts() #0063");
        }
        finally{
            try{
                rs.close();
            }catch(Exception e){}
            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
            return lista;
        }
    }
    
    public static ArrayList<Alerta> obtenerAlertasEnCurso(){
        ArrayList<Alerta> lista = new ArrayList<>();
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        
        try{
            LocalDate ld = LocalDate.now();
            String hoy = ld.toString();
            String sql = "SELECT * FROM alerta WHERE ? BETWEEN fecha_inicio_en_curso AND fecha_fin ORDER BY fecha_fin";
            ps = con.prepareStatement(sql);
            ps.setString(1, hoy);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Alerta alerta = new Alerta();
                alerta.setId_alerta(rs.getLong("id_alerta"));
                alerta.setDescripcion(rs.getString("descripcion"));
                alerta.setFecha_creacion(rs.getString("fecha_creacion"));
                alerta.setFecha_fin(rs.getString("fecha_fin"));
                alerta.setFecha_inicio_en_curso(rs.getString("fecha_inicio_en_curso"));
                alerta.setNombre(rs.getString("nombre_alerta"));
                alerta.setVisualizada(rs.getBoolean("visualizada"));
                lista.add(alerta);
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error obteniendo las alertas | getAllAlerts() #0063");
        }
        finally{
            try{
                rs.close();
            }catch(Exception e){}
            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
            return lista;
        }
    }
    
    public static ArrayList<Alerta> obtenerAlertasNoEnCurso(){
        ArrayList<Alerta> lista = new ArrayList<>();
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        
        try{
            LocalDate ld = LocalDate.now();
            String hoy = ld.toString();
            String sql = "SELECT * FROM alerta WHERE fecha_inicio_en_curso > ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, hoy);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Alerta alerta = new Alerta();
                alerta.setId_alerta(rs.getLong("id_alerta"));
                alerta.setDescripcion(rs.getString("descripcion"));
                alerta.setFecha_creacion(rs.getString("fecha_creacion"));
                alerta.setFecha_fin(rs.getString("fecha_fin"));
                alerta.setFecha_inicio_en_curso(rs.getString("fecha_inicio_en_curso"));
                alerta.setNombre(rs.getString("nombre_alerta"));
                alerta.setVisualizada(rs.getBoolean("visualizada"));
                lista.add(alerta);
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error obteniendo las alertas | getAllAlerts() #0063");
        }
        finally{
            try{
                rs.close();
            }catch(Exception e){}
            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
            return lista;
        }
    }
    
    public static boolean crearAlerta(Alerta nueva_alerta){

        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            LocalDate ld = LocalDate.now();
            String hoy = ld.toString();
            String sql = "INSERT INTO alerta VALUES(null,?,?,?,?,?,default)";
            ps = con.prepareStatement(sql);
            ps.setString(1, nueva_alerta.getNombre());
            ps.setString(2, nueva_alerta.getDescripcion());
            ps.setString(3, hoy);
            ps.setString(4, nueva_alerta.getFecha_inicio_en_curso());
            ps.setString(5, nueva_alerta.getFecha_fin());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nueva alerta creada");
            return true;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error agregando alerta | newAlert() #0065");
            return false;
        }
        finally{

            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
        }
    }

    public static boolean setearAlertaVisualizada(Long id_alerta){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "UPDATE alerta SET visualizada = true WHERE id_alerta = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, id_alerta);
            ps.executeUpdate();
            return true;
                     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error seteando visualizacion de alerta | setAlertVisualizate() #0063");
            return false;
        }
        finally{

            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
        }
    }

    public static boolean actualizarAlerta(Alerta alerta){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "UPDATE alerta SET nombre_alerta = ?, descripcion = ?, fecha_creacion = ?, fecha_inicio_en_curso = ?, fecha_fin = ? WHERE id_alerta = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, alerta.getNombre());
            ps.setString(2, alerta.getDescripcion());
            ps.setString(3, LocalDate.now().toString());
            ps.setString(4, alerta.getFecha_inicio_en_curso());
            ps.setString(5, alerta.getFecha_fin());
            ps.setLong(6, alerta.getId_alerta());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alerta actualizada con éxito");
            return true;
                     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error descartando alerta | deleteAlert() #0068");
            return false;
        }
        finally{

            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
        }
    }
    
    public static boolean eliminarAlerta(Long id_alerta){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "DELETE FROM alerta WHERE id_alerta = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, id_alerta);
            ps.executeUpdate();
            return true;
                     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error descartando alerta | deleteAlert() #0068");
            return false;
        }
        finally{

            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
        }
    }
    
    public static boolean hayAlertasVencidas(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM alerta WHERE fecha_fin < ? AND visualizada = false";
            ps = con.prepareStatement(sql);
            ps.setString(1, LocalDate.now().toString());
            
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            } else return false;
                     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error descartando alerta | deleteAlert() #0068");
            return false;
        }
        finally{

            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
        }
    }
}
