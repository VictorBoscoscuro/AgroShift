/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.model.Usuario;
import agroshift.util.MyConnectionDB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class UserController {
    
    public ArrayList<Usuario> obtenerUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        PreparedStatement ps = null;
        String sql = "SELECT * FROM usuario ORDER BY username";
        ResultSet rs = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
              Usuario usuario = new Usuario();
              usuario.setUsername(rs.getString("username"));
              usuario.setAlias(rs.getString("alias"));
              usuario.setId_usuario(rs.getLong("id_usuario"));
              usuario.setPassword(rs.getString("clave"));
              usuario.setIsAdmin(rs.getBoolean("is_admin"));
              lista.add(usuario);       
            }
            return lista;
                
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
        return lista;
    }
}
