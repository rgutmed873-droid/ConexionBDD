package DAO;

import db.ConexionDB;
import modelos.Conductor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RutaDAO {


    /**
     * Metodo para insertar la ruta en la tabla BDP que es la ruta
     * @param registro Variable de Bus clave principal de la tabla Bus
     * @param numeroConductor Variable de Conductor clave principal de la tabla Conductor
     * @param idLugar Variable de Lugar clave principal de la tabla Lugar
     * @param diaSemana Variable String para el los días de la semana de las rutas
     * @param con Establezco el parámetro de la conexión y así no tiene que estar en el metodo
     * @return
     * @throws SQLException
     */

    public boolean insertRuta(String registro, int numeroConductor, int idLugar, String diaSemana, Connection con) throws SQLException{
    String sqlInsertarRuta = "INSERT INTO BDP (registro,numeroCoductor, idLugar, diaSemana) VALUE (?,?,?,?)";


        try (PreparedStatement ps = con.prepareStatement(sqlInsertarRuta)) {

                ps.setString(1, registro);
                ps.setInt(2, numeroConductor);
                ps.setInt(3, idLugar);
                ps.setString(4, diaSemana);

                return ps.executeUpdate() > 0;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Metodo para actualizar días de la semana
     * @param registro Variable de Bus clave principal de la tabla Bus
     * @param numeroConductor Variable de Conductor clave principal de la tabla Conductor
     * @param idLugar Variable de Lugar clave principal de la tabla Lugar
     * @param nuevoDia Variable String para añadir nuevo día para su actualizacion
     * @return
     * @throws SQLException
     */

    public boolean actualizarDiaRuta(String registro, int numeroConductor, int idLugar, String nuevoDia, Connection con) throws SQLException {

        String sqlActualizarDia = "UPDATE BDP SET diaSemana = ? WHERE registro = ?";

        try(PreparedStatement ps = con.prepareStatement(sqlActualizarDia)) {

            ps.setString(1,nuevoDia);
            ps.setString(2,registro);
            ps.setInt(3, numeroConductor);
            ps.setInt(4, idLugar);

            return ps.executeUpdate() > 0;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para eliminar una ruta
     * @param numeroConductor Variable de Conductor clave principal de la tabla Conductor
     * @param idLugar Variable de Lugar clave principal de la tabla Lugar
     * @param registro Variable de Bus clave principal de la tabla Bus
     * @param con Establezco el parámetro de la conexión y así no tiene que estar en el metodo
     * @return
     */

    public boolean eliminarRuta(int numeroConductor, int idLugar, String registro, Connection con){
        String sqlEliminarRuta = "DELETE FROM BDP WHERE registro = ?";

        try (PreparedStatement ps = con.prepareStatement(sqlEliminarRuta)){

            ps.setInt(1,numeroConductor);
            ps.setInt(2,idLugar);
            ps.setString(3,registro);

            return ps.executeUpdate() > 0;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para consultar día de ruta por ciudad
     * @param ciudad Variable String que paso para consultar el día de la ruta que le corresponde a la ciudad
     * @param con Establezco el parámetro de la conexión y así no tiene que estar en el metodo
     * @return
     * @throws SQLException
     */
    public String consultaDiaCiudad(String ciudad, Connection con) throws SQLException {

        String sqlConsultarRuta = "SELECT diaSemana from BDP b JOIN place p ON b.idLugar = p.idLugar Where p.city = ? Limit 1";

        try (PreparedStatement ps = con.prepareStatement(sqlConsultarRuta);){


            ps.setString(1,ciudad);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString("diaSemana");

            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Metodo para consultar conductores por bus
     * @param registro Variable que paso en la consulta del número del bus para consultar los conductores
     * @param con Establezco el parámetro de la conexión y así no tiene que estar en el metodo
     * @return
     * @throws SQLException
     */
    public List<Conductor> consultarConductorBus(String registro, Connection con) throws SQLException {
        List<Conductor> conductores = new ArrayList<>();

        String sqlConsultaConductorBus = "SELECT d.numeroConductor, d.nombre, d.apellido, FROM Conductor d JOIN BDP ON d.numeroConductor = b.numeroConductor = b.numeroConductor WHERE b.registro = ?";
        try (PreparedStatement ps = con.prepareStatement(sqlConsultaConductorBus)){

            ps.setString(1,registro);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Conductor c = new Conductor();
                c.setNumeroConductor(rs.getInt("numeroConductor"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellido"));
                conductores.add(c);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return conductores;
    }
}
