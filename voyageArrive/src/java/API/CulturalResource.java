/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import DAO.EstanciaDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Estancia;

/**
 * REST Web Service con la lista de viajes de tipo Cultural.
 *
 * @author Fernando  Martínez de Azagra Detraux.
 */
@Path("cultural")
public class CulturalResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CulturalResource
     */
    public CulturalResource() {
    }

    /**
     * Retrieves representation of an instance of API.CulturalResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        String destino = "";
        String hotel = "";
        String precio = "";
        String tipo = "Cultural";
        
        EstanciaDAO estanciaDAO = new EstanciaDAO();
            ArrayList<Estancia> lstEstancias = estanciaDAO.
                            filtro(null, destino, hotel, precio, tipo);
            
            return Estancia.toArrayJSon(lstEstancias);
    }

    /**
     * PUT method for updating or creating an instance of CulturalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
