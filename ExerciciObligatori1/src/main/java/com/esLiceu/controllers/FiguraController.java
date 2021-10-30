package com.esLiceu.controllers;

import com.esLiceu.services.FiguraService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/main")
public class FiguraController extends HttpServlet {
    FiguraService figuraService = new FiguraService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String color = req.getParameter("color");
        String tipus = req.getParameter("figura");
        String nom = req.getParameter("nom");
        String tamany = req.getParameter("tamany");
        String cx = req.getParameter("Cx");
        String cy = req.getParameter("Cy");
        figuraService.novaFigura(Integer.parseInt(cx),Integer.parseInt(cy),
                                Integer.parseInt(tamany),tipus,nom,color);
        figuraService.pintarCuadrat(Integer.parseInt(cx),Integer.parseInt(cy),
                                     Integer.parseInt(tamany),color);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(req, resp);
    }
}
