package modelos;

public class Bus {

    public String registro;
    public String tipo;
    public String licencia;

    public Bus (){

    }

    public Bus(String registro, String tipo, String licencia) {
        this.registro = registro;
        this.tipo = tipo;
        this.licencia = licencia;
    }

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
