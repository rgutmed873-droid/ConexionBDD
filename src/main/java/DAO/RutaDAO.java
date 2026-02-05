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


    //Metodo para insertar la ruta (registro en BDP)
    public boolean insertRuta(String registro, int numeroConductor, int idLugar, String diaSemana) throws SQLException{
    String sqlInsertarRuta = "INSERT INTO BDP (registro,numeroCoductor, idLugar, diaSemana) VALUE (?,?,?,?)";

        try (Connection con = ConexionDB.getConexion()) {
            try (PreparedStatement ps = con.prepareStatement(sqlInsertarRuta)) {

                ps.setString(1, registro);
                ps.setInt(2, numeroConductor);
                ps.setInt(3, idLugar);
                ps.setString(4, diaSemana);

                return ps.executeUpdate() > 0;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //Metodo para actualizar dias de la semana
    public boolean actualizarDiaRuta(String registro, int numeroConductor, int idLugar, String nuevoDia) throws SQLException {

        String sqlActualizarDia = "UPDATE BDP SET diaSemana = ? WHERE registro = ?";

        try(Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement(sqlActualizarDia)) {

            ps.setString(1,nuevoDia);
            ps.setString(2,registro);
            ps.setInt(3, numeroConductor);
            ps.setInt(4, idLugar);

            return ps.executeUpdate() > 0;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //Metodo para borrar rutas
    public boolean eliminarRuta(int numeroConductor, int idLugar, String registro){
        String sqlEliminarRuta = "DELETE FROM BDP WHERE registro = ?";

        try (Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement(sqlEliminarRuta)){

            ps.setInt(1,numeroConductor);
            ps.setInt(2,idLugar);
            ps.setString(3,registro);

            return ps.executeUpdate() > 0;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String consultaDiaCiudad(String ciudad) throws SQLException {

        String sqlConsultarRuta = "SELECT diaSemana from BDP b JOIN place p ON b.idLugar = p.idLugar Where p.city = ? Limit 1";

        try (Connection con = ConexionDB.getConexion()){
            PreparedStatement ps = con.prepareStatement(sqlConsultarRuta);

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

    public List<Conductor> consultarConductorBus(String registro) throws SQLException {
        List<Conductor> conductores = new ArrayList<>();
        String sqlConsultaConductorBus = "SELECT d.numeroConductor, d.nombre, d.apellido, FROM Conductor d JOIN BDP ON d.numeroConductor = b.numeroConductor = b.numeroConductor WHERE b.registro = ?";
        try (Connection con = ConexionDB.getConexion()){
            PreparedStatement ps = con.prepareStatement(sqlConsultaConductorBus);

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
