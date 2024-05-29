package com.ligabetplay.models;

import java.sql.Date;
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
    
}
