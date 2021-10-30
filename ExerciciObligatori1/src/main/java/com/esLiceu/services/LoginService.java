package com.esLiceu.services;

import com.esLiceu.daos.UsuariDAO;
import com.esLiceu.daos.UsuariDAOimpl;
import com.esLiceu.models.Usuari;

public class LoginService {

    UsuariDAO usuariDAO = new UsuariDAOimpl();

    public void nouUsuari(String usuari, String contrasenya){
        Usuari u = new Usuari();
        u.setUsuari(usuari);
        u.setContrasenya(contrasenya);
        usuariDAO.saveUsuari(u);
    }

    public boolean checkUsuari(String usuari, String contrasenya){
        for (int i = 0; i < usuariDAO.getAllUsuarios().size(); i++) {
            if(usuariDAO.getAllUsuarios().get(i).getUsuari().equals(usuari)){
                if(usuariDAO.getAllUsuarios().get(i).getContrasenya().equals(contrasenya)){
                    return true;
                }
            }
        }
        return false;
    }


}
