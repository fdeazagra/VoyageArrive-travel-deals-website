package controller.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Estancia;
import DAO.EstanciaDAO;

/**
 * Clase con las acciones para operar con la entidad Estancia.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public class EstanciaAction  implements IAction {

    /**
     * Localiza las consultas, redirecciona a sus DAOs
     * y carga la página con los resultados.
     * 
     * @param request
     * @param response
     * @return La página de retorno.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        String pagDestino ="";
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        
        switch(arrayAction[1]){
            case "FIND_ALL":
                pagDestino = findAll(request, response);
                break;

            case "FILTRO":
                String destino = request.getParameter("destino");
                String hotel = request.getParameter("categoria_hotel");
                String precio = request.getParameter("precio");
                String tipo = request.getParameter("tipo");
                pagDestino = filtrar(
                        request, response, destino, hotel, precio, tipo);
                break;    
        }
        return pagDestino;
    }
    
    /**
     * Realiza la consulta de todas las estancias disponibles 
     * ordenadas por fecha de fin de oferta.
     * 
     * @param request
     * @param response
     * @return La página de retorno.
     */
    private String findAll(HttpServletRequest request, 
                            HttpServletResponse response){

            EstanciaDAO estanciaDAO = new EstanciaDAO();
            ArrayList<Estancia> lstEstancias = estanciaDAO.
                            findAll(null);

            request.setAttribute("LISTA_OFERTAS",
                                lstEstancias);

            return "/OfertasFecha.jsp";
    }
    
    /**
     * Realiza la consulta de estancias disponibles
     * aplicando los filtros escogidos por el usuario.
     * 
     * @param request
     * @param response
     * @param destino opción de destino elegida en la lista desplegable.
     * @param hotel opción de categoría de hotel elegida en la lista desplegable.
     * @param precio opción de precio elegida en la lista desplegable.
     * @param tipo opción de tipo de viaje elegida en la lista desplegable.
     * @return La página de retorno.
     */
    private String filtrar(HttpServletRequest request, 
                    HttpServletResponse response, String destino, String hotel,
                    String precio, String tipo){

            EstanciaDAO estanciaDAO = new EstanciaDAO();
            ArrayList<Estancia> lstEstancias = estanciaDAO.
                            filtro(null, destino, hotel, precio, tipo);

            request.setAttribute("FILTRO",
                                lstEstancias);

            return "/Destinos.jsp";
    }
}
