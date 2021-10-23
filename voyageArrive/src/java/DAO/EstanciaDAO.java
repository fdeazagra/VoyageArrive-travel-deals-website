package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Estancia;
import utils.MotorSQL;

/**
 * Clase con las consultas a la BBDD de la entidad Estancia.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class EstanciaDAO {
    
    private static final String SQL_FIND_ALL
            = "SELECT  *  FROM estancia WHERE 1=1 ";
    
    private MotorSQL motorSql;
    
    /**
     * Constructor que instancia un objeto de la clase MotorSQL
     * con los métodos de conexión a la BBDD.
     */
    public EstanciaDAO() {
        this.motorSql = new MotorSQL();
    }
    /**
     * Busca en la BBDD todas las ofertas disponibles
     * y las devuelve ordenadas por fecha.
     * 
     * @param bean Estancia.
     * @return El listado de todas las ofertas.
     */    
    public ArrayList<Estancia> findAll(Estancia bean) {
        
        ArrayList<Estancia> lstEstancias = new ArrayList<>();
        try {
            this.motorSql.connect();
            String sqlCabecera = SQL_FIND_ALL;
            String sqlCuerpo = "";
            String sqlOrden = " ORDER BY fin_oferta";
            
            if (bean!=null) {
                if (bean.getId()>0) {
                    sqlCuerpo = " AND id="+bean.getId();
                }
                if (bean.getDestino()!=null && !bean.getDestino().equals("")) {
                    sqlCuerpo += " AND destino='"+bean.getDestino()+"'";
                }
                if (bean.getPais()!=null && !bean.getPais().equals("")) {
                    sqlCuerpo += " AND pais='"+bean.getPais()+"'";
                }
                if (bean.getTipo_viaje()!=null && !bean.getTipo_viaje().equals("")) {
                    sqlCuerpo += " AND tipo_viaje='"+bean.getTipo_viaje()+"'";
                }
                if (bean.getCategoria_hotel()!=null && 
                        !bean.getCategoria_hotel().equals("")) { 
                    sqlCuerpo += " AND categoria_hotel='"+bean.getCategoria_hotel()+"'";
                }
                if (Integer.parseInt(bean.getPrecio())>0) {
                    sqlCuerpo += " AND precio='"+bean.getPrecio()+"'";
                }
                if (bean.getFinOferta()!=null && !bean.getFinOferta().equals("")) {
                    sqlCuerpo += " AND fin_oferta='"+bean.getFinOferta()+"'";
                }

            }

            String sqlFinal = sqlCabecera + sqlCuerpo + sqlOrden;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) {                
                Estancia estancia = new Estancia();
                estancia.setId(rs.getInt(1));
                estancia.setDestino(rs.getString(2));
                estancia.setPais(rs.getString(3));
                estancia.setTipo_viaje(rs.getString(4));
                estancia.setCategoria_hotel(rs.getString(5));
                estancia.setPrecio(rs.getString(6));
                estancia.setFinOferta(rs.getString(7));
                lstEstancias.add(estancia);
            }


        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        finally{
             this.motorSql.disconnect();
        }

        return lstEstancias;
    }
    
    /**
     * Busca en la BBDD las ofertas con el filtro elegido en pantalla.
     * 
     * @param bean Estancia.
     * @param destino El destino marcado en el radio button.
     * @return Las ofertas que pasan el filtro del destino.
     */
    public ArrayList<Estancia> filtro(Estancia bean, String destino, 
            String hotel, String precio, String tipo) {
        
        ArrayList<Estancia> lstEstancias = new ArrayList<>();
        try {
            this.motorSql.connect();
            String sqlCabecera = SQL_FIND_ALL;
            String sqlCuerpo = "";
            String sqlFiltro = "";
            
            if (destino!=null && !destino.equals("")) {
                sqlFiltro += " AND destino='"+destino+"'";
            }
            
            if (hotel!=null && !hotel.equals("")) {
                sqlFiltro += " AND categoria_hotel='"+hotel+"'";
            }
            
            if (precio!=null && !precio.equals("")) {
                sqlFiltro += " AND precio<'"+precio+"'";
            }
            
            if (tipo!=null && !tipo.equals("")) {
                sqlFiltro += " AND tipo_viaje='"+tipo+"'";
            }
            
            if (bean!=null) {
                if (bean.getId()>0) {
                    sqlCuerpo = " AND id="+bean.getId();
                }
                if (bean.getDestino()!=null && !bean.getDestino().equals("")) {
                    sqlCuerpo += " AND destino='"+bean.getDestino()+"'";
                }
                if (bean.getPais()!=null && !bean.getPais().equals("")) {
                    sqlCuerpo += " AND pais='"+bean.getPais()+"'";
                }
                if (bean.getTipo_viaje()!=null && !bean.getTipo_viaje().equals("")) {
                    sqlCuerpo += " AND tipo_viaje='"+bean.getTipo_viaje()+"'";
                }
                if (bean.getCategoria_hotel()!=null && 
                        !bean.getCategoria_hotel().equals("")) { 
                    sqlCuerpo += " AND categoria_hotel='"+bean.getCategoria_hotel()+"'";
                }
                if (Integer.parseInt(bean.getPrecio())>0) {
                    sqlCuerpo += " AND precio='"+bean.getPrecio()+"'";
                }
                if (bean.getFinOferta()!=null && !bean.getFinOferta().equals("")) {
                    sqlCuerpo += " AND fin_oferta='"+bean.getFinOferta()+"'";
                }

            }

            String sqlFinal = sqlCabecera + sqlCuerpo + sqlFiltro;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) {                
                Estancia estancia = new Estancia();
                estancia.setId(rs.getInt(1));
                estancia.setDestino(rs.getString(2));
                estancia.setPais(rs.getString(3));
                estancia.setTipo_viaje(rs.getString(4));
                estancia.setCategoria_hotel(rs.getString(5));
                estancia.setPrecio(rs.getString(6));
                estancia.setFinOferta(rs.getString(7));
                lstEstancias.add(estancia);
            }

        } catch (Exception ex) {
            
        }
        finally{
             this.motorSql.disconnect();
        }

        return lstEstancias;
    }

}
