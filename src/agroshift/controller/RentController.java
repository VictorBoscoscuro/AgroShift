/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.model.Rent;
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
public class RentController {
    
    public ArrayList<Rent> obtenerRentasActuales(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        PreparedStatement ps2 = null;
        MyConnectionDB mycon2 = new MyConnectionDB();
        Connection con2 = mycon.getMyConnection();
        ResultSet rs2 = null;
        ArrayList<Rent> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM renta r WHERE ? BETWEEN fecha_inicio AND fecha_fin";
            ps = con.prepareStatement(sql);
            ps.setString(1, LocalDate.now().toString()); //hoy
            rs = ps.executeQuery();
            while(rs.next()){
                Rent renta = new Rent();
                renta.setId_renta(rs.getLong("id_renta"));
                renta.setId_empleado(rs.getLong("id_empleado"));
                renta.setId_cliente(rs.getLong("id_cliente"));
                renta.setFecha_inicio(rs.getString("fecha_inicio"));
                renta.setFecha_fin(rs.getString("fecha_fin"));
                renta.setCosto(rs.getDouble("costo"));
                String sql2 = "SELECT COUNT(*) AS cantidad_equipos FROM renta r INNER JOIN renta_equipo re ON(r.id_renta = re.renta) WHERE r.id_renta = ? AND ? BETWEEN r.fecha_inicio AND r.fecha_fin";
                ps2 = con2.prepareStatement(sql2);
                ps2.setLong(1, rs.getLong("id_renta"));
                ps2.setString(2, LocalDate.now().toString());
                rs2 = ps2.executeQuery();
                if(rs2.next()){
                    renta.setCantidad_equipos(rs2.getInt("cantidad_equipos"));
                }
                list.add(renta);
            }
            return list;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error obteniendo las rentas actuales");
            return list;
        }finally{
            try{
                rs2.close();
            } catch(Exception e){}
            try{
                ps2.close();
            } catch(Exception e){}
            try{
                con2.close();
            } catch(Exception e){}
            try{
                rs.close();
            } catch(Exception e){}
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch(Exception e){}
        }
    
    }
    
}
