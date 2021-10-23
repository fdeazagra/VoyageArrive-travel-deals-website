
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 * Clase con la entidad Estancia de la tabla de la BBDD.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class Estancia {

    private Integer id;
    private String destino;
    private String pais;
    private String tipo_viaje;
    private String categoria_hotel;
    private String precio;
    private String finOferta;

    /**
     * Constructor mínimo.
     */
    public Estancia() {
    }

    /**
     * Constructor con el parámetro de la primary key.
     * 
     * @param id. 
     */
    public Estancia(Integer id) {
        this.id = id;
    }

    /**
     * Constructor parametrizado.
     * 
     * @param id Primary key de la estancia.
     * @param destino Continente de la estancia.
     * @param pais País de la estancia.
     * @param tipo_viaje Clasificación del tipo de turismo.
     * @param categoria_hotel Estrellas del hotel.
     * @param precio Precio de la estancia.
     * @param finOferta Fecha en la que termina la oferta.
     */
    public Estancia(Integer id, String destino, String pais, String tipo_viaje,
            String categoria_hotel, String precio, String finOferta) {
        this.id = id;
        this.destino = destino;
        this.pais = pais;
        this.tipo_viaje = tipo_viaje;
        this.categoria_hotel = categoria_hotel;
        this.precio = precio;
        this.finOferta = finOferta;
    }

    /**
     * Getter del número de identificación.
     * 
     * @return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter del número de identificación.
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter del destino de la estancia.
     * 
     * @return Destino de la estancia. 
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Setter del destino de la estancia.
     * 
     * @param destino de la estancia.
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Getter del país de la estancia.
     * 
     * @return país de la estancia.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Setter del país de la estancia.
     * 
     * @param pais de la estancia.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Getter del tipo de viaje de la estancia.
     * 
     * @return tipo de viaje de la estancia.
     */
    public String getTipo_viaje() {
        return tipo_viaje;
    }

    /**
     * Setter del tipo de viaje de la estancia.
     * 
     * @param tipo_viaje de la estancia.
     */
    public void setTipo_viaje(String tipo_viaje) {
        this.tipo_viaje = tipo_viaje;
    }

    
    
    /**
     * Getter de la categoría del hotel.
     * 
     * @return Estrellas que tiene el hotel.
     */
    public String getCategoria_hotel() {
        return categoria_hotel;
    }

    /**
     * Setter de la categoría del hotel.
     * 
     * @param categoria_hotel Estrellas que tiene el hotel.
     */
    public void setCategoria_hotel(String categoria_hotel) {
        this.categoria_hotel = categoria_hotel;
    }

    
    /**
     * Getter del precio de la oferta.
     * 
     * @return Precio de la oferta.
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Setter del precio de la oferta.
     * 
     * @param precio de la oferta.
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Getter de la fecha de fin de oferta.
     * 
     * @return String de la fecha de final de oferta. 
     */
    public String getFinOferta() {
        return finOferta;
    }

    /**
     * Setter de la fecha de fin de oferta.
     * 
     * @param finOferta La fecha de fin de la oferta.
     */
    public void setFinOferta(String finOferta) {
        this.finOferta = finOferta;
    }

    /**
     * Método toString de Estancia.
     * 
     * @return Todos los campos de la entidad concatenados en un String. 
     */
    @Override
    public String toString() {
        return ". DESTINO: " + destino + " · " + pais + " / TIPO: " 
                + tipo_viaje + " · HOTEL " + categoria_hotel + "* " 
                + "/ Precio: " + precio + "€" 
                + " · Fin Oferta: " + finOferta;
    }
    
    public static String toCadena(Estancia estancia) {
        return "ESTANCIA{"
                + "DESTINO: " + estancia.getDestino() + " · "
                + "PAIS: " + estancia.getPais() + " / "
                + "TIPO: " + estancia.getTipo_viaje() + " · "
                + "HOTEL: " + estancia.getCategoria_hotel() + "* / "
                + "PRECIO: " + estancia.getPrecio() + "€ · "
                + "FIN OFERTA: " + estancia.getFinOferta() + "}";
    }
    
    public static String toArrayJSon(ArrayList<Estancia> estancias) {
        
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(estancias);
            
            return resp;
    }
}
