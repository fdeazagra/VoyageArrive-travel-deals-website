<%-- 
    Document   : ErrorUsuario
    Created on : 04-abr-2021, 21:12:42
    Author     : Fernando Martínez de Azagra Detraux

    Página que nos indica que ha habido un error en el login de usuario
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <style type="text/css">
            #link{
                font-size: 14pt;
                color: white;
                }
        </style>
        <title>Error Validación</title>
    </head>
        <body>
            <div class="contenedor">
                <img src="pictures/Portada.jpg" alt="" id="portada">
                <div class="logo">
                    <h1 id="voyagearrive">Voyage-Arrivé</h1>
                </div>
                <div class="formulario">    
                    <h2 id="titulo">Acceso De Usuario</h2>
                    <hr id="linea">
                    <p>Datos Incorrectos</p>
                    <hr id="linea">
                    <form action="index.html" method="get">
                    <input type="submit" value="Volver a Acceder">
                    </form>
                </div>
            </div>
        </body>
</html>
