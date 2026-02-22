package DAO;

import modelos.Ruta;

import java.sql.*;
import java.util.ArrayList;

public class RutaDAO {

    public boolean insertRuta(Ruta ruta, Connection con) throws SQLException {
        String sql = "INSERT INTO Ruta (idRuta, registroBus, dniConductor, idLugar) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ruta.getIdLugar());
            ps.setString(2, ruta.getRegistro());
            ps.setInt(3, ruta.getNumeroConductor());
            ps.setInt(4, ruta.getIdLugar());

            return ps.executeUpdate() > 0;
        }
    }

    public ArrayList<Ruta> findAllRuta(Connection con) throws SQLException {
        String sql = "SELECT * FROM Ruta";
        ArrayList<Ruta> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Ruta r = new Ruta();
                r.setIdLugar(rs.getInt("idRuta"));
                r.setRegistro(rs.getString("registroBus"));
                r.setNumeroConductor(rs.getInt("dniConductor"));
                r.setIdLugar(rs.getInt("idLugar"));
                lista.add(r);
            }
        }
        return lista;
    }

    public Ruta findRuta(int idRuta, Connection con) throws SQLException {
        String sql = "SELECT * FROM Ruta WHERE idRuta = ?";
        Ruta r = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRuta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Ruta();
                r.setIdLugar(rs.getInt("idRuta"));
                r.setRegistro(rs.getString("registroBus"));
                r.setNumeroConductor(rs.getInt("dniConductor"));
                r.setIdLugar(rs.getInt("idLugar"));
            }
        }
        return r;
    }

    public boolean updateRuta(int idRuta, String registroBus, int dniConductor, int idLugar, Connection con) throws SQLException {
        String sql = "UPDATE Ruta SET registroBus = ?, dniConductor = ?, idLugar = ? WHERE idRuta = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, registroBus);
            ps.setInt(2, dniConductor);
            ps.setInt(3, idLugar);
            ps.setInt(4, idRuta);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteRuta(int idRuta, Connection con) throws SQLException {
        String sql = "DELETE FROM Ruta WHERE idRuta = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRuta);
            return ps.executeUpdate() > 0;
        }
    }
}