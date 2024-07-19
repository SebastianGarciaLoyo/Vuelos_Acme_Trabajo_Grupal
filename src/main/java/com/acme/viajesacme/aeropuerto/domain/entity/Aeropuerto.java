package com.acme.viajesacme.aeropuerto.domain.entity;

public class Aeropuerto {
    private String id_aeropuerto;
    private String nombre;
    private String ciudad;
    private String pais;
    public Aeropuerto() {
    }
    public String getId_aeropuerto() {
        return id_aeropuerto;
    }
    public void setId_aeropuerto(String id_aeropuerto) {
        this.id_aeropuerto = id_aeropuerto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    
}
