package com.ligabetplay.models;

public class Jugador extends Team {
    int dorsal;
    String posicion;
    String nacionalidad;
    String fechaIngreso;
    int tolesAnotados;
    int tarjetasAmarillas;
    int tarjetasRojas;
    public Jugador(int id, String nombre, String apellido, String edad, int dorsal, String posicion,
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
    
}
