/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;



/**
 *
 * @author Clara Elizabeth
 */
public class Pedidos {
    
    private int pedidoID;
    private String fechaPedido;
    private int total;
    private int clienteID;

    public Pedidos() {
    }

   

    public Pedidos(String fechaPedido, int total, int clienteID) {
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.clienteID = clienteID;
    }

    public Pedidos(int pedidoID, String fechaPedido, int total, int clienteID) {
        this.pedidoID = pedidoID;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.clienteID = clienteID;
    }

    public Pedidos(int pedidoID, int total, int clienteID) {
        this.pedidoID = pedidoID;
        this.total = total;
        this.clienteID = clienteID;
    }

    
    
    public int getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }
    
    

    

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }
    
    
}
