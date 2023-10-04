/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Clara Elizabeth
 */
public class Clientes {
    
    private int clienteID;
    private String nombre;
    private String email;

    public Clientes() {
    }

    public Clientes(int clienteID) {
        this.clienteID = clienteID;
    }

    public Clientes(int clienteID, String nombre, String email) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        this.email = email;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
