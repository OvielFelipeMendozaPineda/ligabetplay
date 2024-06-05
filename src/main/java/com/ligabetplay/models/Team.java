package com.ligabetplay.models;

public class Team {
    int id;
    String nombre;
    String apellido;
    String edad;
    public Team(int id, String nombre, String apellido, String edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public void concentrarse() {
        System.out.println(String.format("El miembro del equipo %s se está concentrnado.", this.nombre));
    }
    public void viajar() {
        System.out.println(String.format("El miembro del equipo %s está viajando", this.nombre));
    }
}
