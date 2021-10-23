package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.MotorSQL;
import model.Usuario;

/**
 * Clase con las consultas a la BBDD de la entidad Usuario.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class UserDAO {

    private static final String SQL_INSERT
            = "INSERT INTO `usuario`(`EMAIL`, `PASS`) VALUES";
    
    private static final String SQL_FIND_ALL
            = "SELECT  *  FROM usuario WHERE 1=1 ";
    
    private MotorSQL motorSql;
    
    /**
     * Constructor que instancia un objeto de la clase MotorSQL
     * con los métodos de conexión a la BBDD.
     */
    public UserDAO() {
        
        this.motorSql = new MotorSQL();
    }
   
    /**
     * Inserta en la BBDD los datos de un nuevo usuario.
     * 
     * @param entidad con los datos recogidos en pantalla.
     * @return INT de control de errores en la operación. 
     */
    public int add(Usuario entidad)  {
        
        this.motorSql.connect();
        
        String sql = SQL_INSERT +
                "('"+entidad.getEmail()+"' , '"+entidad.getPassword()+"')";
                
        int resp = this.motorSql.execute(sql);
        
        this.motorSql.disconnect();
        
        return resp;
    }
    
    /** 
     * Busca si existe un usuario registrado en la BBDD con los 
     * datos recogidos en pantalla.
     * 
     * @param bean con los datos recogidos en pantalla.
     * @return Arraylist con el usuario si lo encuentra registrado en la BBDD
     * y si no lo encuentra, devuelve el Arraylist vacío.
     */
        public ArrayList<Usuario> findAll(Usuario bean) {
            
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        
        try {
            
        this.motorSql.connect();
        
        String sqlCabecera = SQL_FIND_ALL;
        String sqlCuerpo = "";
        
        if (bean!=null) {
            if (bean.getId()>0) {
                sqlCuerpo = " AND ID_USUARIO="+bean.getId();
            }
            if (bean.getEmail()!=null && !bean.getEmail().equals("")) {
                sqlCuerpo = " AND EMAIL='"+bean.getEmail()+"'";
            }
            if (bean.getPassword()!=null && !bean.getPassword().equals("")) {
                sqlCuerpo += " AND PASS='"+bean.getPassword()+"'";
            }
           
        }
       
        String sqlFinal = sqlCabecera + sqlCuerpo;
        ResultSet rs = this.motorSql.executeQuery(sqlFinal);
                
            rs.beforeFirst();
            while (rs.next()) {                
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setEmail(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                lstUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        finally{
            
             this.motorSql.disconnect();
        }

        return lstUsuarios;
    }
    
}
