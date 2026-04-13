/**
 * El paquete modelos guarda las diferentes tablas que tiene la base de datos con sus datos
 */
package modelos;

/**
 * Clase creada para la tabla conductor de la base de datos
 */
public class Conductor {

    //ATRIBUTOS PRINCIPALES
    public String nombre;
    public String apellidos;
    public int numeroConductor;

    /**
     * Constructor vacío para añadir nuevos atributos
     */
    public Conductor (){

    }

    /**
     * Constructor de los atributos de la tabla de Condcutor
     * @param nombre Nombre del conductor
     * @param apellidos Apellidos del conductor
     * @param numeroConductor Clave primera de la tabla que da identidad a cada conductor
     */
    public Conductor(String nombre, String apellidos, int numeroConductor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroConductor = numeroConductor;
    }

    //GETTERS AND SETTERS
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
