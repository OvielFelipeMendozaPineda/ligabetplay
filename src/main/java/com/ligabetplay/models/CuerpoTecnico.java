package com.ligabetplay.models;

public class CuerpoTecnico  extends Team {
    String rol;
    String idFederacion;
    public CuerpoTecnico(int id, String nombre, String apellido, String edad, String rol, String idFederacion) {
        super(id, nombre, apellido, edad);
        this.rol = rol;
        this.idFederacion = idFederacion;
    }
    
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getIdFederacion() {
        return idFederacion;
    }
    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    public void dirigirPartido() {
        System.out.println(String.format(" %s está dirigiendo el partido", this.nombre));
    }
    public void dirigirEntrenamiento() {
        System.out.println(String.format(" %s está dirigiendo el entrenamiento", this.nombre));
    }
}
