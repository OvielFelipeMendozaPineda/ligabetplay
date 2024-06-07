package com.ligabetplay.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Club {
    private String nombre;
    private ArrayList<Jugador> plantel;
    private ArrayList<CuerpoTecnico> cuerpoTecnico;
    private ArrayList<CuerpoMedico> cuerpoMedico;
    private int tp;
    private int pj;
    private int pg;
    private int pp;
    private int pe;
    private int gf;
    private int gc;
    
    public Club(String nombre) {
        this.nombre = nombre;
        this.plantel = new ArrayList<Jugador>();
        this.cuerpoTecnico = new ArrayList<CuerpoTecnico>();
        this.tp = 0;
        this.pj = 0;
        this.pg = 0;
        this.pp = 0;
        this.pe = 0;
        this.gf = 0;
        this.gc = 0;
    }

    public void setPlantel(ArrayList<Jugador> plantel) {
        this.plantel = plantel;
    }

    public ArrayList<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public void setCuerpoTecnico(ArrayList<CuerpoTecnico> cuerpoTecnico) {
        this.cuerpoTecnico = cuerpoTecnico;
    }

    public ArrayList<CuerpoMedico> getCuerpoMedico() {
        return cuerpoMedico;
    }

    public void setCuerpoMedico(ArrayList<CuerpoMedico> cuerpoMedico) {
        this.cuerpoMedico = cuerpoMedico;
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
    
    public ArrayList<Jugador> getPlantel() {
        return plantel;
    }
    
    public void agregarJugadorPlantel(Jugador jugador) {
        this.plantel.add(jugador);
        System.out.println("Se añadio correctamente el jugador al plantel");
    }
    
    public void agregarCuerpoTecnico(CuerpoTecnico integrante) {
        this.cuerpoTecnico.add(integrante);
        System.out.println("Se añadio correctamente al cuerpo técnico");
    }
    public void agregarCuerpoMedico(CuerpoMedico integrante) {
        this.cuerpoMedico.add(integrante);
        System.out.println("Se añadio correctamente al cuerpo técnico");
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
                System.out.println(mensaje + " " + team.getNombre());
            }
            if (metric.getMetric(club) == majorMetric) {
                mensaje = "Todos los equipos tienen los mismos puntos: " + metric.getMetric(club);
                System.out.println(mensaje);
            }
            
        }
        
    }

    public static void ListarClubes(ArrayList<Club> clubList) {
        int i = 0;
        for (Club club : clubList) {
            System.out.println(i+1+ "." + " " + club.getNombre());
            i++;
        }
    }
    public static void listarCuerpoTecnico(ArrayList<CuerpoTecnico> cuerpoTecnicoList) {
        for (CuerpoTecnico integrante : cuerpoTecnicoList) {
            System.out.println(String.format("Nombre: %s Rol: %s", integrante.getNombre(), integrante.getRol()));
        }

    }


}
