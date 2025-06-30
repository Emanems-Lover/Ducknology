/**
 *
 * @author pato_coder 11:40 30/06/25
 */
public class Cliente extends Usuario{
    
    //atributos
    public static List<Cliente>Carrito=new ArrayList<>();
    //public static List<Cliente>historialCompras=new ArrayList<>();

    public Cliente(String nombre, String correo, String contraseña, String direccion) {
        super(nombre, correo, contraseña, direccion);
    }
    
    public void agregarCarrito(Producto carro){
        
        Carrito.add(carro);
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente:").append(getNombre())
                .append("correo :").append(getCorreo())
                .append("contraseña :").append(getContraseña())
                .append("direccion :").append(getDireccion());
        return sb.toString();
    }
    
}
