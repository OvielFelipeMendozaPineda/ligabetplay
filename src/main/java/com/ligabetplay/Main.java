package com.ligabetplay;
import java.util.ArrayList;
import java.util.Scanner;

import com.ligabetplay.models.Club;
import com.ligabetplay.models.ClubMetric;
import com.ligabetplay.models.CuerpoMedico;
import com.ligabetplay.models.CuerpoTecnico;
import com.ligabetplay.models.Jugador;
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
        clubList.add(equipo3);
        clubList.add(equipo4);
        clubList.add(equipo5);
        clubList.add(equipo6);
        clubList.add(equipo7);
        clubList.add(equipo8);
        clubList.add(equipo9);
        clubList.add(equipo10);
        ArrayList<Jugador> playerList = new ArrayList<>(); // LiSTADO CON TODOS LOS JUGADORES
        Jugador jugador0 = new Jugador(1, "Oviel Felipe", "Mendoza Pineda", 20, 4, "Lateral Derecho","Colombiana" , "2024-06-04");
        playerList.add(jugador0);
        equipo1.agregarJugadorPlantel(jugador0);
        int clubIndex;
        boolean flag = true;
        while (flag) {
            Scanner input = new Scanner(System.in);
            System.out.println("Gestor de clubes y partidos del FPC");
            System.out.println("Selecciones una opcion\n\t1. Registrar Club.\n\t2. Registrar Partido\n\t3. Registrar jugador.\n\t4. Registrar Cuerpo técnico.\n\t5. Registrar cuerpo médico.\n\t6. Listar cuerpo médico.\n\t7. Reportes.\n\t0. Cerrar.");
            try {
                int opcUser = input.nextInt();
                switch (opcUser) {
                    case 1:
                        Club nuevoClub = Club.registrarClub(clubList, input);
                        clubList.add(nuevoClub);
                        break;
                    case 2:
                        Partido.registrarPartido(clubList, input, playerList, playerList);
                        break;
                    case 3:
                        Jugador.registrarJugador(input);
                        break;
                    case 4:
                        CuerpoTecnico newCuerpoTecnico = CuerpoTecnico.registrarCuerpoTecnico(input);
                        System.out.println("Asigne el equipo al que pertenece.\n");
                        Club.ListarClubes(clubList);
                        clubIndex = input.nextInt();
                        clubList.get(clubIndex).agregarCuerpoTecnico(newCuerpoTecnico);
                        break;
                    case 5:
                        CuerpoMedico newCuerpoMedico = CuerpoMedico.registrarCuerpoMedico(input);
                        System.out.println("Asigne el equipo al que pertenece.\n");
                        Club.ListarClubes(clubList);
                        clubIndex = input.nextInt();
                        clubList.get(clubIndex).agregarCuerpoMedico(newCuerpoMedico);
                        break;
                    case 6:
                        System.out.println("Selecione el equipo.\n");
                        Club.ListarClubes(clubList);
                        clubIndex = input.nextInt();
                        Club.listarCuerpoTecnico(clubList.get(clubIndex).getCuerpoTecnico());
                        break;
                    case 7:
                        reportes(clubList, input, playerList);
                        break;
                    case 0:
                        flag = false;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e);
            }
        }
    }

    
    public static void reportes(ArrayList<Club> list, Scanner input, ArrayList<Jugador> playerList ) {
        System.out.print("\t1. Equipo con más goles\n\t2. Equipo con más puntos\n\t3. Equipo con más partidos ganados\n\t4. Total goles anotados.\n\t5. Promedio de goles.\n\t6. Reportes jugador. \n\t0. Salir.\n");
        int opcUser = input.nextInt();
        switch (opcUser) {
            case 1:
                Club.getData(list, lista -> lista.getGf(),"Equipo con más goles" );
                break;
            case 2:
                Club.getData(list, lista -> lista.getTp(), "Equipo con más puntos");
                break;
            case 3:
                System.out.println();
                Club.getData(list, lista -> lista.getPg(), "Equipo con más partidos ganados");
                break;
            case 4:
                System.out.println("total de goles anotados");
                Club.masGoles(list);
                break;
            case 5:
                System.out.println("Promedio de goles en el torneo");
                double promedioGoles = Club.promGoles(list);
                System.out.println(String.format("El promedio de goles fue %f", promedioGoles));
                break;
            case 6:
                Jugador.reportesJugador(input, playerList, list);
                break;
            case 0:
                break;
            default:
                break;
        }
    }
}