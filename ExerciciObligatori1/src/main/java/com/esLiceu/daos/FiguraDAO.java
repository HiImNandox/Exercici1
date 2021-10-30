package com.esLiceu.daos;

import com.esLiceu.models.Figura;

import java.util.List;

public interface FiguraDAO {
    List<Figura> getAllFigures();
    Figura getFigura(int idFigura);
    void saveFigura(Figura figura);
    void deleteFigura(Figura figura);
}
