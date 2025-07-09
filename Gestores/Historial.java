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
//@ author Duo_Tlacuache 8/jul/2025 12:47:59 am

// Clase encargada de gestionar el historial de ventas del sistema
public class Historial {

    // Ruta del archivo donde se almacenan las ventas
    private String rutaVentas;

    // Constructor: inicializa la ruta y crea el archivo si no existe
    public Historial(String rutaVentas) {
        this.rutaVentas = rutaVentas;
        crearArchivoSiNoExiste();
    }

    // Método privado que crea el archivo de ventas si no existe aún
    private void crearArchivoSiNoExiste() {
        File archivo = new File(rutaVentas);
        if (!archivo.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(rutaVentas))) {
                // Escribe la primera línea como encabezado del archivo CSV
                writer.println("VentaID, FechaHora, ClienteID, ClienteNombre, ClienteEmail, DetallesProductos, Total");
            } catch (IOException e) {
                System.err.println("Error al crear archivo de ventas: " + e.getMessage());
            }
        }
    }

    // Registra una nueva venta en el archivo CSV
    public boolean registrarVenta(String clienteId, String clienteNombre, String clienteEmail, 
                                 String detallesProductos, double total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaVentas, true))) {
            // Genera un ID único de venta usando la hora actual en milisegundos
            String ventaId = "V" + System.currentTimeMillis();

            // Obtiene la fecha y hora actual
            LocalDateTime fechaHora = LocalDateTime.now();

            // Formatea la fecha como texto legible
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraStr = fechaHora.format(formatter);

            // Prepara la línea en formato CSV con los datos de la venta
            String lineaVenta = String.format("%s,%s,%s,%s,%s,%s,%.2f",
                ventaId, fechaHoraStr, clienteId, clienteNombre, clienteEmail, detallesProductos, total);

            // Escribe la línea al archivo
            writer.println(lineaVenta);
            return true;

        } catch (IOException e) {
            System.err.println("Error al registrar venta: " + e.getMessage());
            return false;
        }
    }

    // Lee todas las ventas registradas en el archivo y las devuelve como lista de cadenas
    public List<String> leerVentas() {
        List<String> ventas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaVentas))) {
            String linea;

            // Se salta la primera línea (encabezado)
            reader.readLine();

            // Lee línea por línea y las agrega a la lista
            while ((linea = reader.readLine()) != null) {
                ventas.add(linea);
            }

        } catch (IOException e) {
            System.err.println("Error al leer ventas: " + e.getMessage());
        }
        return ventas;
    }

    // Muestra en pantalla las compras realizadas por un cliente específico
   public void mostrarVentasDelCliente(String clienteId) {
    List<String> ventas = leerVentas();
    System.out.println("\n========= HISTORIAL DE COMPRAS =========");
    boolean encontrado = false;

    // Encabezado de tabla
    System.out.printf("| %-10s | %-19s | %-10s |\n", "Venta ID", "Fecha y Hora", "Total");
    System.out.println("|------------|---------------------|------------|");

    for (String venta : ventas) {
        String[] datos = venta.split(","); // asegúrate de que el CSV está separado por comas

        // Validar y filtrar por clienteId
        if (datos.length >= 7 && datos[2].equals(clienteId)) {
            System.out.printf("| %-10s | %-19s | $%-9s |\n", datos[0], datos[1], datos[6]);
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontraron compras para este cliente.");
    }

    System.out.println("-----------------------------------------");
}
}