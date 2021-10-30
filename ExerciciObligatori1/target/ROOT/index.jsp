<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action = "/login" method = "post">
            <input type="text" name="usuari">
            <input type="text" name="contrasenya">
            <input type="submit" >
        </form>
    </body>
</html>