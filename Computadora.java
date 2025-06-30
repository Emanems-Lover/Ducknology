/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ducknology;

/**
 *
 * @author
 */
class Computadora extends Producto {
    public Computadora(String id, String nombre, double precio, int stock) {
        super(id, nombre, precio, stock);
    }

    @Override
    public String toCSV() {
        return "Computadora," + id + "," + nombre + "," + precio + "," + stock;
    }
}
