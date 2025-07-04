package com.mycompany.Ducknology.Productos;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.Ducknology.Gestores.GestorVentas;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void cargarDesdeArchivo(String ruta) {
        productos = GestorVentas.leerProductos(ruta);
    }

    public void guardarCambios(String ruta) {
        GestorVentas.guardarProductos(productos, ruta);
    }

    public void mostrarInventario() {
        for (Producto p : productos) {
            System.out.println(p.toCSV());
        }
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public Producto buscarPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizarStock(String id, int cantidadVendida) {
        Producto p = buscarPorId(id);
        if (p != null && p.getStock() >= cantidadVendida) {
            p.setStock(p.getStock() - cantidadVendida);
            return true;
        }
        return false;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
