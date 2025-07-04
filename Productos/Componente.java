package com.mycompany.Ducknology.Productos;

public class Componente extends Producto {
    public Componente(String id, String nombre, double precio, int stock) {
        super(id, nombre, precio, stock);
    }

    @Override
    public String toCSV() {
        return "Componente," + id + "," + nombre + "," + precio + "," + stock;
    }
}