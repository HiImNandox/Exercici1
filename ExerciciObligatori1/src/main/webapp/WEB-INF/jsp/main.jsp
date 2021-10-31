<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Nando
  Date: 29/10/2021
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="../../css/main.css">
        <title>Dibuixar Figures</title>
    </head>
        <body>
            <header>
                <form action="/main" method="post">

                    Introdueix la coordenada x <input type="number" min="0" name="Cx" value="0">
                    Introdueix el nom <input type="text" name="nom">
                    Tipus de Figura <select name="figura">
                    <option value="Triangle">Triangle</option>
                    <option value="Cuadrat">Cuadrat</option>
                    <option value="Cercle">Cercle</option>
                    <option value="Pentagon">Pentagon</option>
                    <option value="Estrella">Estrella</option>
                    </select>
                    <br>
                    Introdueix la coordenada y <input type="number" min="0" name="Cy" value="0">
                    Introdueix el tamany <input type="number" min="0" name="tamany" value="0">

                    Color de la Figura <select name="color">
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
                <c:choose>
                    <c:when test="${figura == 1}">
                        <script>
                            let canvas = document.getElementById("canvo");
                            let context = canvas.getContext("2d")

                            context.beginPath();
                            context.moveTo(${CostatX},${CostatY});
                            context.lineTo(200,150);
                            context.lineTo(200,200);
                            context.closePath();
                            context.fillStyle = "${Color}";
                            context.fill();
                        </script>
                    </c:when>
                    <c:when test="${figura == 2}">
                        <script>
                            var c = document.getElementById("canvo");
                            var ctx = c.getContext("2d");
                            ctx.beginPath();
                            ctx.fillStyle = "${Color}";
                            ctx.fillRect(${CostatX}, ${CostatY}, ${Tamany},${Tamany});
                            ctx.fill();
                        </script>
                    </c:when>
                    <c:when test="${figura == 3}">
                        <script>
                            var c = document.getElementById("canvo");
                            var ctx = c.getContext("2d");
                            ctx.beginPath();
                            ctx.arc(${CostatX}, ${CostatY}, ${Tamany}, 0, 2 * Math.PI);
                            ctx.stroke();
                            ctx.fillStyle = "${Color}";
                            ctx.fill();
                        </script>
                    </c:when>
                    <c:when test="${figura == 4}">
                        <script>
                            var canvas=document.getElementById("canvo");
                            var cxt=canvas.getContext("2d");
                            var numberOfSides = 5,
                                size = ${Tamany},
                                Xcenter = ${CostatX},
                                Ycenter = ${CostatY};

                            cxt.beginPath();
                            cxt.moveTo (Xcenter +  size * Math.cos(0), Ycenter +  size *  Math.sin(0));

                            for (var i = 1; i <= numberOfSides;i += 1) {
                                cxt.lineTo (Xcenter + size * Math.cos(i * 2 * Math.PI / numberOfSides), Ycenter + size * Math.sin(i * 2 * Math.PI / numberOfSides));
                            }

                            cxt.lineWidth = 1;
                            cxt.fillStyle = "${Color}";
                            cxt.fill();


                        </script>
                    </c:when>
                    <c:when test="${figura == 5}">
                        <script>
                            var canvas = document.getElementById('canvo');
                            var cxt = canvas.getContext('2d');
                            createStar(cxt,7,100,${Tamany},${CostatX},${CostatY},10);

                            function createStar(cxt,n,r,R,x,y,lwid) {
                                cxt.save();
                                cxt.lineWidth=lwid;
                                cxt.beginPath();
                                cxt.translate(x,y);
                                for(var i=0;i<n;i++){
                                    cxt.lineTo(Math.cos(((1/4 + i)*2*Math.PI/n))*R,-Math.sin(((1/4 + i)*2*Math.PI/n))*R);
                                    cxt.lineTo(Math.cos(((3/4 + i)*2*Math.PI/n))*r,-Math.sin(((3/4 + i)*2*Math.PI/n))*r);
                                }
                                cxt.closePath();
                                cxt.fillStyle = "${Color}";
                                cxt.fill();
                                cxt.restore();
                            }
                        </script>
                    </c:when>
                </c:choose>
            </main>

            <aside>
                <h4>Historial de Figures</h4>
                <form method="get" action="/main">
                    <input type="submit" value="Refrescar">
                </form>
                <table id="historia">
                    <tr>
                        <th>ID</th>
                        <th>Nom </th>
                        <th>Data de Creacio</th>
                        <th>Propietari</th>
                        <th>Modificar</th>
                    </tr>
                    <c:choose>
                        <c:when test="${historial == true}">
                        <p>${ids[1]}</p>
                        </c:when>
                    </c:choose>

                </table>
            </aside>

        </body>
</html>
