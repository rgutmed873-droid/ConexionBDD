package DAO;

import modelos.Conductor;

import java.sql.*;
import java.util.ArrayList;

public class DriverDAO {

    public boolean insertConductor(Conductor conductor, Connection con) throws SQLException {
        String sql = "INSERT INTO Conductor (Numero Conductor, nombre, telefono) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, conductor.getNumeroConductor());
            ps.setString(2, conductor.getNombre());
            ps.setString(3, conductor.getApellidos());

            return ps.executeUpdate() > 0;
        }
    }

    public ArrayList<Conductor> findAllConductor(Connection con) throws SQLException {
        String sql = "SELECT * FROM Conductor";
        ArrayList<Conductor> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Conductor c = new Conductor();
                c.setNumeroConductor(rs.getInt("NumeroConductor"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("telefono"));
                lista.add(c);
            }
        }
        return lista;
    }

    public Conductor findConductor(int numConductor, Connection con) throws SQLException {
        String sql = "SELECT * FROM Conductor WHERE numeroConductor = ?";
        Conductor c = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, numConductor);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Conductor();
                c.setNumeroConductor(rs.getInt("Numero conductor"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellidos"));
            }
        }
        return c;
    }

    public boolean updateConductor(int numConductor, String nombre, String apellido, Connection con) throws SQLException {
        String sql = "UPDATE Conductor SET nombre = ?, apellido = ? WHERE numeroConductor = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2,apellido );
            ps.setInt(3, numConductor);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteConductor(int numeroConductor, Connection con) throws SQLException {
        String sql = "DELETE FROM Conductor WHERE numeroConductor = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, numeroConductor);
            return ps.executeUpdate() > 0;
        }
    }
}