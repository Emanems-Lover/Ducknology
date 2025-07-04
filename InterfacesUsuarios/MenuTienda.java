package com.mycompany.Ducknology.InterfacesUsuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.mycompany.Ducknology.Productos.Inventario;
import com.mycompany.Ducknology.Usuarios.Cliente;
import com.mycompany.Ducknology.ventas.Venta;

public class MenuTienda {
    Inventario inventario;
    String ruta;
    String rutaVentas;
    Venta venta;
    Scanner sc;
    int opcion;

    public void iniciar(Scanner pato, Cliente clienteActual) {
        inventario = new Inventario();
        ruta = "src/Data/productos.csv";
        rutaVentas = "src/Data/ventas.csv";
        inventario.cargarDesdeArchivo(ruta);

        venta = new Venta(inventario);
        sc = new Scanner(System.in);

        do {
            System.out.println("\n==== MENÚ TIENDA ====");
            System.out.println("Bienvenido, " + clienteActual.getNombre() + "!");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Agregar producto al carrito");
            System.out.println("3. Ver ticket actual");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Salir sin comprar");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    inventario.mostrarInventario();
                    break;
                case 2:
                    System.out.print("Ingrese ID del producto: ");
                    String id = sc.next();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    if (venta.agregarAlCarrito(id, cantidad)) {
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("No disponible o stock insuficiente.");
                    }
                    break;
                case 3:
                    venta.imprimirTicket();
                    break;
                case 4:
                    // Finalizar compra y guardar venta
                    if (venta.tieneProductos()) {
                        venta.imprimirTicket();
                        
                        // Guardar la venta en el archivo CSV
                        if (guardarVentaEnCSV(clienteActual, venta)) {
                            System.out.println("Venta registrada exitosamente.");
                        } else {
                            System.out.println("Error al registrar la venta, pero la compra se completó.");
                        }
                        
                        // Guardar cambios en inventario
                        inventario.guardarCambios(ruta);
                        System.out.println("Compra finalizada. ¡Gracias por su compra, " + clienteActual.getNombre() + "!");
                        opcion = 5;
                    } else {
                        System.out.println("No hay productos en el carrito.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo... ¡Hasta luego, " + clienteActual.getNombre() + "!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    // Método para guardar la venta en el archivo CSV
    private boolean guardarVentaEnCSV(Cliente cliente, Venta venta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaVentas, true))) {
            // Obtener datos de la venta
            LocalDateTime fechaHora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHoraStr = fechaHora.format(formatter);
            
            // Generar ID único de venta
            String ventaId = "V" + System.currentTimeMillis();
            
            // Obtener total de la venta
            double total = venta.calcularTotal();
            
            // Obtener detalles de productos (esto depende de tu clase Venta)
            String detallesProductos = venta.obtenerDetallesParaCSV();
            
            // Formato: VentaID,FechaHora,ClienteID,ClienteNombre,ClienteEmail,DetallesProductos,Total
            String lineaVenta = String.format("%s,%s,%s,%s,%s,%s,%.2f",
                ventaId,
                fechaHoraStr,
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                detallesProductos,
                total
            );
            
            writer.println(lineaVenta);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al guardar venta: " + e.getMessage());
            return false;
        }
    }

    // Método para crear el encabezado del archivo CSV si no existe
    private void crearEncabezadoCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaVentas))) {
            writer.println("VentaID,FechaHora,ClienteID,ClienteNombre,ClienteEmail,DetallesProductos,Total");
        } catch (IOException e) {
            System.err.println("Error al crear encabezado CSV: " + e.getMessage());
        }
    }
}