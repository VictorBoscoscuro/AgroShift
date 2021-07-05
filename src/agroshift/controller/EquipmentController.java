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
import java.time.LocalDate;
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
                equipo.setAdquisicion(rs.getDate("fecha_adquisicion").toString());
                equipos.add(equipo);
            }
            return equipos;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener los equipos");
            return equipos;
        } finally{
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
        } finally{
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            } catch(Exception e){}
        }
    }
    
    public static boolean actualizarEquipo(EquipoAgricola equipo){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        
        try{
            String sql = "UPDATE equipo_agricola SET codigo_equipo = ?, fecha_adquisicion = ?, marca = ?, modelo = ?, descripcion = ?, id_tipo = ?, id_estado = ? WHERE id_equipo = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, equipo.getCodigo());
            ps.setString(2, equipo.getAdquisicion());
            ps.setString(3, equipo.getMarca());
            ps.setString(4, equipo.getModelo());
            ps.setString(5, equipo.getDescripcion());
            ps.setLong(6, equipo.getId_tipo());
            ps.setLong(7, equipo.getId_estado());
            ps.setLong(8, equipo.getId_equipo());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipo actualizado con éxito");
            return true;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error actualizando el equipo: "+e.getMessage());
            return false;
        } finally{
            try{
                ps.close();
            } catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
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
        } finally{
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
        } finally{
            try{
                rs.close();
            }catch(Exception e){}
            try{
                ps.close();
            }catch(Exception e){}
            try{
                con.close();
            }catch(Exception e){}
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
                JOptionPane.showMessageDialog(null, "obtenerEstadoPorId() no next RS"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "obtenerEstadoPorId() ex"); //NO DEBERIA PASAR
            return null;
        } finally{
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
                JOptionPane.showMessageDialog(null, "obtenerIdTipoPorNombre() no next RS"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "obtenerIdTipoPorNombre() ex"); //NO DEBERIA PASAR
            return null;
        } finally{
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
    
    public static String obtenerTipoPorId(Long id_tipo){        //ARREGLAR
        
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
                JOptionPane.showMessageDialog(null, "obtenerTipoPorId() no next RS"); //NO DEBERIA PASAR
                return null;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "obtenerTipoPorId() ex"); //NO DEBERIA PASAR
            return null;
        } finally{
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
        } finally{
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
    
    public static boolean eliminarEquipo(Long id){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();

        try{
            String sql = "DELETE FROM equipo_agricola WHERE id_equipo = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Equipo eliminado con éxito");
            return false;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener los tipos de equipos"); //NO DEBERIA PASAR
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
    
    public static ArrayList<EquipoAgricola> obtenerEquipos(String tipo, String estado){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<EquipoAgricola> equipos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM equipo_agricola WHERE id_estado = ? AND id_tipo = ?";
            ps = con.prepareStatement(sql);
            ps.setLong(1, obtenerIdEstadoPorNombre(estado));
            ps.setLong(2, obtenerIdTipoPorNombre(tipo));
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
                equipo.setAdquisicion(rs.getDate("fecha_adquisicion").toString());
                equipos.add(equipo);
            }
            return equipos;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener los equipos");
            return equipos;
        } finally{
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
    
    public static Long obtenerIdEquipoPorCodigo(String codigo){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM equipo_agricola WHERE codigo_equipo = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
           
            if(rs.next()){
                return rs.getLong("id_equipo");
            } else{
                JOptionPane.showMessageDialog(null, "Error al obtener id de equipo por codigo"); //NO DEBERIA PASAR
                return 0l;
            }
        } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error al obtener id de equipo por codigo"); //NO DEBERIA PASAR
            return 0l;
        } finally{
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
    
    public static ArrayList<EquipoAgricola> obtenerTodosEquiposDisponibles(String inicio, String fin){
        PreparedStatement ps = null;
        MyConnectionDB mycon = new MyConnectionDB();
        Connection con = mycon.getMyConnection();
        ResultSet rs = null;
        ArrayList<EquipoAgricola> equipos = new ArrayList<>();
        try{
            String sql = "SELECT * FROM equipo_agricola eq WHERE eq.id_estado IN(1,2) AND NOT EXISTS (SELECT * FROM renta r INNER JOIN renta_equipo re ON(r.id_renta = re.renta) WHERE re.equipo = eq.id_equipo)"; //Implementar que valide la fecha enviada, asi como esta valida que no exista ninguna de ese equipo directamente
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
                equipo.setAdquisicion(rs.getDate("fecha_adquisicion").toString());
                equipos.add(equipo);
            }
            return equipos;
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener los equipos");
            return equipos;
        } finally{
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
