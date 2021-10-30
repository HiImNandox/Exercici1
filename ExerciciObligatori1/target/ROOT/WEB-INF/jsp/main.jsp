<%--
  Created by IntelliJ IDEA.
  User: Nando
  Date: 29/10/2021
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="../../css/main.css">
        <title>Dibuixar Figures</title>
    </head>
        <body>
            <header>
                <form action="/main" method="get">

                    Introdueix la coordenada x <input type="number" min="0" name="Cx">
                    Introdueix la coordenada y <input type="number" min="0" name="Cy">
                    Introdueix el tamany <input type="number" min="0" name="tamany">
                    Tipus de Figura <label for="Figures" name="figura"></label>
                    Color de la Figura <label for="Colors" name="color"></label>
                    <select name="Figures">
                        <option value="Triangle">Triangle</option>
                        <option value="Cuadrat">Cuadrat</option>
                        <option value="Cercle">Cercle</option>
                        <option value="Pentagon">Pentagon</option>
                        <option value="Estrella">Estrella</option>
                    </select>
                    <select name="Colors">
                        <option value="BLACK">Negre</option>
                        <option value="GREEN">Verd</option>
                        <option value="RED">Vermell</option>
                        <option value="BLUE">Blau</option>
                        <option value="YELLOW">Groc</option>
                        <option value="GRAY">Gris</option>
                    </select>
                    <input type="submit" name="Imprimir Figura">
                </form>

            </header>
            <main>
                <canvas width="1024" height="768" id="canvo">

                </canvas>
            </main>
        </body>
</html>
