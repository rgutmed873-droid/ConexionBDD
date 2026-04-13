/**
 * El paquete modelos guarda las diferentes tablas que tiene la base de datos con sus datos
 */
package modelos;

/**
 * Clase creada para la tabla lugar de la base de datos
 */
public class Lugar {

    //ATRIBUTOS PRINCIPALES
    public int idLugar;
    public String ciudad;
    public String sitio;
    public int cp;

    /**
     * Constructor vacío para añadir nuevos atritubos
     */
    public Lugar (){

    }

    /**
     * Constructor de los atributos de la tabla Lugar
     * @param idLugar Clave primaria de la tabla que da identidad a los lugares por un código numérico
     * @param ciudad Dato de la tabla de la base de datos tipo string para la ciudad
     * @param sitio Dato de la tabla de la base de datos tipo string para el sitio
     * @param cp Dato de la tabla de la base de datos tipo int para el cp de cada ciudad
     */
    public Lugar(int idLugar, String ciudad, String sitio, int cp) {
        this.idLugar = idLugar;
        this.ciudad = ciudad;
        this.sitio = sitio;
        this.cp = cp;
    }

    //GETTERS AND SETTERS
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "idLugar=" + idLugar +
                ", ciudad='" + ciudad + '\'' +
                ", sitio='" + sitio + '\'' +
                ", cp=" + cp +
                '}';
    }
}
