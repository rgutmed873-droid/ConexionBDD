/**
 * El paquete modelos guarda las diferentes tablas que tiene la base de datos con sus datos
 */
package modelos;

/**
 * Clase creada para Ruta de la base de datos
 */
public class Ruta {

    //ATRIBUTOS PRINCIPALES
    private String registro;
    private int numeroConductor;
    private int idLugar;
    private String diaSemana;

    /**
     * Constructor vacío para añadir nuevos atributos
     */
    public Ruta(){

    }

    /**
     * Constructor de los atributos de la tabla Ruta
     * @param diaSemana Dato de la base de datos que tiene tipo string
     * @param idLugar Dato clave foranea y primaria de la tabla lugar
     * @param registro Dato clave foranea y primaria de la tabla bus
     * @param numeroConductor Dato clave foranea y primaria de la tabla conductor
     */
    public Ruta(String diaSemana, int idLugar, String registro, int numeroConductor) {
        this.diaSemana = diaSemana;
        this.idLugar = idLugar;
        this.registro = registro;
        this.numeroConductor = numeroConductor;
    }

    //GETTERS AND SETTERS
    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public int getNumeroConductor() {
        return numeroConductor;
    }

    public void setNumeroConductor(int numeroConductor) {
        this.numeroConductor = numeroConductor;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "diaSemana='" + diaSemana + '\'' +
                ", registro='" + registro + '\'' +
                ", numeroConductor=" + numeroConductor +
                ", idLugar=" + idLugar +
                '}';
    }
}
