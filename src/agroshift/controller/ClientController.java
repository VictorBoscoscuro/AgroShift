/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroshift.controller;

import agroshift.model.Cliente;
import agroshift.model.Empleado;
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
public class ClientController {
    
    
    public static ArrayList<Cliente> obtenerClientes(){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{            
            String sql = "SELECT * FROM cliente ORDER BY nombre";
            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
              Cliente cliente = new Cliente();
              cliente.setCodigo(rs.getString("codigo_cliente"));
              cliente.setNombre(rs.getString("nombre"));
              cliente.setDescuento(rs.getInt("descuento"));
              cliente.setDireccion(rs.getString("direccion"));
              cliente.setMail(rs.getString("mail"));
              cliente.setTelefono(rs.getString("telefono"));
              cliente.setMas_detalles(rs.getString("mas_informacion"));
              cliente.setId_cliente(rs.getLong("id_cliente"));

              clientes.add(cliente);       
            }
            return clientes;
            
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
        return clientes;
    }
    
    public static boolean nuevoCliente(String codigo, String nombre, String telefono, String mail, String direccion, String mas_info, String descuento){	
	PreparedStatement ps = null;
	MyConnectionDB mycon = new MyConnectionDB();
	Connection con = mycon.getMyConnection();

	if("".equals(telefono)){
            telefono = null;
	}
	if("".equals(mail)){
            mail = null;
	}
	if("".equals(direccion)){
            direccion = null;
	}
	if("".equals(mas_info)){
            mas_info = null;
	}
        Integer descuentoInt;
        if("".equals(descuento)){
            descuentoInt = 0;
        } else{
            descuentoInt = Integer.parseInt(descuento);
        }
	try{
            String sql = "INSERT INTO cliente VALUES(null,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo);
            ps.setString(2,nombre);
            ps.setString(3,mail);
            ps.setString(4,telefono);
            ps.setString(5,direccion);
            ps.setInt(6,descuentoInt);
            ps.setString(7,mas_info);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente agregado con éxito");
            return true;
	} catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al crear el cliente -> "+e.getMessage());
            return false;
	} finally{
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch(Exception e){}
	}	
    }

    public static boolean actualizarCliente(String codigo, String nombre, String telefono, String mail, String direccion, String mas_info,String descuento, Long id_cliente){	
	PreparedStatement ps = null;
	MyConnectionDB mycon = new MyConnectionDB();
	Connection con = mycon.getMyConnection();

	if("".equals(telefono)){
            telefono = null;
	}
	if("".equals(mail)){
            mail = null;
	}
	if("".equals(direccion)){
            direccion = null;
	}
	if("".equals(mas_info)){
            mas_info = null;
	}

        Integer descuentoInt;
        if("".equals(descuento)){
            descuentoInt = 0;
        } else{
            descuentoInt = Integer.parseInt(descuento);
        }
        
	try{
            String sql = "UPDATE cliente SET codigo_cliente = ?, nombre = ?, telefono = ?, mail = ?, direccion = ?, mas_informacion = ?, descuento = ? WHERE id_cliente = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,codigo);
            ps.setString(2,nombre);
            ps.setString(3,telefono);
            ps.setString(4,mail);
            ps.setString(5,direccion);
            ps.setString(6,mas_info);
            ps.setInt(7,descuentoInt);
            ps.setLong(8,id_cliente);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cliente actualizado con éxito");
            return true;
	} catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al actualizar el cliente -> "+e.getMessage());
            return false;
	} finally{
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch(Exception e){}	
	}	
    }

    public static boolean eliminarCliente(Long id_cliente){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, id_cliente);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
            return true;
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente");
            return false;
        }
    }
    
}
