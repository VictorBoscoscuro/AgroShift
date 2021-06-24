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
   
    public ArrayList<EquipoAgricola> obtenerTodosEquipos(){
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
    
}
