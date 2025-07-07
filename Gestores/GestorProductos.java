package com.mycompany.Ducknology.Gestores;

import java.util.Scanner;

import com.mycompany.Ducknology.Productos.Inventario;
import com.mycompany.Ducknology.Productos.Producto;
import com.mycompany.Ducknology.Productos.ProductoConcreto;

public class GestorProductos {
   Scanner pato=new Scanner(System.in);
    private final Inventario inventario;
    String ruta="src/Data/productos.csv"; // Ruta del archivo de inventario

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

        // Instancia la subclase concreta de Producto, por ejemplo ProductoConcreto
        ProductoConcreto nuevo = new ProductoConcreto(id, nombre, precio, stock);
        inventario.agregarProducto(nuevo);
        System.out.println("Producto agregado al inventario.");
    }

    public void guardarCambios(String ruta) {
        inventario.guardarCambios(ruta);
        System.out.println("Inventario guardado.");
    }
    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (Producto producto : inventario.getProductos()) {
            System.out.println(producto);
        }
    }
  
}