package com.ligabetplay.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Team {
    int dorsal;
    String posicion;
    String nacionalidad;
    String fechaIngreso;
    int tolesAnotados;
    int tarjetasAmarillas;
    int tarjetasRojas;
    public Jugador(int id, String nombre, String apellido, int edad, int dorsal, String posicion,
            String nacionalidad, String fechaIngreso, int tolesAnotados, int tarjetasAmarillas, int tarjetasRojas) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.tolesAnotados = tolesAnotados;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }
    
    
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getTolesAnotados() {
        return tolesAnotados;
    }

    public void setTolesAnotados(int tolesAnotados) {
        this.tolesAnotados = tolesAnotados;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    @Override
    public void concentrarse() {
        System.out.println(String.format("El jugador %s se está concentrando.", this.nombre));
    }
    @Override
    public void viajar() {
        System.out.println(String.format("El jugador %s está viajanding.", this.nombre));
    }
    public void jugarPartido() {
        
        System.out.println(String.format("El jugador %s está jugando el partido.", this.nombre));
    }
    public void entrenar() {
        
        System.out.println(String.format("El jugador %s está entrenando.", this.nombre));
    }
    public static Jugador registrarJugador(Scanner input) {
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
        System.out.print("Ingrese el dorsal: ");
        int dorsal = input.nextInt();
        input.nextLine(); 
        System.out.print("Ingrese la posición: ");
        String posicion = input.nextLine();
        System.out.print("Ingrese la nacionalidad: ");
        String nacionalidad = input.nextLine();
        System.out.print("Ingrese la fecha de ingreso (YYYY-MM-DD): ");
        String fechaIngreso = input.nextLine();
        System.out.print("Ingrese los goles anotados: ");
        int golesAnotados = input.nextInt();
        input.nextLine(); 

        System.out.print("Ingrese las tarjetas amarillas: ");
        int tarjetasAmarillas = input.nextInt();
        input.nextLine();

        System.out.print("Ingrese las tarjetas rojas: ");
        int tarjetasRojas = input.nextInt();
        input.nextLine();

        Jugador newJugador = new Jugador(id, nombre, apellido, edad, dorsal, posicion, nacionalidad, fechaIngreso, golesAnotados, tarjetasAmarillas, tarjetasRojas);
        return newJugador;
    }
    
    public static void getData(ArrayList<Jugador> list, PlayerMetric metric, String mensaje) {
        if (list.size() == 0) {
            System.out.println("No hay jugadores registrados.");
        } else {
            Jugador player = list.get(0);
            int maxMetric = metric.getMetric(player);
            for (Jugador jugador : list) {
                if (metric.getMetric(jugador) > maxMetric) {
                    maxMetric = metric.getMetric(jugador);
                    player = jugador;
                }
            }
            System.out.println(mensaje + " " + player.getNombre());
        }
    }
    public static void getPlantel(Scanner input, ArrayList<Club> list) {
        System.out.println("Seleccione el equipo para mostrar el plantel de jugadores\n");
        Club.ListarClubes(list);
        Club equipo = list.get(input.nextInt()-1);
        for (Jugador jugador : equipo.getPlantel()) {
            System.out.println("Nombre: " + jugador.getNombre() + " " + jugador.getApellido() );
            System.out.println("Dorsal: " + jugador.getDorsal());
            System.out.println("Posicion " + jugador.getPosicion());
            System.out.println("-----------------------------------");
        }
    }
    public static void reportesJugador(Scanner input, ArrayList<Jugador> list, ArrayList<Club> clubList) {
        System.out.println("\t1. Jugador con más goles anotados\n\t2. Jugador con más tarjetas amarillas\n\t3. Jugador con más tarjetas rojas.\n\t4. Listar plantel por equipo.");
        switch (input.nextInt()) {
            case 1: 
                getData(list, lista -> lista.getTolesAnotados(), "Jugador con mas goles:");
                break;
            case 2:
                getData(list, lista -> lista.getTarjetasAmarillas(), "Jugador con mas tarjetas amarillas.");
                break;
            case 3:
                getData(list, lista -> lista.getTarjetasRojas(), "Jugador con mas tarjetas rojas.");
                break;
            case 4:
                getPlantel(input, clubList);
            default:
                break;
        }
    }
}
