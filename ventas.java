package com.mycompany.proyectopoo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pato_coder 25/06/25 6:51
 */
public class ventas {
    
    //atributos
    private String id;
    private int cantidad;
    private String tipoVenta;
    private double costoTotal;
    //private Producto producto=new Producro;

    public ventas(String id, int cantidad, String tipoVenta, double costoTotal) {
        this.id = id;
        this.cantidad = cantidad;
        this.tipoVenta = tipoVenta;
        this.costoTotal = costoTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    
    
    
}
