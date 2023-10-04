/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Clientes;
import services.ClientesServices;

/**
 *
 * @author david
 */
public class ClientesController {
    public ArrayList<Object[]> searchClientes(int code){
        ArrayList<Object[]> clientes = new ArrayList<>();
        try {
            ResultSet rs = ClientesServices.getINSTANCE().searchCliente(code);
            while (rs.next()) {
                int id = rs.getInt("cliente_id");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                Object[] ob = {id,nombre,email};
                clientes.add(ob);
            }
        } catch (SQLException ex) {
        }
        return clientes;
    }
    
    public void insertCliente(Clientes cliente){
        ClientesServices.getINSTANCE().createCliente(cliente);
    }
    
    public void updateCliente(Clientes cliente){
        ClientesServices.getINSTANCE().updateCliente(cliente);
    }
    
    public void deleteCliente(int id){
        ClientesServices.getINSTANCE().deleteCliente(id);
    }
}
