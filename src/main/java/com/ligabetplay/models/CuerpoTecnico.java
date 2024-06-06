package com.ligabetplay.models;

import java.util.Scanner;

public class CuerpoTecnico  extends Team {
    String rol;
    String idFederacion;
    public CuerpoTecnico(int id, String nombre, String apellido, int edad, String rol, String idFederacion) {
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
    public static CuerpoTecnico registrarCuerpoTecnico(Scanner input) {
        System.out.print("Ingrese el ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = input.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = input.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = input.nextInt();
        input.nextLine();
        System.out.print("Ingrese el rol: \n\t1. Técnico\n\t2. Asistente técnico.\n\t3. Preparador físico.\n");
        String rol = "";
        switch (input.nextInt()) {
            case 1:
                rol = "Técnico";
                break;
            case 2:
                rol = "Asistente técnico";
                break;
            case 3:
                rol = "Preparador físico";
                break;
            default:
                break;
        }
        System.out.print("Ingrese el ID de federación: ");
        String idFederacion = input.nextLine();
        CuerpoTecnico nuevoCuerpoTecnico = new CuerpoTecnico(id, nombre, apellido, edad, rol, idFederacion);
        return nuevoCuerpoTecnico;
    }
}
