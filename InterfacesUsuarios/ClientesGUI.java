package com.mycompany.Ducknology.InterfacesUsuarios;



import java.io.IOException;
import java.util.Scanner;

import com.mycompany.Ducknology.Gestores.GestorClientes;
import com.mycompany.Ducknology.Usuarios.Cliente;

public class ClientesGUI {

    private GestorClientes gestor;

    public ClientesGUI(GestorClientes gestor) {
        this.gestor = gestor;
    }

    public Cliente menuRegistroCliente(Scanner sc) throws IOException {
        
        System.out.println("¿Ya tienes cuenta? (1 = Sí, 0 = No): ");
        int yaTiene = sc.nextInt();
        sc.nextLine();

        if (yaTiene != 1) {
            System.out.println("Registro de nuevo cliente:");

            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();
            System.out.print("Dirección: ");
            String direccion = sc.nextLine();
            System.out.print("Contraseña: ");
            String contraseña = sc.nextLine();

            Cliente nuevo = new Cliente(id, nombre, correo, telefono, direccion, contraseña);
            gestor.agregarPatoCliente(nuevo);
            gestor.guardarPatoClientes(); // Guardar en archivo
            return nuevo;

        } else {
            System.out.print("Ingresa tu ID: ");
            String id = sc.nextLine();
            Cliente existente = gestor.buscarPorId(id);
            if (existente != null) {
                System.out.println("Bienvenido de nuevo, " + existente.getNombre());
                return existente;
            } else {
                System.out.println("Cliente no encontrado.");
                return null;
            }
        }
    }
}