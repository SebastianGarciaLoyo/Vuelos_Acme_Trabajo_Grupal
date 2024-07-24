/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.revision.domain.entity;

/**
 *
 * @author camper
 */
public class Revision {
    private int avion;
    private int ano_revision;
    private int mes_revision;
    private int dia_revision;
    private String descripcion;
    private String empleado;
    public Revision() {
    }
    public int getAvion() {
        return avion;
    }
    public void setAvion(int avion) {
        this.avion = avion;
    }
    public int getAno_revision() {
        return ano_revision;
    }
    public void setAno_revision(int ano_revision) {
        this.ano_revision = ano_revision;
    }
    public int getMes_revision() {
        return mes_revision;
    }
    public void setMes_revision(int mes_revision) {
        this.mes_revision = mes_revision;
    }
    public int getDia_revision() {
        return dia_revision;
    }
    public void setDia_revision(int dia_revision) {
        this.dia_revision = dia_revision;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEmpleado() {
        return empleado;
    }
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    

    
}
