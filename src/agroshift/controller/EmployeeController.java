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
}
