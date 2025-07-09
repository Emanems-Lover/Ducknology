package com.mycompany.Ducknology.Gestores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.Ducknology.Productos.Producto;

// @ author Duo_Tlacuache 8/jul/2025 12:53:43 am

// Clase encargada de leer y guardar productos desde/hacia archivos CSV
public class GestorVentas {

    // Método para leer una lista de productos desde un archivo CSV
    public static List<Producto> leerProductos(String ruta) {
        List<Producto> productos = new ArrayList<>(); // Lista que almacenará los productos
        BufferedReader br = null;

        try {
            // Abrimos el archivo para lectura
            br = new BufferedReader(new FileReader(ruta));
            String linea;

            // Leemos línea por línea del archivo
            while ((linea = br.readLine()) != null) {
                // Convertimos cada línea del CSV a un objeto Producto
                Producto p = Producto.fromCSV(linea);
                if (p != null) {
                    productos.add(p); // Agregamos el producto a la lista
                }
            }

        } catch (IOException e) {
            // Si ocurre algún error al leer el archivo, lo reportamos
            System.out.println("Error al leer el archivo: " + e.getMessage());

        } finally {
            // Cerramos el archivo en el bloque finally para asegurar que siempre se cierre
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }

        return productos; // Devolvemos la lista de productos leídos
    }

    // Método para guardar una lista de productos en un archivo CSV
    public static void guardarProductos(List<Producto> productos, String ruta) {
        BufferedWriter bw = null;

        try {
            // Abrimos el archivo para escritura (sobrescribe el contenido anterior)
            bw = new BufferedWriter(new FileWriter(ruta));

            // Escribimos cada producto en formato CSV
            for (Producto p : productos) {
                bw.write(p.toCSV()); // Convierte el producto a línea de texto
                bw.newLine();        // Salto de línea para el siguiente producto
            }

        } catch (IOException e) {
            // Si ocurre algún error al guardar, lo reportamos
            System.out.println("Error al guardar el archivo: " + e.getMessage());

        } finally {
            // Cerramos el archivo
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}