package com.mycompany.Ducknology.Gestores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.Ducknology.Usuarios.Cliente;

public class GestorClientes {
    private List<Cliente> clientes = new ArrayList<>();
    private final String rutaArchivo;

    public GestorClientes(String rutaCliente) {
        this.rutaArchivo = rutaCliente;
    }

    public void cargarPatoClientes() throws IOException {
        clientes.clear();
        BufferedReader lectorPato = null;

        try {
            lectorPato = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = lectorPato.readLine()) != null) {
                String[] patos = linea.split(",");

                if (patos.length >= 6) {
                    Cliente cliente = new Cliente(
                        patos[0], patos[1], patos[2],
                        patos[3], patos[4], patos[5]
                    );
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        } finally {
            if (lectorPato != null) {
                lectorPato.close();
            }
        }
    }

    public boolean existeCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarPorId(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    public void guardarPatoClientes() {
        
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Cliente c : clientes) {
                escritor.write(c.toCSV());
                escritor.newLine();
            }
            System.out.println("Clientes guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar los clientes: " + e.getMessage());
        }
    }

    public void agregarPatoCliente(Cliente nuevo) {
        if (existeCliente(nuevo.getId())) {
            System.out.println("Ese cliente ya existe.");
            return;
        }
        clientes.add(nuevo);
    }
}