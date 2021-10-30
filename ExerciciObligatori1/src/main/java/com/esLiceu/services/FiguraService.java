package com.esLiceu.services;

import com.esLiceu.daos.FiguraDAO;
import com.esLiceu.daos.FiguraDAOimpl;
import com.esLiceu.models.Figura;

import java.io.PrintWriter;

public class FiguraService {
    FiguraDAO figuraDAO = new FiguraDAOimpl();
    public void novaFigura(int x, int y, int tamany, String tipo, String nom, String color){
        Figura f = new Figura();
        f.setCx(x);
        f.setCy(y);
        f.setTamany(tamany);
        f.setTipus(tipo);
        f.setColor(color);
        f.setNom(nom);
        figuraDAO.saveFigura(f);
    }
    public String pintarCuadrat(int x, int y, int tamany, String color){
        String tornarCuadrat = "        <script>\n" +
                "            var c = document.getElementById(\"canvo\");\n" +
                "            var ctx = c.getContext(\"2d\");\n" +
                "            ctx.fillStyle = \""+color+"\";\n" +
                "            ctx.fillRect("+x+", "+y+", "+tamany+","+tamany+");\n" +
                "            ctx.fill();\n" +
                "        </script>";

        return tornarCuadrat;
    }

    public String pintarCercle(int x, int y, int tamany, String color){
        String tornarCercle="<script>\n" +
                "var c = document.getElementById(\"myCanvas\");\n" +
                "var ctx = c.getContext(\"2d\");\n" +
                "ctx.beginPath();\n" +
                "ctx.arc("+x+", "+y+","+tamany+", 0, 2 * Math.PI);\n" +
                "ctx.stroke();\n" +
                "ctx.fillStyle = \""+color+"\";\n" +
                "ctx.fill();\n" +
                "</script> ";
        return tornarCercle;
    }

    public String pintarTriangle(int x, int y, int tamany, String color){
        String tornarTriangle= "";

        return tornarTriangle;
    }

    public String pintarPentagon(){
        String tornarPentagon="";

        return tornarPentagon;
    }

    public String pintarEstrella(){
        String tornarEstrella="";

        return  tornarEstrella;
    }

}
