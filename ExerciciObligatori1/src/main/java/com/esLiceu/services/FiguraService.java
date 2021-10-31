package com.esLiceu.services;

import com.esLiceu.daos.FiguraDAO;
import com.esLiceu.daos.FiguraDAOimpl;
import com.esLiceu.models.Figura;

import java.util.ArrayList;


public class FiguraService {
    FiguraDAO figuraDAO = new FiguraDAOimpl();
    public void novaFigura(int x, int y, int tamany, String tipo, String nom, String color,String propietari){
        Figura f = new Figura();
        f.setCx(x);
        f.setCy(y);
        f.setTamany(tamany);
        f.setTipus(tipo);
        f.setColor(color);
        f.setNom(nom);
        f.setPropietari(propietari);
        figuraDAO.saveFigura(f);
    }
    public int obtenirTipusDeFigura(String tipus){
        int tornarTipus = 0;
        switch (tipus){
            case "Triangle":
                tornarTipus = 1;
                break;
            case "Cuadrat":
               tornarTipus = 2;
                break;
            case "Cercle":
                tornarTipus = 3;
                break;
            case "Pentagon":
                tornarTipus = 4;
                break;
            case "Estrella":
                tornarTipus = 5;
                break;
        }
        return tornarTipus;
    }
    public ArrayList<Integer> obtenirTotesIDs(){
       ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 0; i < figuraDAO.getAllFigures().size(); i++) {
            ids.add(figuraDAO.getAllFigures().get(i).getId());
        }
        return ids;
    }

}
