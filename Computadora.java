/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopoo;

/**
 *
 * @author Mario es puto
 */
public class Computadora extends Producto{
    //atrubtos
    private String prosesador;
    private String ram;
    private String almacenamiento;
    private String gpu;

    public Computadora(String prosesador, String ram, String almacenamiento, String gpu, String id, String nombre, String marca, String gamma, boolean stock) {
        super(id, nombre, marca, gamma, stock);
        this.prosesador = prosesador;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
        this.gpu = gpu;
    }

    

    public String getProsesador() {
        return prosesador;
    }

    public void setProsesador(String prosesador) {
        this.prosesador = prosesador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }
    
    
    
    
    
}
