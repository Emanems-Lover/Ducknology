/**
 *
 * @author pato_coder 01:11 30/06/25
 */
public class Empleado extends Usuario{
    //atributos
    private double salario;
    private String Puesto;
    private String horario;
    
    //constructor
    public Empleado(double salario, String Puesto, String horario, String nombre, String correo, String contraseña, String direccion) {
        super(nombre, correo, contraseña, direccion);
        this.salario = salario;
        this.Puesto = Puesto;
        this.horario = horario;
    }
    
    //gets y sets
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
}
