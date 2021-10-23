<%-- 
    Document   : AltaUsuario
    Created on : 07-abr-2021, 19:28:39
    Author     : Fernando Martínez de Azagra Detraux

    Página para dar de alta a un nuevo usuario en la BBDD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <style type="text/css"></style>
        <title>Alta Usuario</title>
    </head>
    <body>
        <div class="contenedor">
            <img src="pictures/Portada.jpg" alt="" id="portada">
            <div class="logo">
                <h1 id="voyagearrive">Voyage-Arrivé</h1>
            </div>
            <div class="formulario">    
                <h2 id="titulo">Introduzca Sus Datos</h2>
                <hr id="linea">
                <form action="./Controller?ACTION=USUARIO.ADD" method="post"> 
                    <label for="EMAIL">Email</label>
                    <input type="text" name="EMAIL" id="EMAIL"/>
                    <br /><br />
                    <label for="PASS">Password</label>
                    <input type="password" name="PASS" id="PASS"/>
                    <br /><br />
                    <label for="PASS2">Repita Password</label>
                    <input type="password" name="PASS2" id="PASS2"/>
                    <br /><br />
                    <input type="submit" value="Enviar"/>
                    <input type="reset" value="Borrar" name="Borrar" />
                </form>
                <hr id="linea">
            </div>
        </div>
    </body>
</html>
