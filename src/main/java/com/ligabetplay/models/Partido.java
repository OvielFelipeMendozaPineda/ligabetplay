package com.ligabetplay.models;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.ligabetplay.models.Club;

public class Partido {
    String fecha;
    Club equipoLocal;
    Club equipoVisitante;
    int golesEquipoLocal;
    int goleVisitante;

    public Partido(String fecha, Club equipoLocal, Club equipoVisitante, int golesEquipoLocal, int goleVisitante) {
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesEquipoLocal = golesEquipoLocal;
        this.goleVisitante = goleVisitante;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Club getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(Club equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public Club getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(Club equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }
    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }
    public int getGoleVisitante() {
        return goleVisitante;
    }
    public void setGoleVisitante(int goleVisitante) {
        this.goleVisitante = goleVisitante;
    }
    

    public static void showClubList(ArrayList<Club> list) {
        int i = 1;
        for (Club club : list) {
            System.out.println(String.format("%d. %s", i, club.getNombre()));
            i++;
        }
    }
    public static String getInput(String mensaje, Scanner input){
        System.out.println(mensaje);
        String fecha = input.nextLine();
        String fechaRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        Pattern pattern = Pattern.compile(fechaRegex);
        Matcher matcher = pattern.matcher(fecha);
        if (matcher.matches()) {
            System.out.println("Se registro la fecha: "+ fecha);
            return fecha;
        } else {
            System.out.println("Fecha invalida");
            return null;
        }
    }
    public static int getTeam (String mensaje, Scanner input, ArrayList<Club> list ) {
        System.out.println(mensaje);
        showClubList(list);
        return input.nextInt() -1;
    }
    public static int getGoals(String mensaje, Scanner input) {
        System.out.println(mensaje);
        return input.nextInt();
    }
    public static Partido registrarPartido(ArrayList<Club> list, Scanner input) {
        try {
            input.nextLine();
            String fecha = getInput("Ingrese la fecha en formato dd/mm/aaaa.", input);

            int equipoLocalIndex = getTeam("Seleccione el numero del equipo local.", input, list);
            Club equipoLocal = list.get(equipoLocalIndex);
            list.remove(equipoLocalIndex);
            int equipoVisitanteIndex = 1 + getTeam("Seleccione el numeror el equipo visitante.", input, list);
            list.add(equipoLocalIndex, equipoLocal);
            Club equipoVisitante = list.get(equipoVisitanteIndex);
            int golesEquipoLocal = getGoals(String.format("Ingrese goles marcados por %s", list.get(equipoLocalIndex).getNombre()), input);
            int golesEquipoVisitante = getGoals(String.format("Ingrese goles marcados por %s", list.get(equipoVisitanteIndex).getNombre()), input);

            Partido nuevoPartido = new Partido(fecha, equipoLocal, equipoVisitante, golesEquipoLocal, golesEquipoVisitante);

            equipoLocal.setPj(1);
            equipoLocal.setGf(golesEquipoLocal);
            equipoLocal.setGc(golesEquipoVisitante);

            equipoVisitante.setPj(1);
            equipoVisitante.setGf(golesEquipoVisitante);
            equipoVisitante.setGc(golesEquipoLocal);

            if (golesEquipoLocal == golesEquipoVisitante) {
                equipoLocal.setPe(1);
                equipoLocal.setTp(1);
                equipoVisitante.setPe(1);
                equipoVisitante.setTp(1);
                
            }
            if (golesEquipoLocal > golesEquipoVisitante) {
                equipoLocal.setPg(1);
                equipoLocal.setTp(3);
                equipoVisitante.setPp(1);
            }
            if (golesEquipoLocal < golesEquipoVisitante){
                equipoLocal.setPp(1);
                equipoVisitante.setPg(1);
                equipoVisitante.setTp(3);
            }
            
            list.add(equipoLocalIndex, equipoLocal);
            return nuevoPartido;
        } 
        catch (Exception e) {
            System.out.println("Ocurrio un error. " + e);
            return null;
        }
    }
    
}
