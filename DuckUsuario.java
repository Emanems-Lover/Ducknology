/**
 *
 * @author pato_coder 11:33 am 30/06/25
 */
public class Usuario {
    
    //atributos
    private String nombre;
    private String correo;
    private String contraseña;
    private String direccion;
   
    
    //constructor
    public Usuario(String nombre, String correo, String contraseña, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.direccion = direccion;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseño) {
        this.contraseña = contraseña;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
    
    
}
