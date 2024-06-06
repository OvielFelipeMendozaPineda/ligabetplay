package com.ligabetplay.models;

import java.util.Scanner;

public class CuerpoMedico extends Team{
    String rol;

    public CuerpoMedico(int id, String nombre, String apellido, int edad, String rol) {
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
        System.out.println(String.format("%s está dando un masaje", this.nombre));
    }
    public static CuerpoMedico registrarCuerpoMedico(Scanner input) {
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
        System.out.print("Ingrese el rol: ");
        String rol = input.nextLine();

        CuerpoMedico nuevoCuerpoMedico = new CuerpoMedico(id, nombre, apellido, edad, rol);
        return nuevoCuerpoMedico;
    }
}
