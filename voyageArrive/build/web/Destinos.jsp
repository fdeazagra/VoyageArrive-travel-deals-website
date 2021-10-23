<%-- 
    Document   : Destinos
    Created on : 04-abr-2021, 23:38:34
    Author     : Fernando Martínez de Azagra Detraux

    Página donde se muestran las estancias del destino elegido 
    en la página de bienvenida
--%>

<%@page import="model.Estancia"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Destinos</title>
        <style type="text/css">
            #texto {
                color: whitesmoke;
                font-weight: 400;
                line-height: 1.0;
            }
        </style>
    </head>
    <body>
        <div class="contenedor">
            <img src="pictures/Pizarra.jpg" alt="" id="portada">
            <div class="BBDD">
            <h2 id="titulo2"> Nuestra selección de ofertas para ti:</h2>
            <%
                ArrayList<Estancia> lstEstancias = (ArrayList<Estancia>)
                                        request.getAttribute("FILTRO");
                if(lstEstancias!=null && lstEstancias.size()>0){
                    int i = 1;

                    for(Estancia estancias:lstEstancias){
            %>
                    <ul style="list-style-type: none;">
                        <li id="texto"><%out.println(i + " " +estancias.toString());
                        i++;%></li>
                    </ul>
            <%
                    }
            %>
                    <form action="index.html" method="get">
                    <input type="submit" value="Volver a Inicio">
                    </form>
            <%
                } else { 
            %>
            <p id="titulo">Oops!<br>Sin resultados para tu selección.<br>Elige de nuevo.</p>
            <form action="index.html" method="get">
            <input type="submit" value="Volver a Inicio">
            </form>
            <%
                }
            %>
            
            </div>
        </div>
    </body>
</html>
