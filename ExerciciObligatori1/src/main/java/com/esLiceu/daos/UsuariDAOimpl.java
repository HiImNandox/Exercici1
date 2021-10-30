package com.esLiceu.daos;

import com.esLiceu.models.Usuari;
import java.util.ArrayList;
import java.util.List;

public class UsuariDAOimpl implements UsuariDAO{

    static List<Usuari> usuaris = new ArrayList<>();
    static int contador = 0;

    public UsuariDAOimpl(){
        Usuari usuari = new Usuari();
        usuari.setId_bd(1);
        usuari.setUsuari("admin");
        usuari.setContrasenya("admin");
        usuaris.add(usuari);
    }

    @Override
    public List<Usuari> getAllUsuarios() {
        return usuaris;
    }

    @Override
    public Usuari getUsuariById(int idUsuari) {
        for (int i = 0; i < usuaris.size(); i++) {
            if (idUsuari == usuaris.get(i).getId_bd()){
                return usuaris.get(i);
            }
        }
        return null;
    }

    @Override
    public void saveUsuari(Usuari usuari) {
        usuari.setId_bd(contador);
        contador++;
        usuaris.add(usuari);
    }

    @Override
    public void updateUsuari(Usuari usuari) {
        for (int i = 0; i < usuaris.size(); i++) {
            if (usuari.getId_bd() == usuaris.get(i).getId_bd()){
                usuaris.get(i).setUsuari(usuari.getUsuari());
                usuaris.get(i).setUsuari(usuari.getContrasenya());
                break;
            }
        }
    }

    @Override
    public void deleteUsuari(Usuari usuari) {
        for (int i = 0; i < usuaris.size(); i++) {
            if (usuari.getId_bd() == usuaris.get(i).getId_bd()){
                usuaris.remove(i);
                break;
            }
        }
    }
}
