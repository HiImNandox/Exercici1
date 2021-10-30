package com.esLiceu.models;

public class Usuari {
    private String usuari,contrasenya;
    private int id_bd;

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public int getId_bd() {
        return id_bd;
    }

    public void setId_bd(int id_bd) {
        this.id_bd = id_bd;
    }
}
