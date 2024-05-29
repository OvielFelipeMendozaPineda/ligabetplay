package com.ligabetplay.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Club {
    private String nombre;
    private int pj;
    private int pg;
    private int pp;
    private int pe;
    private int gf;
    private int gc;
    private int tp;

    public Club(String nombre) {
        this.nombre = nombre;
        this.pj = 0;
        this.pg = 0;
        this.pp = 0;
        this.pe = 0;
        this.gf = 0;
        this.gc = 0;
        this.tp = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPj() {
        return pj;
    }

    public void setPj(int pj) {
        this.pj += pj;
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg += pg;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp += pp;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe += pe;
    }

    public int getGf() {
        return gf;
    }

    public void setGf(int gf) {
        this.gf += gf;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc += gc;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp += tp;
    }

    public static void MostrarStats(ArrayList<Club> list) {
        for (Club club : list) {
            System.out.println("Nombre: " + club.getNombre());
            System.out.println("Partidos Jugados: " + club.getPj());
            System.out.println("Partidos Ganados: " + club.getPg());
            System.out.println("Partidos Perdidos: " + club.getPp());
            System.out.println("Partidos Empatados: " + club.getPe());
            System.out.println("Goles a Favor: " + club.getGf());
            System.out.println("Goles en Contra: " + club.getGc());
            System.out.println("Total de Puntos: " + club.getTp());
            System.out.println();
        }
    }

    public static Club registrarClub(ArrayList<Club> list, Scanner input){
        try {
            System.out.print("Ingrese nombre del equipo: ");
            input.nextLine();
            String nombre = input.nextLine();
            for (Club club : list) {
                if (club.getNombre().equals(nombre)) {
                    System.out.println("El equipo " + nombre + "ya está registrado.");
                    return null;
                }
            }
            Club nuevoClub = new Club(nombre);
            System.out.println(String.format("Se registro corretamente el equipo %s", nuevoClub.getNombre()));
            return nuevoClub;
        
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static double masGoles(ArrayList<Club> list) {
        int acum = 0;
        for (Club club : list) {
            acum += club.getGf();
        }
        System.out.println(String.format("El total de goles fue de %d", acum));
        double promedioGoles = acum / list.size();
        return promedioGoles;
    }

    public static double promGoles(ArrayList<Club> list) {
        int acum = 0;
        for (Club club : list) {
            acum += club.getGf();
        }
        double promedioGoles = acum / list.size();
        return promedioGoles;
    }

    public static void getData(ArrayList<Club> list, ClubMetric metric, String mensaje) {
        if (list.size() == 0) {
            throw new Error("No hay equipos registrados.");
        }
        Club team = list.get(0);
        int majorMetric = metric.getMetric(team);
        for (Club club : list) {
            if (metric.getMetric(club) > majorMetric) {
                team = club;
                majorMetric = metric.getMetric(club);
                System.out.println(majorMetric);
            }
        }
        System.out.println(mensaje + " " + team.getNombre());
    }

}
