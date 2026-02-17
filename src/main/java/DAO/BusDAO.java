package DAO;

import db.ConexionDB;
import modelos.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusDAO {

    /**
     * Metodo para insertar Bus en la base de datos
     * @param bus Atributo para obtener los datos del modelo Bus
     * @param con Establezco el parámetro de la conexión y así no tiene que estar en el metodo
     * @return
     */
    public boolean insertarBus(Bus bus, Connection con) {
        String sqlinsertarBus = "INSERT INTO Bus (register, type, license) VALUES (?, ?, ?)";

       //Preparar para hacer la conexión de la consulta
       try (PreparedStatement ps = con.prepareStatement(sqlinsertarBus)){

           //Setear los datos para la consulta
           ps.setString(1,bus.getRegistro());
           ps.setString(2,bus.getTipo());
           ps.setString(3,bus.getLicencia());

           // Devuelve un entero y como es mayor que 0 se actualiza la tabla del bus
           return ps.executeUpdate() > 0;
       }catch (SQLException e){
           e.printStackTrace();
           return false;
       }
    }
    public static Bus findBus(Connection con, String registro) {

        // Sentencia SQL parametrizada para buscar un bus por su registro
        String sql = "SELECT * FROM Bus WHERE registro = ?;";


        // Prepara la sentencia SQL
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, registro);


            // Ejecuta la consulta y obtiene el resultado
            try (ResultSet rs = ps.executeQuery()) {


                // Si se encuentra un registro, crea y devuelve el objeto Bus
                if (rs.next()) {
                    String registroBus = rs.getString("registro");
                    String tipo = rs.getString("tipo");
                    String licencia = rs.getString("licencia");
                    return new Bus(registroBus, tipo, licencia);
                }
            }
        } catch (SQLException e) {
            // Imprime información de error si ocurre una excepción SQL
            e.printStackTrace();
        }
        // Devuelve null si no se encontró el bus o hubo algún error
        return null;
    }

    public static ArrayList<Bus> consultBus(Connection con) throws SQLException {

        String sqlConsultaBus = "SELECT  * FROM Bus";
        ArrayList<Bus> buses = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sqlConsultaBus)){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Bus busConsult = new Bus();

                busConsult.setRegistro(rs.getString("registro"));
                busConsult.setTipo(rs.getString("tipo"));
                busConsult.setLicencia(rs.getString("licencia"));

                buses.add(busConsult);
            }
            return buses;

        } catch (SQLException e) {
            System.out.println("Error en la consulta de BBDD");
            throw new RuntimeException(e);
        }

    }
}
