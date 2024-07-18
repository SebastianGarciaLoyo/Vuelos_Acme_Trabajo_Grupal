package com.acme.viajesacme.avion.domain.entity;

public class Modelo {
    private int id_modelo;
    private String modelo;
    private int id_fabricante;
    public Modelo() {
    }
    public int getId_modelo() {
        return id_modelo;
    }
    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getId_fabricante() {
        return id_fabricante;
    }
    public void setId_fabricante(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }

    
}
