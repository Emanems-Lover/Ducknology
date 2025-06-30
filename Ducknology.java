/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ducknology;
import java.util.List;
/**
 *
 * @author MarioPrz & TeresaCoz
 */
public class Ducknology {

        //Prueba gestion de inventario
    public static void main(String[] args) {
        // Paso 1: Cargar productos ya existentes
        List<Producto> productos = GestorInventario.leerProductos("productos.csv");

        // Paso 2: Crear un nuevo producto
        Computadora nuevaPc = new Computadora("PC03", "Lenovo Legion", 18000.0, 4);

        // Paso 3: Agregarlo al arreglo
        productos.add(nuevaPc);

        // Paso 4: Guardar nuevamente todo en el archivo
        GestorInventario.guardarProductos(productos, "productos.csv");

        System.out.println("Producto agregado exitosamente.");
    }
}


