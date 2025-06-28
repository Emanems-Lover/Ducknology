package com.mycompany.proyectopoo;
import java.util.*;

public class Gerente {

    Scanner pato=new Scanner(System.in);
    private String nombre;
    private String experiencia;
    private int edad;
    private Boolean esExigente;

    public Gerente(String nombre , int edad, Boolean esExigente, String experiencia) {
        this.nombre=nombre;
        this.edad = edad;
        this.esExigente = esExigente;
        this.experiencia = experiencia;
    }
    String gerente=("Gato naranja");

    public void mostrarHumor(){
        System.out.println("gato esta de malas");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Boolean getEsExigente() {
        return esExigente;
    }

    public void setEsExigente(Boolean esExigente) {
        this.esExigente = esExigente;
    }
}
