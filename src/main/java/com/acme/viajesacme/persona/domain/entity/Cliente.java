/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acme.viajesacme.persona.domain.entity;

/**
 *
 * @author camper
 */
public class Cliente {
    // Declarando los atributos
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia;
    private String telefono;
    private String rol;
    private Long numId;
    private String tipoId;
    private String tipoSangreRH;
    
    
    // Definiendo los constructores de la clase
    public Cliente() {
        
    }
    
    
    // Definiendo los getter y setter de "id"
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
    // Definiendo los getter y setter de "nombre"
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    // Definiendo los getter y setter de "email"
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    // Definiendo los getter y setter de "contrasenia"
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    // Definiendo los getter y setter de "telefono"
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    // Definiendo los getter y setter de "rol"
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
    // Definiendo los getter y setter de "numId"
    public Long getNumId() {
        return numId;
    }
    public void setNumId(Long numId) {
        this.numId = numId;
    }
    
    
    // Definiendo los getter y setter de "tipoId"
    public String getTipoId() {
        return tipoId;
    }
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    
    
    // Definiendo los getter y setter de "tipoSangreRH"
    public String getTipoSangreRH() {
        return tipoSangreRH;
    }
    public void setTipoSangreRH(String tipoSangreRH) {
        this.tipoSangreRH = tipoSangreRH;
    }
}
