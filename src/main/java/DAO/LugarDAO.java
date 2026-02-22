package DAO;

import modelos.Lugar;

import java.sql.*;
import java.util.ArrayList;

public class LugarDAO {

    public boolean insertLugar(Lugar lugar, Connection con) throws SQLException {
        String sql = "INSERT INTO Lugar (idLugar, Ciudad, sitio, cp) VALUES (?, ?, ?,?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, lugar.getIdLugar());
            ps.setString(2, lugar.getCiudad());
            ps.setString(3, lugar.getSitio());
            ps.setInt(4, lugar.getCp());

            return ps.executeUpdate() > 0;
        }
    }

    public ArrayList<Lugar> findAllLugar(Connection con) throws SQLException {
        String sql = "SELECT * FROM Lugar";
        ArrayList<Lugar> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Lugar l = new Lugar();
                l.setIdLugar(rs.getInt("idLugar"));
                l.setCiudad(rs.getString("ciudad"));
                l.setSitio(rs.getString("sitio"));
                l.setCp(rs.getInt("cp"));
                lista.add(l);
            }
        }
        return lista;
    }

    public Lugar findLugar(int idLugar, Connection con) throws SQLException {
        String sql = "SELECT * FROM Lugar WHERE idLugar = ?";
        Lugar l = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                l = new Lugar();
                l.setIdLugar(rs.getInt("idLugar"));
                l.setCiudad(rs.getString("Ciudad"));
                l.setSitio(rs.getString("Sitio"));
                l.setCp(rs.getInt("Cp"));
            }
        }
        return l;
    }

    public boolean updateLugar(int idLugar, String ciudad, String sitio, int cp,Connection con) throws SQLException {
        String sql = "UPDATE Lugar SET Ciudad = ?, sitio = ?, cp = ? WHERE idLugar = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            ps.setString(2, ciudad);
            ps.setString(3, sitio);
            ps.setInt(4, cp);

            return ps.executeUpdate() > 0;
        }
    }

    public boolean deleteLugar(int idLugar, Connection con) throws SQLException {
        String sql = "DELETE FROM Lugar WHERE idLugar = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            return ps.executeUpdate() > 0;
        }
    }
}