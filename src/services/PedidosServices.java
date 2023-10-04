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
import models.Pedidos;

/**
 *
 * @author david
 */
public class PedidosServices {
    private static PedidosServices INSTANCE;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection connection;

    private PedidosServices() {        
        connection = Supabase.getINSTANCE().getConnection();
        stmt = getStatement();
        rs = null;
    }

    public static PedidosServices getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new PedidosServices();
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
    
    public ResultSet searchPedido(int code){
        String where = "";
        if(code>=0){
            where = "WHERE pedido_id = " + code +"";
        }
        try {
            rs = stmt.executeQuery("SELECT * FROM pedidos "+where);
            return rs;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        
        return null;
    }
    
    public void createPedido(Pedidos pedido){
        try {
            String sql = "INSERT INTO pedidos (cliente_id, fecha_pedido, total) VALUES(?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, pedido.getClienteID());
            ps.setString(2, pedido.getFechaPedido());
            ps.setInt(3, pedido.getTotal());
            

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se añadió el pedido", "Extio", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    public void updatePedido(Pedidos pedido){
        try {
            String sql = "update pedidos set total=? where pedido_id=?";
            ps = connection.prepareStatement(sql);

            
            ps.setFloat(1, pedido.getTotal());
            ps.setInt(2, pedido.getPedidoID());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se modificó el pedido", "Extio", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deletePedido(int code){
        try {
            String sql = "delete from pedidos where pedido_id=?";
            ps = connection.prepareStatement(sql);

            ps.setInt(1, code);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se eliminó el pedido", "Extio", JOptionPane.INFORMATION_MESSAGE);            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }
}
