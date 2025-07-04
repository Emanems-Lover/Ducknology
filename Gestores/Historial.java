package com.mycompany.Ducknology.Gestores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private String rutaVentas;
    
    public Historial(String rutaVentas) {
        this.rutaVentas = rutaVentas;
        crearArchivoSiNoExiste();
    }
    
    private void crearArchivoSiNoExiste() {
        File archivo = new File(rutaVentas);
        if (!archivo.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(rutaVentas))) {
                writer.println("VentaID,FechaHora,ClienteID,ClienteNombre,ClienteEmail,DetallesProductos,Total");
            } catch (IOException e) {
                System.err.println("Error al crear archivo de ventas: " + e.getMessage());
            }
        }
    }
    
    public boolean registrarVenta(String clienteId, String clienteNombre, String clienteEmail, 
                                 String detallesProductos, double total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaVentas, true))) {
            String ventaId = "V" + System.currentTimeMillis();
            LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraStr = fechaHora.format(formatter);
            
            String lineaVenta = String.format("%s,%s,%s,%s,%s,%s,%.2f",
                ventaId, fechaHoraStr, clienteId, clienteNombre, clienteEmail, detallesProductos, total);
            
            writer.println(lineaVenta);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al registrar venta: " + e.getMessage());
            return false;
        }
    }
    
    public List<String> leerVentas() {
        List<String> ventas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaVentas))) {
            String linea;
            reader.readLine(); // Saltar encabezado
            while ((linea = reader.readLine()) != null) {
                ventas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer ventas: " + e.getMessage());
        }
        return ventas;
    }
    
    public void mostrarVentasDelCliente(String clienteId) {
        List<String> ventas = leerVentas();
        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        boolean encontrado = false;
        
        for (String venta : ventas) {
            String[] datos = venta.split(",");
            if (datos.length >= 7 && datos[2].equals(clienteId)) {
                System.out.printf("Venta: %s | Fecha: %s | Total: $%s%n", 
                    datos[0], datos[1], datos[6]);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontraron compras para este cliente.");
        }
    }
}