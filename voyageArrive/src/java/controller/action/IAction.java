package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface que impone un único método para localizar las acciones 
 * y redireccionar a la página adecuada.
 * 
 * @author Fernando Martínez de Azagra Detraux
 */
public interface IAction {
    public String execute(
            HttpServletRequest request, 
            HttpServletResponse response);
}
