package com.mycompany.Ducknology.Usuarios;

// pato_coder 10:48 3/07/2025
public class Gerente extends Usuario {
    private boolean chillon=true;
    private boolean lagañas=true;
    private String  estado="Activo";
    
    public Gerente(String id, String nombre, String email, String telefono, String direccion, String contraseña ,boolean chillon, boolean lagañas, String estado) {
        super(id, nombre, email, telefono, direccion, contraseña);
        this.chillon = chillon;
        this.lagañas = lagañas;
        this.estado = estado;

    }
    public void quitarLagañas(){
        if(lagañas){
            lagañas = false;
            System.out.println("se quitaron lagañas");
        }else
            System.out.println("ya no tiene lagañas");
    }

    public void gritar(){
        if(chillon)
            System.out.println("¡A trabajar esclavos!");
        else
            System.out.println("ta vamonos de aqui!!!");
    }

    public void hora(String hora){
        if(hora.equalsIgnoreCase("12:00am")){
            System.out.println("Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau,Miau");
        }else if(hora.equalsIgnoreCase("3:00am")){
            System.out.println("gato se va del trabajo a pelearse al techo con otros gatos");
        }
        else if(hora.equalsIgnoreCase("6:00am")){
            System.out.println("gato muerde al usuario");
    }
}
    // Getters and Setters

    public boolean isChillon() {
        return chillon;
    }

    public void setChillon(boolean chillon) {
        this.chillon = chillon;
    }

    public boolean isLagañas() {
        return lagañas;
    }

    public void setLagañas(boolean lagañas) {
        this.lagañas = lagañas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}
