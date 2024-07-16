/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.avion.domain.entity;

/**
 *
 * @author camper
 */
public class Avion {
    private int placa;
    private int capacidad;
    private int año_fabricacion;
    private int mes_fabricacion;
    private int dia_fabricacion;
    private String estado;
    private String aerolinea;
    private String modelo;
    
    public Avion() {
    
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAño_fabricacion() {
        return año_fabricacion;
    }

    public void setAño_fabricacion(int año_fabricacion) {
        this.año_fabricacion = año_fabricacion;
    }

    public int getMes_fabricacion() {
        return mes_fabricacion;
    }

    public void setMes_fabricacion(int mes_fabricacion) {
        this.mes_fabricacion = mes_fabricacion;
    }

    public int getDia_fabricacion() {
        return dia_fabricacion;
    }

    public void setDia_fabricacion(int dia_fabricacion) {
        this.dia_fabricacion = dia_fabricacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
   
    
    
}
