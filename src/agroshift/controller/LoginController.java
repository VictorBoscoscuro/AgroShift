/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.util.MyConnectionDB;
import agroshift.util.UserLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class LoginController {
    
    public LoginController(){
    }
    
    public boolean validarUsuario(String username, String password){
        boolean result = false;
        String sql = "SELECT * FROM usuario WHERE username='"+username+"' AND clave='"+password+"';";
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                result = true;
                UserLogin.setInstance(rs.getString("username"),rs.getLong("id_usuario"),rs.getBoolean("is_admin"),rs.getString("alias"));
                return result;
                
            }else{
                JOptionPane.showMessageDialog(null,"Datos incorrectos", "Por favor verifique sus credenciales",JOptionPane.WARNING_MESSAGE);
                return result;
            }
   
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
        return false;
    }
    
}
