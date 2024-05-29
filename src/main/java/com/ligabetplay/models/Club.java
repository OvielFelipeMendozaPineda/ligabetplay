package com.ligabetplay.models;

import java.util.Scanner;

public class Club implements ClubMetric {
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
    @Override
    public int getMetric(Club club) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMetric'");
    }

}
