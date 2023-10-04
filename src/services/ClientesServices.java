/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import connection.Supabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Clientes;
/**
 *
 * @author david
 */
public class ClientesServices {
    
    private static ClientesServices INSTANCE;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection;
    
    private ClientesServices() {        
        connection = Supabase.getINSTANCE().getConnection();
        stmt = getStatement();
        rs = null;
    }

    public static ClientesServices getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ClientesServices();
        }
        return INSTANCE;
    }    
    
    private Statement getStatement(){
        try {
            return connection.createStatement();
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet searchCliente(int code){
        String where = "";
        if(code >= 0){
            where = "WHERE cliente_id = " + code +"";
        }
        try {
            rs = stmt.executeQuery("SELECT * FROM clientes "+where);
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        
        return null;
    }
    
    public void createCliente(Clientes cliente){
        try {
            String sql = "INSERT INTO clientes (cliente_id,nombre,email) VALUES(?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, cliente.getClienteID());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getEmail());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se añadió el cliente", "Extio", JOptionPane.INFORMATION_MESSAGE);            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateCliente(Clientes cliente){
        try {
            String sql = "update clientes set nombre = ?, email =? where cliente_id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getClienteID());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se modificó el cliente", "Extio", JOptionPane.INFORMATION_MESSAGE);            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteCliente(int code){
        try {
            String sql = "delete from clientes where cliente_id=?";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, code);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se eliminó el cliente", "Extio", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}