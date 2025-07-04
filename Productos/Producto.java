/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ducknology.Productos;

import com.mycompany.Ducknology.ventas.Vendible;

/**
 *
 * @author MarioPrz
 */
public abstract class Producto implements Vendible {
    protected String id;
    protected String nombre;
    protected double precio;
    protected int stock;

    public Producto(String id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public abstract String toCSV();

    public static Producto fromCSV(String linea) {
        String[] partes = linea.split(",");
        if (partes.length < 5) {
            System.out.println("Línea mal formada: " + linea);
            return null;
        }

        String tipo = partes[0].trim();
        String id = partes[1].trim();
        String nombre = partes[2].trim();
        double precio = Double.parseDouble(partes[3].trim());
        int stock = Integer.parseInt(partes[4].trim());

        if (tipo.equalsIgnoreCase("Computadora")) {
            return new Computadora(id, nombre, precio, stock);
        } else if (tipo.equalsIgnoreCase("Componente")) {
            return new Componente(id, nombre, precio, stock);
        } else {
            System.out.println("Tipo no reconocido: " + tipo);
            return null;
        }
    }
}