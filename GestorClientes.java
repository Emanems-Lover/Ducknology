package com.mycompany.Ducknology;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
private List<Cliente> Cliente = new ArrayList<>();
private final String rutaAarchivo;

public GestorClientes(String rutaCliente) {
    this.rutaAarchivo = rutaCliente;
}

public void cargarPatoClientes() throws IOException {
    Cliente.clear();
    BufferedReader  lectorPato = null;
               
            try {
           lectorPato=new BufferedReader(new FileReader(rutaAarchivo));
            String linea;

            while ((linea = lectorPato.readLine()) != null) {
              String[] patos= linea.split(",");

                if (patos.length >= 6) {
                    Cliente cliente = new Cliente(patos[0], patos[1], patos[2], patos[3], patos[4],patos[5]);
                    Cliente.add(cliente);
                } 
            }
        } catch (IOException e) {
            System.out.println("error al leer linea introducida : " + e.getMessage());
        } finally {
            // Cerrar archivo
            try {
                if (lectorPato != null) {
                    lectorPato.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
        lectorPato.close();
}
public boolean existeCliente(String id){
    for(Cliente pato : Cliente){
        if(pato.getId().equalsIgnoreCase(id)){
            return true;
        }
    }
    return false;
}

public void guardarPatoClientes() throws IOException {
    BufferedWriter escritorPato = null;

    for(Cliente pato : Cliente) {
        
        String patolinea= pato.getId()+","+pato.getNombre() + "," +pato.getEmail()+","+pato.getTelefono()+","+pato.getDireccion()+","+ pato.getContraseña();
        escritorPato.write(patolinea);
        escritorPato.newLine();   
    }
}

public void agregarPatoCliente(Cliente cliente){
    for(Cliente pat : Cliente){
        if(cliente.getId().equalsIgnoreCase(pat.getId())){
            System.out.println("ese cliente ya existe");
            return;
        }
    }
    Cliente.add(cliente);
}

}