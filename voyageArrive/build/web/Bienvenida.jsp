<%-- 
    Document   : Bienvenida
    Created on : 04-abr-2021, 18:48:22
    Author     : Fernando Martínez de Azagra Detraux

    Página principal desde donde se accede a las ofertas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <style type="text/css"></style>
        <title>Bienvenida</title>
    </head>
    <body>
            <div class="contenedor">
                <div id="usuario">Bienvenido <%=request.getParameter("EMAIL")%></div>
                <img src="pictures/Portada.jpg" alt="" id="portada">
                <div class="logo">
                    <h1 id="voyagearrive">Voyage-Arrivé</h1>
                </div>
                <div class="formulario2">    
                    <h2 id="titulo">Todas Las Ofertas Activas</h2>
                    <hr id="linea">                    
                    <form action="./Controller?ACTION=ESTANCIA.FIND_ALL" method="post">  
                        <input type="submit" value="Buscar Ofertas"/>
                    </form>
                    <hr id="linea">
                </div>
                <div class="formulario">
                    <h2 id="titulo">Búsqueda Personalizada</h2>
                    <hr id="linea">
                    <form action="./Controller?ACTION=ESTANCIA.FILTRO" method="post">
                        <p>
                            Continente de Destino
                            <select name="destino">
                                <option value="">Indiferente</option>                                
                                <option>Europa</option>
                                <option>Africa</option>
                                <option>America</option>
                                <option>Asia</option>
                                <option>Oceanía</option>
                            </select>
                            <br /><br />
                            Categoría del Hotel
                            <select name="categoria_hotel">
                                <option value="">Indiferente</option>                                
                                <option value="5">5 Estrellas</option>
                                <option value="4">4 Estrellas</option>
                                <option value="3">3 Estrellas</option>
                            </select>
                            <br /><br />
                            Precio de la Estancia
                            <select name="precio">
                                <option value="">Indiferente</option>                                
                                <option value="1000">Menos de 1000€</option>
                                <option value="2000">Menos de 2000€</option>
                                <option value="3000">Menos de 3000€</option>

                            </select>
                            <br /><br />
                            Tipo de Turismo
                            <select name="tipo">
                                <option value="">Indiferente</option>                                
                                <option>Cultural</option>
                                <option>Naturaleza</option>
                                <option>Sol y Playa</option>
                            </select>    
                        </p>
                        <hr id="linea">
                        <p><input type="submit" value="Enviar Selección"></p>
                        <hr id="linea">
                    </form>      
                </div>
            </div>
        </body>
</html>
