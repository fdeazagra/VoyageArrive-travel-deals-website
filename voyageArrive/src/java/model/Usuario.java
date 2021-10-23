package model;

/**
 * Clase con la entidad Usuario de la tabla de la BBDD
 * 
 * @author Fernando Martínez de Azagra Detraux.
 */
public class Usuario {
    
    private int id;
    private String email;
    private String password;

    /**
     * Constructor mínimo.
     */
    public Usuario() {
    }

    /**
     * Constructor parametrizado.
     * 
     * @param id Número de identificación único Primary key.
     * @param email Email del usuario.
     * @param password Contraseña para acceder.
     */
    public Usuario(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    /**
     * Getter del número de identificación.
     * 
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter del número de identificación.
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter del email.
     * 
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter del email.
     * 
     * @param email. 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter del password.
     * 
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter del password.
     * 
     * @param password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método toString de Usuario.
     * 
     * @return Todos los campos de la entidad concatenados en un String.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", password=" + password + '}';
    }
    
    

}
