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
    private String placa;
    private int capacidad;
    private String fecha_fabricacion;
    private int modelo_id;
    private int estado_id;
    public Avion() {
    }

    

    public Avion(String placa, int capacidad, String fecha_fabricacion, int modelo_id, int estado_id) {
        this.placa = placa;
        this.capacidad = capacidad;
        this.fecha_fabricacion = fecha_fabricacion;
        this.modelo_id = modelo_id;
        this.estado_id = estado_id;
    }



    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getFecha_fabricacion() {
        return fecha_fabricacion;
    }
    public void setFecha_fabricacion(String fecha_fabricacion) {
        this.fecha_fabricacion = fecha_fabricacion;
    }
    public int getModelo_id() {
        return modelo_id;
    }
    public void setModelo_id(int modelo_id) {
        this.modelo_id = modelo_id;
    }
    public int getEstado_id() {
        return estado_id;
    }
    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }



    public String getPlaca() {
        return placa;
    }



    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
}

