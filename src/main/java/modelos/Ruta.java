package modelos;

public class Ruta {

    public String registro;
    public int numConductor;
    public int idLugar;
    public String diaDeLaSemana;

    public Ruta(){

    }

    public Ruta(String registro, int numConductor, int idLugar, String diaDeLaSemana) {
        this.registro = registro;
        this.numConductor = numConductor;
        this.idLugar = idLugar;
        this.diaDeLaSemana = diaDeLaSemana;
    }

    public int getNumConductor() {
        return numConductor;
    }

    public void setNumConductor(int numConductor) {
        this.numConductor = numConductor;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getDiaDeLaSemana() {
        return diaDeLaSemana;
    }

    public void setDiaDeLaSemana(String diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "registro='" + registro + '\'' +
                ", numConductor=" + numConductor +
                ", idLugar=" + idLugar +
                ", diaDeLaSemana='" + diaDeLaSemana + '\'' +
                '}';
    }

}
