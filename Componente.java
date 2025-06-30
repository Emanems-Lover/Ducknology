/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ducknology;

/**
 *
 * @author MarioPrz
 */
class Componente extends Producto {
    public Componente(String id, String nombre, double precio, int stock) {
        super(id, nombre, precio, stock);
    }

    @Override
    public String toCSV() {
        return "Componente," + id + "," + nombre + "," + precio + "," + stock;
    }
}
