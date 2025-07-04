package com.mycompany.Ducknology;

import java.util.Scanner;

public class MenuTienda {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        String ruta = "src/Data/productos.csv";
        inventario.cargarDesdeArchivo(ruta);

        Venta venta = new Venta(inventario);
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== MENÚ TIENDA ====");
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
                    venta.imprimirTicket();
                    inventario.guardarCambios(ruta);
                    System.out.println("Compra finalizada. ¡Gracias!");
                    opcion = 5;
                    break;
                case 5:
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}