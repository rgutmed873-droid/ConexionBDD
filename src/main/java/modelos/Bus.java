/**
 * El paquete modelos guarda las diferentes tablas que tiene la base de datos con sus datos
 */
package modelos;

/**
 * Clase creada para la tabla de datos de bus
 */
public class Bus {

    //Atributos principales
    public String registro;
    public String tipo;
    public String licencia;

    public Bus (){

    }

    /**
     * Constructor de los atributos de la tabla bus
     * @param registro Clave primaria que muestra el número de bus
     * @param tipo Dato de la tabla que muestra el tipo de bus que es
     * @param licencia Dato de la tabla que muestra el tipo de licencia para circular
     */
    public Bus(String registro, String tipo, String licencia) {
        this.registro = registro;
        this.tipo = tipo;
        this.licencia = licencia;
    }

    //GETTERS AND SETTERS
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }


    @Override
    public String toString() {
        return "Bus{" +
                "registro='" + registro + '\'' +
                ", tipo='" + tipo + '\'' +
                ", licencia='" + licencia + '\'' +
                '}';
    }
}
