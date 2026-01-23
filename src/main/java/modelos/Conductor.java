package modelos;

public class Conductor {

    public String nombre;
    public String apellidos;
    public int numeroConductor;

    public Conductor (){

    }

    public Conductor(String nombre, String apellidos, int numeroConductor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroConductor = numeroConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumeroConductor() {
        return numeroConductor;
    }

    public void setNumeroConductor(int numeroConductor) {
        this.numeroConductor = numeroConductor;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numeroConductor=" + numeroConductor +
                '}';
    }
}
