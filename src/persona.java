
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import conexion.Conexion;
import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class persona extends personaApp.personaPOA{
    private ORB orb;
    Conexion conex = new Conexion();
    
    @Override
    public boolean insertarPersona(int identificacion, String nombre, String apellidos, int telefono, String direccion) {
        boolean resultado = false;
        
        try {
            String query = "insert into persona(identificacion,nombre,apellidos,telefono,direccion)"
                    + "values ('"+identificacion+"','"+nombre+"','"+apellidos+"','"+telefono+"','"+direccion+"')";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor>0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
                    
        }
        return resultado;
    }

    @Override
    public String consultarPersona(int identificacion) {
        String resultado = "";
        try {
            String query = "Select * from persona WHERE identificacion = "+identificacion;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + " - "
                        + rs.getString(6) + " - "
                        ;
            }
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarPersona(int identificacion) {
        String resultado = "";
        try {
            String query = "delete persona from persona WHERE identificacion = "+identificacion;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + " - "
                        + rs.getString(6) + " - "
                        ;
            }
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarPersona(int identificacion, String nombre, String apellidos, int telefono, String direccion) {
        boolean resultado = false;
        
        try {
            String query = "update persona SET identificacion="+identificacion+",nombre='"+nombre+"',apellidos='"+apellidos+"',telefono='"+telefono+"',direccion='"+direccion+"' WHERE identificacion ="+identificacion+"";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor>0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
                    
        }
        return resultado;
    }

    @Override
    public String listarPersonas() {
        String resultado = "";
        try {
            String query = "Select * from persona";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                resultado += rs.getLong(2)+ " - "
                        + rs.getString(3) + " - "
                        + rs.getString(4) + " - "
                        + rs.getString(5) + " - "
                        + rs.getString(6) + " - "
                        + "\n";
            }
            st.close();
            rs.close();
            conex.conex.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
