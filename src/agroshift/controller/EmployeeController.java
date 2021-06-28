/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.model.Empleado;
import agroshift.util.MyConnectionDB;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class EmployeeController {
    
    public static ArrayList<Empleado> obtenerEmpleados(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try{            
            String sql = "SELECT nombre_completo,documento,numero_empleado,rol FROM empleado ORDER BY nombre_completo";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
              Empleado empleado = new Empleado();
              empleado.setDocumento(rs.getString("documento"));
              empleado.setNombre(rs.getString("nombre_completo"));
              empleado.setRol(rs.getString("rol"));
              empleado.setNumero(rs.getString("numero_empleado"));

              empleados.add(empleado);       
            }
            return empleados;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        } finally{
            try{
                rs.close(); 
            } catch(Exception e){}
            try{
                ps.close();
            } catch(Exception e) {}
            try{
                con.close();
            } catch(Exception e){}
        }
        return empleados;
    }
    
    public static boolean actualizarEmpleado(String documentoActual, String nuevo_nombre, String nuevo_documento, String nuevo_rol, String nuevo_numero){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();

        ArrayList<Empleado> empleados = new ArrayList<>();
        try{
                
            String sql = "";
            if("".equals(nuevo_rol)){
                sql = "UPDATE empleado SET nombre_completo = ?, documento = ?, numero_empleado = ? WHERE documento = ?";            
                ps = con.prepareStatement(sql);
                ps.setString(1, nuevo_nombre.toUpperCase());
                ps.setString(2, nuevo_documento);
                ps.setString(3, nuevo_numero.toUpperCase());
                ps.setString(4, documentoActual);
            }else {
                sql = "UPDATE empleado SET nombre_completo = ?, documento = ?, numero_empleado = ?, rol = ? WHERE documento = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, nuevo_nombre.toUpperCase());
                ps.setString(2, nuevo_documento);
                ps.setString(3, nuevo_numero.toUpperCase());
                ps.setString(4, nuevo_rol.toUpperCase());
                ps.setString(5, documentoActual);
            }
            
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            return false;
        } finally{
            try{
                ps.close();
            } catch(Exception e) {}
            try{
                con.close();
            } catch(Exception e){}
        }
    }

    public static boolean nuevoEmpleado(String documento, String nombre, String nacimiento, String alta, String numero, String rol){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "INSERT INTO empleado(documento,nombre_completo,fecha_nacimiento,fecha_alta,numero_empleado,rol) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ps.setString(2, nombre);
            ps.setString(3, nacimiento);
            ps.setString(4, alta);
            ps.setString(5, numero);
            if("".equals(rol)){
                ps.setString(6, "SIN DEFINIR");
            } else ps.setString(6, rol);
            
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado agregado con éxito");
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el empleado"+e.getMessage());
            return false;
        } finally{
            try{
                ps.close();
            } catch(Exception e) {}
            try{
                con.close();
            } catch(Exception e){}
        }
    }
    
    public static boolean eliminarEmpleado(String documento){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();

        try{

            String sql = "DELETE FROM empleado WHERE documento = ?";            
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            return false;
        } finally{
            try{
                ps.close();
            } catch(Exception e) {}
            try{
                con.close();
            } catch(Exception e){}
        }
    }

}
