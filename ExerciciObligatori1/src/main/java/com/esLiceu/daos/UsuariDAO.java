package com.esLiceu.daos;

import com.esLiceu.models.Usuari;

import java.util.List;

public interface UsuariDAO {
    public List<Usuari> getAllUsuarios();
    public Usuari getUsuariById(int idUsuari);
    public void saveUsuari(Usuari usuari);
    public void updateUsuari(Usuari usuari);
    public void deleteUsuari(Usuari usuari);
}
