<%-- 
    Document   : OfertasFecha
    Created on : 05-abr-2021, 0:16:57
    Author     : Fernando Martínez de Azagra Detraux

    Página donde se muestran las ofertas ordenadas por fin de fecha de oferta 
--%>

<%@page import="model.Estancia"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Ofertas</title>
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
                <h2 id="titulo2">Todas Las Ofertas Activas:</h2>
            <%
                ArrayList<Estancia> lstEstancias = (ArrayList<Estancia>)
                                        request.getAttribute("LISTA_OFERTAS");
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
                }
            %>
                <form action="index.html" method="get">
                <input type="submit" value="Volver a Inicio">
                </form>
            </div>
        </div>
    </body>
</html>
