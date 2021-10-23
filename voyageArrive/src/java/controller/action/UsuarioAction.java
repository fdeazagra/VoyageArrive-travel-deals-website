package controller.action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.UserDAO;
import model.Usuario;

/**
 * Clase con las acciones para operar con la entidad Usuario.
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class UsuarioAction implements IAction{
    
    /**
     * Recoge la acción a realizar y redirecciona a la página adecuada.
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

            case "LOGIN":
                pagDestino = login(request, response);
                break;
            
            case "NEW":
                pagDestino = signUp(request, response);
                break;
            
            case "ADD":
                pagDestino = add(request, response);
                break; 
                
            case "GUEST":
                pagDestino = access(request, response);
                break;    
        }
        return pagDestino;
    }
    /**
     * Recoge los datos introducidos en el login de usuario
     * y comprueba si están registrados en la BBDD.
     * 
     * @param request
     * @param response
     * @return Página de retorno.
     */
    private String login(HttpServletRequest request, 
                            HttpServletResponse response){
        
            String email = request.getParameter("EMAIL");
            String pass = request.getParameter("PASS");
            String pagDestino;
            
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setPassword(pass);
            
            UserDAO usuarioDAO = new UserDAO();
            ArrayList<Usuario> loginUsuario = usuarioDAO.
                            findAll(usuario);
            
            if(loginUsuario.size()>0){
                
                pagDestino = "/Bienvenida.jsp";
                
            }else{
                
                pagDestino = "/ErrorUsuario.jsp";
                
            }
            return pagDestino;
    }
    
    /**
     * Realiza el alta en la BBDD de un nuevo usuario.
     * 
     * @param request
     * @param response
     * @return Página de retorno. 
     */
    private String add(HttpServletRequest request, 
                            HttpServletResponse response){
        
            String email = request.getParameter("EMAIL");
            String pass = request.getParameter("PASS");
            String pass2 = request.getParameter("PASS2");
            String pagDestino = "";
            
            if (pass.equals(pass2)) {
                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setPassword(pass);
                UserDAO usuarioDAO = new UserDAO();
                usuarioDAO.add(usuario);
                pagDestino = "/Bienvenida.jsp";
                
            }else{
                    pagDestino = "/ErrorUsuario.jsp";
                }
            
            return pagDestino;
    }
    
     /**
     * Redirecciona a la página de recogida de datos para dar
     * el alta en la BBDD a un nuevo usuario.
     * 
     * @param request
     * @param response
     * @return Página de retorno. 
     */
    private String signUp(HttpServletRequest request, 
                            HttpServletResponse response){
        
         String pagDestino = "/AltaUsuario.jsp";
         
         return pagDestino;
    }
    
    /**
     * Da acceso a la página de bienvenida a un usuario con rol de invitado.
     * 
     * @param request
     * @param response
     * @return Página de retorno. 
     */
    private String access(HttpServletRequest request, 
                            HttpServletResponse response){    
      
        request.getParameter("EMAIL");
        String pagDestino = "/Bienvenida.jsp";
         
         return pagDestino;
    }
    

}
