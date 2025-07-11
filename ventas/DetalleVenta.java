package com.mycompany.Ducknology.ventas;

import com.mycompany.Ducknology.Productos.Producto;

public class DetalleVenta {
    private Producto producto;
    private int cantidad;

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x" + cantidad + " = $" + getSubtotal();
    }
}
