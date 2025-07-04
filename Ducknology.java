    package com.mycompany.Ducknology;
import java.io.IOException;
import java.util.Scanner;

public class Ducknology {

    //Prueba gestion de inventario
    public static void main(String[] args) throws IOException {
        String rutaCliente= "src/Data/clientes.csv";
        Scanner pato= new Scanner(System.in);

         System.out.println("Bienvenido a Ducknology");
        System.out.println("Pato computadoras y pato componentes de la mejor calidad");
        int option;
        do { 
            System.out.println("¿Qué tipo de usuario eres?");
            System.out.println("1. Cliente");
            System.out.println("2. Empleado");
            System.out.println("3. Gerente");
            System.out.println("0. Salir");
            option = pato.nextInt();
            pato.nextLine(); // Limpiar buffer
            
            switch(option) {
                case 1:
                    System.out.println("Bienvenido a la pato familia Ducknology gracias por elegirnos");
                    System.out.println("Si ya tiene una cuenta, por favor, presione 1, de lo contrario, continue cn el registro");
                    int yaTengo=pato.nextInt();
                    if(yaTengo!=1){
                    System.out.println("ponga sus respectivos datos :");
                    System.out.print("ID de cliente: ");
                    String id = pato.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = pato.nextLine();
                    System.out.print("Correo: ");
                    String correo = pato.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = pato.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = pato.nextLine();
                    System.out.println("Contraseña: ");
                    String contraseña = pato.nextLine();
                    
                    // Crear gestor de clientes
                    GestorClientes gestorClientes = new GestorClientes(rutaCliente);
                    gestorClientes.cargarPatoClientes();
                    
                    // Crear nuevo cliente con los datos ingresados
                  Cliente Cliente=new Cliente(id, nombre, correo, telefono, direccion, contraseña);
                    
                    // Agregar cliente al gestor
                 gestorClientes.agregarPatoCliente(Cliente);
                    
                    // Guardar cambios en el archivo CSV
                  
                    
                System.out.println("Cliente registrado exitosamente!");
                    }
                    else{
                        System.out.println("ingrese su id de cliente");
                        String idCliente = pato.nextLine();
                        GestorClientes gestorClientes = new GestorClientes(rutaCliente);
                        gestorClientes.cargarPatoClientes();
                        if(gestorClientes.existeCliente(idCliente)){
                            System.out.println("Bienvenido de nuevo patocliente " + idCliente);
                        }else{
                            System.out.println("Patocliente no encontrado, por favor registrese");
                            continue;
                        }
                    }

                // Continuar con el proceso de compra
                Inventario inventario = new Inventario();
                String ruta = "src/Data/productos.csv";
                inventario.cargarDesdeArchivo(ruta);
                Venta venta = new Venta(inventario);
                Scanner sc = new Scanner(System.in);
                int opcion;

                do {
                    System.out.println("\n==== MENÚ TIENDA ====");
                    System.out.println("1. Mostrar productos existentes");
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
                            String idProducto = sc.next();
                            System.out.print("Cantidad: ");
                            int cantidad = sc.nextInt();
                            if (venta.agregarAlCarrito(idProducto, cantidad)) {
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
                break;
                
                  //Logica para empreado
            case 2:
                System.out.println("");
              
                break;

                    //logica para la clase Gerentee
                    
                case 3:
                    System.out.println("hello Gerente bienvenido a nuestra tienda amo");

                    Gerente gerente = new Gerente("1e9", "gato albañil", "gato.albañil@whyskas.com", "445 666 6664", "casa de mario", "gato", true, true,"aaa");

                    System.out.println("desea quitar lagañas al gerente");
                    System.out.println("1. porsupues que si");
                    System.out.println("2. nel pastel");
                    int decision= pato.nextInt();
                    pato.nextLine(); // Limpiar buffer
                    if(decision ==1){

                        gerente.quitarLagañas();
                        System.out.println("laguñas quitadas");
                    }else{
                        System.out.println("bueno, no las quitamos");
                    }

                    System.out.println("desea gritar a los empleados");
                    System.out.println("1. porsupuesto que si");
                    System.out.println("2.nel respecto");

                    int decision2= pato.nextInt();
                    pato.nextLine(); // Limpiar buffer

                    if(decision2 ==1){
                        gerente.gritar();
                    }else{
                        System.out.println("bueno no gritemos");
                    }
                    
                    break;
                    

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
                    break;

                
            }
            break;
           


            
        } while(option != 0);
        
    }
}