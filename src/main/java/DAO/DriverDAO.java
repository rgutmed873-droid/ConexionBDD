package DAO;

import db.ConexionDB;
import modelos.Conductor;

import java.sql.*;

public class DriverDAO {

    //Metodo para consultar los conductores
    public Conductor consultarConductor(int numConductor) throws SQLException {

        String sqlConsultaConductor = "select nombre, apellido from CONDUCTOR WHERE numConductor = ?";


        try (Connection con = ConexionDB.getConexion()){

            PreparedStatement ps = con.prepareStatement(sqlConsultaConductor);

            ps.setInt(1,numConductor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Conductor c = new Conductor();

                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellido"));
                return c;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insertarConductor(Conductor conductor) throws SQLException {
        String sqlInsertarConductor = "INSERT INTO CONDUCTOR (nombre, apellido, numeroConductor) VALUES (?, ?,?)";

        try (Connection con = ConexionDB.getConexion()){
            PreparedStatement ps = con.prepareStatement(sqlInsertarConductor);

            ps.setString(1, conductor.getNombre());
            ps.setString(2,conductor.getApellidos());
            ps.setInt(3, conductor.getNumeroConductor());

            return ps.executeUpdate() > 0;
        }

    }
}
