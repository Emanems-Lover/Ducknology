/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Ducknology;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author MarioPrz && TeresaCoz
 */
class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void cargarDesdeArchivo(String ruta) {
        productos = GestorInventario.leerProductos(ruta);
    }

    public void guardarCambios(String ruta) {
        GestorInventario.guardarProductos(productos, ruta);
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
