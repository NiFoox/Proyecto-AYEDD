package com.example;

public class Usuario {
    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private int dni;

    public Usuario(String nombre, String correoElectronico, String contraseña, int dni) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getDni() {
        return dni;
    }
}