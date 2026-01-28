package dao;

import db.ConexionDB;
import modelos.Conductor;

import java.sql.*;

public class DriverDAO {


    public Conductor consultarConductor(int numConductor) {

        String sql = "select nombre, apellido from CONDUCTOR WHERE numConductor = ?";

        try (Connection con = ConexionDB.getConexion()){

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,numConductor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Conductor c = new Conductor();

                c.setNombre(rs.getString("nombre"));
                c.setNombre(rs.getString("apellido"));
                return c;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
