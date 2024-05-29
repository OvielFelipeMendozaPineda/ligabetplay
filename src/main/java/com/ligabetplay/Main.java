package com.ligabetplay;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.ligabetplay.models.Club;
import com.ligabetplay.models.ClubMetric;
import com.ligabetplay.models.Partido;

public class Main {
    public static void main(String[] args) {
        // Menu principal
        ArrayList<Club> clubList = new ArrayList<>(); // ArrayList con los equipos registrados
        Club equipo1 = new Club("Atlético Bucaramanga");
        Club equipo2 = new Club("Millonarios");
        Club equipo3 = new Club("Deportivo Cali");
        Club equipo4 = new Club("Junior");
        Club equipo5 = new Club("Santa Fe");
        Club equipo6 = new Club("América de Cali");
        Club equipo7 = new Club("Atlético Nacional");
        Club equipo8 = new Club("Once Caldas");
        Club equipo9 = new Club("Independiente Medellín");
        Club equipo10 = new Club("Deportes Tolima");
        clubList.add(equipo1);
        clubList.add(equipo2);
        // clubList.add(equipo3);
        // clubList.add(equipo4);
        // clubList.add(equipo5);
        // clubList.add(equipo6);
        // clubList.add(equipo7);
        // clubList.add(equipo8);
        // clubList.add(equipo9);
        // clubList.add(equipo10);

        
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Gestor de clubes y partidos del FPC");
            System.out.println("Selecciones una opcion\n\t1. Registrar Club.\n\t2. Registrar Partido\n\t3. Reportes.");
            try {
                int opcUser = input.nextInt();
                switch (opcUser) {
                    case 1:
                        Club nuevoClub = registrarClub(input);
                        clubList.add(nuevoClub);
                        break;
                    case 2:
                    registrarPartido(clubList, input);
                        break;
                    case 3:
                    reportes(clubList, input);;
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e);
            }
        }
    }
    public static Club registrarClub(Scanner input){
        try {
            
            System.out.println("Ingrese nombre del equipo");
            Club nuevoClub = new Club(null);
            nuevoClub.setNombre(input.nextLine());
            System.out.println(String.format("Se registro corretamente el equipo %s", nuevoClub.getNombre()));
            return nuevoClub;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static Partido registrarPartido(ArrayList<Club> list, Scanner input) {
        try {

            String fecha = getInput("Ingrese la fecha en formato dd/mm/aaaa.", input);

            int equipoLocalIndex = getTeam("Seleccione el numero del equipo local.", input, list);
            Club equipoLocal = list.get(equipoLocalIndex);

            int equipoVisitanteIndex = getTeam("Seleccione el numeror el equipo visitante.", input, list);
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
            
            return nuevoPartido;
        } 
        catch (Exception e) {
            System.out.println("Ocurrio un error. " + e);
            return null;
        }
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
        return input.nextLine();
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
        System.out.println(metric.toString());
        System.out.println(mensaje + " " + team.getNombre());
    }
    public static void reportes(ArrayList<Club> list, Scanner input ) {
        int opcUser = input.nextInt();
        switch (opcUser) {
            case 1:
                getData(list, lista -> lista.getGf(),"Equipo con más goles" );
                break;
            case 2:
                getData(list, lista -> lista.getTp(), "Equipo con más puntos");
                break;
            case 3:
                System.out.println();
                getData(list, lista -> lista.getPg(), "Equipo con más partidos ganados");
                break;
            case 4:
                System.out.println("total de goles anotados");
                masGoles(list);
                break;
            case 5:
                System.out.println("Promedio de goles en el torneo");
                double promedioGoles = promGoles(list);
                System.out.println(String.format("El promedio de goles fue %d", promedioGoles));
                break;
            default:
                break;
        }
    }
    public static double masGoles(ArrayList<Club> list) {
        int acum = 0;
        for (Club club : list) {
            acum += club.getGf();
        }
        System.out.println(String.format("El total de goles fue de %d", acum));
        double promedioGoles = acum/list.size();
        return promedioGoles;
    }
    public static double promGoles(ArrayList<Club> list) {
        int acum = 0;
        for (Club club : list) {
            acum += club.getGf();
        }
        double promedioGoles = acum/list.size();
        return promedioGoles;
    }

}