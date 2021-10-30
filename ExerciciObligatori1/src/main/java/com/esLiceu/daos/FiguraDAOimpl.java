package com.esLiceu.daos;

import com.esLiceu.models.Figura;
import java.util.ArrayList;
import java.util.List;

public class FiguraDAOimpl implements FiguraDAO{
    static List<Figura> figures = new ArrayList<>();
    static int contador = 0;

    @Override
    public List<Figura> getAllFigures() {
        return figures;
    }

    @Override
    public Figura getFigura(int idFigura) {
        return figures.get(idFigura);
    }

    @Override
    public void saveFigura(Figura figura) {
        figura.setId(contador);
        contador++;
        figures.add(figura);
    }

    @Override
    public void deleteFigura(Figura figura) {
        for (int i = 0; i < figures.size(); i++) {
            if (figura.getId() == figures.get(i).getId()){
                figures.remove(i);
                break;
            }
        }
    }
}
