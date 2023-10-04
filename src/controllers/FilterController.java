/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import services.ClientesServices;
import services.PedidosServices;

/**
 *
 * @author david
 */
public class FilterController {
    public ArrayList<Object[]> searchCliente(int code){
        ArrayList<Object[]> cliente = new ArrayList<>();
        try {
            ResultSet rs = ClientesServices.getINSTANCE().searchCliente(code);
            while (rs.next()) {
                int id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                Object[] ob = {id,nombre,email};
                cliente.add(ob);
            }
        } catch (SQLException ex) {
        }
        return cliente;
    }
    
    public ArrayList<Object[]> searchPedido(int code){
        ArrayList<Object[]> pedido = new ArrayList<>();
        try {
            ResultSet rs = PedidosServices.getINSTANCE().searchPedido(code);
            while (rs.next()) {
                int id = rs.getInt("pedido_id");
                int idCliente = rs.getInt("cliente_id");
                String nombreCliente = searchCliente(idCliente).get(0)[1].toString();
                String fechaPedido = rs.getString("fecha_pedido");
                int precio = rs.getInt("total");
                Object[] ob = {id,nombreCliente,fechaPedido,precio};
                pedido.add(ob);
            }
        } catch (SQLException ex) {
        }
        return pedido;
    }
    
}