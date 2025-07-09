package com.mycompany.Ducknology.Gestores;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.mycompany.Ducknology.Productos.Inventario;
import com.mycompany.Ducknology.Productos.Producto;
import com.mycompany.Ducknology.Productos.ProductoConcreto;

public class GestorProductos {
    Scanner pato = new Scanner(System.in);
    private Inventario inventario;
    String ruta = "src/Data/productos.csv";

    public GestorProductos(Inventario inventario) {
        this.inventario = inventario;
    }

    public void agregarProductoDesdeConsola() {
        System.out.print("ID: ");
        String id = pato.nextLine();
        System.out.print("Nombre: ");
        String nombre = pato.nextLine();
        System.out.print("Precio: ");
        double precio = pato.nextDouble();
        System.out.print("Stock: ");
        int stock = pato.nextInt();
        pato.nextLine(); // limpiar buffer

        ProductoConcreto nuevo = new ProductoConcreto(id, nombre, precio, stock);

        if (inventario.agregarProducto(nuevo)) {
            System.out.println("Producto agregado al inventario.");
            guardarCambios();
        } else {
            System.out.println("Error: No se pudo agregar el producto (posiblemente ID duplicado).");
        }
    }

    public void guardarCambios() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))) {
            for (Producto p : inventario.getProductos()) {
                escritor.write(p.toCSV());
                escritor.newLine();
            }
            System.out.println("Productos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los productos: " + e.getMessage());
        }
    }

    public void guardarCambios(String ruta) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ruta))) {
            for (Producto p : inventario.getProductos()) {
                escritor.write(p.toCSV());
                escritor.newLine();
            }
            System.out.println("Productos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los productos: " + e.getMessage());
        }
    }

    public void mostrarDetallesInventario() {
        System.out.println("\n=== DEBUG: DETALLES DEL INVENTARIO ===");
        System.out.println("Número total de productos: " + inventario.getProductos().size());

        if (!inventario.getProductos().isEmpty()) {
            for (int i = 0; i < inventario.getProductos().size(); i++) {
                Producto p = inventario.getProductos().get(i);
                System.out.printf("%d. ID: '%s' | Nombre: '%s' | Precio: $%.2f | Stock: %d%n",
                        i + 1, p.getId(), p.getNombre(), p.getPrecio(), p.getStock());
            }
        }
    }

    public void eliminarProducto() {
        System.out.print("ID del producto a eliminar: ");
        String id = pato.nextLine();

        if (inventario.eliminarProducto(id)) {
            System.out.println("Producto eliminado correctamente.");
            guardarCambios();
        } else {
            System.out.println("No se encontró el producto con ID: " + id);
        }
    }

    public void buscarProducto() {
        System.out.print("ID del producto a buscar: ");
        String id = pato.nextLine();

        Producto encontrado = inventario.buscarPorId(id);
        if (encontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("No se encontró el producto con ID: " + id);
        }
    }

    public void cargarInventario() {
        inventario.cargarDesdeArchivo(ruta);
        System.out.println("Inventario cargado desde " + ruta);
    }
}