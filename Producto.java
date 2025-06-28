/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;
import java.util.*;

/**
 *
 * @author MarioPrz
 */
public class Producto {
    //atributos 23/06/2023
    private String id;
    private String nombre;
    private String marca;
    private String gamma;
    private boolean stock;
    private String popularidad;
   
    //constructor 23/06/2023
    public Producto(String id, String nombre, String marca, String gamma, boolean stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.gamma = gamma;
        this.stock = stock; 
    }
    
    
    //getters y setters 23/06/2023 00:00:01

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGamma() {
        return gamma;
    }

    public void setGamma(String gamma) {
        this.gamma = gamma;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

}
