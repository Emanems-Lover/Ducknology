package com.mycompany.Ducknology.ventas;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.Ducknology.Productos.Inventario;
import com.mycompany.Ducknology.Productos.Producto;

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

    public boolean tieneProductos() {
        return !detalles.isEmpty();
    }

    public String obtenerDetallesParaCSV() {
        StringBuilder sb = new StringBuilder();
        for (DetalleVenta item : detalles) {
            if (sb.length() > 0) {
                sb.append(";");
            }
            Producto p = item.getProducto();
            sb.append(p.getId())
              .append("-")
              .append(p.getNombre())
              .append("x")
              .append(item.getCantidad());
        }
        return sb.toString();
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }
}