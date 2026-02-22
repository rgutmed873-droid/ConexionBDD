package DAO;

import modelos.Bus;

import java.sql.*;
import java.util.ArrayList;

public class BusDAO {

    /**
     * INSERTAR BUS
     */
    public boolean insertBus(Bus bus, Connection con) throws SQLException {

        String sql = "INSERT INTO Bus (registro, tipo, licencia) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bus.getRegistro());
            ps.setString(2, bus.getTipo());
            ps.setString(3, bus.getLicencia());

            int filas = ps.executeUpdate();
            return filas > 0;

        }
    }

    /**
     * CONSULTAR TODOS LOS BUSES
     */
    public ArrayList<Bus> consultBus(Connection con) throws SQLException {

        String sql = "SELECT * FROM Bus";
        ArrayList<Bus> lista = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Bus bus = new Bus();
                bus.setRegistro(rs.getString("registro"));
                bus.setTipo(rs.getString("tipo"));
                bus.setLicencia(rs.getString("licencia"));

                lista.add(bus);
            }
        }

        return lista;
    }

    /**
     * CONSULTAR BUS POR REGISTRO
     */
    public Bus findBusByRegistro(String registro, Connection con) throws SQLException {

        String sql = "SELECT * FROM Bus WHERE registro = ?";
        Bus bus = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, registro);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    bus = new Bus();
                    bus.setRegistro(rs.getString("registro"));
                    bus.setTipo(rs.getString("tipo"));
                    bus.setLicencia(rs.getString("licencia"));
                }
            }
        }

        return bus;
    }

    /**
     * ACTUALIZAR BUS
     */
    public boolean updateBus(String registro, String tipo, String licencia, Connection con) throws SQLException {

        String sql = "UPDATE Bus SET tipo = ?, licencia = ? WHERE registro = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tipo);
            ps.setString(2, licencia);
            ps.setString(3, registro);

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    /**
     * ELIMINAR BUS
     */
    public boolean deleteBus(String registro, Connection con) throws SQLException {

        String sql = "DELETE FROM Bus WHERE registro = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, registro);

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }
}