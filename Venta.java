package com.mycompany.Ducknology;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private List<DetalleVenta> detalles = new ArrayList<>();
    private Inventario inventario;

    public Venta(Inventario inventario) {
        this.inventario = inventario;
    }

    public boolean agregarAlCarrito(String id, int cantidad) {
        Producto p = inventario.buscarPorId(id);
        if (p != null && p.getStock() >= cantidad) {
            detalles.add(new DetalleVenta(p, cantidad));
            inventario.actualizarStock(id, cantidad);
            return true;
        }
        return false;
    }

    public void cancelarProducto(String id) {
        detalles.removeIf(d -> d.getProducto().getId().equals(id));
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }

    public void imprimirTicket() {
        System.out.println("--- TICKET DE COMPRA ---");
        for (DetalleVenta d : detalles) {
            System.out.println(d);
        }
        System.out.println("TOTAL: $" + calcularTotal());
    }
}