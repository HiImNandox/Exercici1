package com.esLiceu.controllers;

import com.esLiceu.services.FiguraService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/main")
public class FiguraController extends HttpServlet {
    FiguraService figuraService = new FiguraService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("ids",figuraService.obtenirTotesIDs());
        req.setAttribute("historial",true);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        String tipus = req.getParameter("figura");
        String nom = req.getParameter("nom");
        String tamany = req.getParameter("tamany");
        String cx = req.getParameter("Cx");
        String cy = req.getParameter("Cy");
        HttpSession session = req.getSession();
        String usuari = (String) session.getAttribute("username");
        figuraService.novaFigura(Integer.parseInt(cx),Integer.parseInt(cy),Integer.parseInt(tamany),tipus,nom,color,usuari);


        req.setAttribute("CostatX",cx);
        req.setAttribute("CostatY",cy);
        req.setAttribute("Tamany",tamany);
        req.setAttribute("Color",color);
        req.setAttribute("figura",figuraService.obtenirTipusDeFigura(tipus));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(req, resp);
    }
}
