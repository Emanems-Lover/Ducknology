package com.mycompany.Ducknology.Gestores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.Ducknology.Usuarios.Cliente;
// @ author Duo_Tlacuache 8/jul/2025 1:21:38 am

// Clase que administra una lista de clientes (carga, guarda, busca, agrega) 
public class GestorClientes {

    // Lista en memoria de todos los clientes
    private List<Cliente> clientes = new ArrayList<>();

    // Ruta del archivo donde se guardan los datos de clientes
    private final String rutaArchivo;

    // Constructor que recibe la ruta al archivo CSV de clientes
    public GestorClientes(String rutaCliente) {
        this.rutaArchivo = rutaCliente;
    }

    // Carga los clientes desde el archivo CSV y los guarda en la lista
    public void cargarPatoClientes() throws IOException {
        clientes.clear(); // Limpia la lista para evitar duplicados

        BufferedReader lectorPato = null;

        try {
            lectorPato = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            // Lee el archivo línea por línea
            while ((linea = lectorPato.readLine()) != null) {
                String[] patos = linea.split(","); // Divide los datos por coma

                // Verifica que haya al menos 6 datos antes de crear el objeto
                if (patos.length >= 6) {
                    Cliente cliente = new Cliente(
                        patos[0], patos[1], patos[2],
                        patos[3], patos[4], patos[5]
                    );
                    clientes.add(cliente); // Agrega el cliente a la lista
                }
            }
        } catch (IOException e) {
            // Manejo de errores de lectura
            System.out.println("Error al leer archivo: " + e.getMessage());
        } finally {
            // Cierra el lector si fue abierto
            if (lectorPato != null) {
                lectorPato.close();
            }
        }
    }

    // Verifica si ya existe un cliente con un ID específico
    public boolean existeCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // Busca y devuelve un cliente por su ID (o null si no lo encuentra)
    public Cliente buscarPorId(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // Guarda todos los clientes actuales en el archivo CSV
    public void guardarPatoClientes() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo))) {
            // Escribe cada cliente convertido a formato CSV
            for (Cliente c : clientes) {
                escritor.write(c.toCSV());
                escritor.newLine(); // Salto de línea para el siguiente cliente
            }
            System.out.println("Clientes guardados correctamente.");
        } catch (IOException e) {
            // Manejo de errores al guardar
            System.err.println("Error al guardar los clientes: " + e.getMessage());
        }
    }

    // Agrega un nuevo cliente a la lista, si no existe uno con el mismo ID
    public void agregarPatoCliente(Cliente nuevo) {
        if (existeCliente(nuevo.getId())) {
            System.out.println("Ese cliente ya existe.");
            return;
        }
        clientes.add(nuevo); // Agrega cliente si no hay duplicado
    }
    public void vaciarClientes() {
        clientes.clear(); // Limpia la lista de clientes
        System.out.println("Lista de clientes vaciada.");
    }
}