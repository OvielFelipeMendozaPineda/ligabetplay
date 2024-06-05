package com.ligabetplay.models;

public class CuerpoMedico extends Team{
    String rol;

    public CuerpoMedico(int id, String nombre, String apellido, String edad, String rol) {
        super(id, nombre, apellido, edad);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public void darMasaje(){
        System.out.println(String.format("%s está dando un masaje", null));
    }
}
