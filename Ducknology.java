package com.mycompany.Ducknology;

import java.io.IOException;
import java.util.Scanner;

import com.mycompany.Ducknology.Gestores.GestorClientes;
import com.mycompany.Ducknology.InterfacesUsuarios.ClientesGUI;
import com.mycompany.Ducknology.InterfacesUsuarios.DuckGUI;
import com.mycompany.Ducknology.InterfacesUsuarios.MenuTienda;
import com.mycompany.Ducknology.Usuarios.Cliente;

public class Ducknology {

    public static void main(String[] args) throws IOException {
        Scanner pato = new Scanner(System.in);
        int option;

        do {
            DuckGUI duckGUI = new DuckGUI();
            DuckGUI.mostrarOpciones();
            option = pato.nextInt();
            pato.nextLine(); // Limpiar buffer

            switch (option) {
                case 1 : iniciarFlujoCliente(); break;
                case 2 : 
                case 3 :
                case 0 :System.out.println("Saliendo del programa...");
                default : System.out.println("Opción no válida.");
            }

        } while (option != 0);

        pato.close();
    }
     private static void iniciarFlujoCliente()throws IOException {
    String rutaCliente = "src/Data/clientes.csv";
    GestorClientes gestorClientes = new GestorClientes(rutaCliente);
    gestorClientes.cargarPatoClientes();
    Scanner pato = new Scanner(System.in);

    ClientesGUI clienteGUI = new ClientesGUI(gestorClientes);
    Cliente clienteActual = clienteGUI.menuRegistroCliente(pato);

    if (clienteActual != null) {
        System.out.println("¡Accediendo al sistema de compras!");
        MenuTienda menuTienda = new MenuTienda(); 
        menuTienda.iniciar(pato, clienteActual);

    } else {
        System.out.println("No se pudo iniciar sesión o registro.");
    }
}
}