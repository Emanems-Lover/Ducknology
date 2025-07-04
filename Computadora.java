package com.mycompany.Ducknology;

public class Computadora extends Producto {
    public Computadora(String id, String nombre, double precio, int stock) {
        super(id, nombre, precio, stock);
    }

    @Override
    public String toCSV() {
        return "Computadora," + id + "," + nombre + "," + precio + "," + stock;
    }
}