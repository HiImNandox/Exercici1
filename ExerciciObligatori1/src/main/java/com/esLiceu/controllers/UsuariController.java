package com.esLiceu.controllers;
import com.esLiceu.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class UsuariController extends HttpServlet {
    LoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*

        Mostrar es formulari
         */
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        Comprobar si lo que arriba es correcte o no
         */

        String user = req.getParameter("usuari");
        String pass = req.getParameter("contrasenya");

        if(loginService.checkUsuari(user, pass)) {
            /*
                usuari correcte-
                hem de possar dins la sessio la indentificacio del usuari
                i mostrar un missatge que el usuari se ha logeat correctament
                o un reedirect cap al formulari de figura
             */

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(req, resp);
        }else{
            /*
                Usuari incorrecte
                mostrar un missatge que el usuari no es identifica
            */
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
