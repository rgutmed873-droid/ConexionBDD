package dao;

import db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusDAO {

    public boolean insertarAutobusRta(String registro, int numRuta, String tipo) {

        String sqlBus = "INSERT INTO BUS (registro, tipo) VALUES (?,?)";
        String sqlBDP = "INSERT INTO BDP (registro, numRuta) VALUES (?,?)";

        try (Connection con = ConexionDB.getConexion()) {
            con.setAutoCommit(false);
            try (PreparedStatement psBus = con.prepareStatement(sqlBus);
                 PreparedStatement psBDP = con.prepareStatement(sqlBDP)) {

                //BUS
                psBus.setString(1,registro);
                psBus.setString(2,tipo);
                psBus.executeUpdate();

                psBDP.setString(1,registro);
                psBDP.setInt(2,numRuta);
                psBDP.executeUpdate();

                con.commit();
                return true;
            } catch (Exception e) {

                con.rollback();
                throw new RuntimeException(e);
            } finally {
                con.setAutoCommit(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
