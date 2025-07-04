package com.mycompany.Ducknology;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorVentas {

    public static List<Producto> leerProductos(String ruta) {
        List<Producto> productos = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = br.readLine()) != null) {
                Producto p = Producto.fromCSV(linea);
                if (p != null) {
                    productos.add(p);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            // Cerrar archivo
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }

        return productos;
    }

    public static void guardarProductos(List<Producto> productos, String ruta) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(ruta));
            
            for (Producto p : productos) {
                bw.write(p.toCSV());  // convierte el producto a texto CSV
                bw.newLine();         // salto de línea
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        } finally {
            // Cerrar archivo
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