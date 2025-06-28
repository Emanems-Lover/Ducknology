/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

/**
 *
 * @author MarioPrz
 */
public class Componente extends Producto {
    private String tipo, especificaciones, funcion;
    private double precio;

    public Componente(String tipo, String especificaciones, String funcion,double precio, String id, String nombre, String marca, String gamma, boolean stock) {
        super(id, nombre, marca, gamma, stock);
        this.tipo = tipo;
        this.especificaciones = especificaciones;
        this.funcion = funcion;

      
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }   
}
