/**
 * Paquete BUS DAO donde se encuentra las diferentes clases para obtener los datos de la base de datos de la tabla bus
 * Con estos metodos se puede realizar cualquier operación para la tabla bus
 */
package DAO;

import modelos.Bus;

import java.sql.*;
import java.util.ArrayList;

/**
 * Clase Bus DAO donde se ejecutan los metodos creados para
 */
public class BusDAO {

    /**
     * INSERTAR BUS en este metodo se añade un bus a la base de datos cuando se lanza desde la aplicación
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
     * CONSULTAR TODOS LOS BUSES que hay en la base de datos desde la aplicación
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
     * CONSULTAR BUS POR REGISTRO en el que se le solicita al usuario el número del bus que tiene
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
     * ACTUALIZAR BUS en este metodo lo que se hace es cambiar datos de la tabla de bus através de la aplicación
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
     * ELIMINAR BUS en este metodo eliminamos el registro de un bus en la base de datos
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