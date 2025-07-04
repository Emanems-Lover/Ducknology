package com.mycompany.Ducknology.Usuarios;

/**
 *
 * @author pato_coder 11:33 am 30/06/25
 */
public class Usuario {
    
    //atributos
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private String contraseña;

    // Constructor
    public Usuario(String id, String nombre, String email, String telefono, String direccion, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }
    // Getters and setters
    public String toCSV() {
    return String.join(",", id, nombre, email, telefono, direccion, contraseña);
}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
   
    
  
    
    
    
}
