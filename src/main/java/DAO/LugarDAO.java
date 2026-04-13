/**
 * Paquete Lugar DAO donde se encuentra las diferentes clases para obtener los datos de la base de datos de la tabla lugar
 * Con estos metodos se puede realizar cualquier operación para la tabla lugar
 */
package DAO;

import modelos.Lugar;

import java.sql.*;
import java.util.ArrayList;
/**
 * Clase Lugar DAO donde se ejecutan los metodos creados para
 */
public class LugarDAO {

    /**
     * Metodo para INSERTAR LUGAR
     * @param lugar
     * @param con
     * @return
     * @throws SQLException
     */
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

    /**
     * Metodo para ENCONTRAR LOS LUGARES
     * @param con
     * @return
     * @throws SQLException
     */
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

    /**
     * Metodo para ENCONTRAR UN LUGAR
     * @param idLugar
     * @param con
     * @return
     * @throws SQLException
     */
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

    /**
     * Metodo para ACTUALIZAR UN LUGAR
     * @param idLugar
     * @param ciudad
     * @param sitio
     * @param cp
     * @param con
     * @return
     * @throws SQLException
     */
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

    /**
     * Metodo para BORRAR UN LUGAR
     * @param idLugar
     * @param con
     * @return
     * @throws SQLException
     */
    public boolean deleteLugar(int idLugar, Connection con) throws SQLException {
        String sql = "DELETE FROM Lugar WHERE idLugar = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);
            return ps.executeUpdate() > 0;
        }
    }
}