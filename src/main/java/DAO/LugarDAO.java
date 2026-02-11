package DAO;

import db.ConexionDB;
import modelos.Lugar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LugarDAO {

    /**
     * Metodo para insertar un nuevo Lugar en la tabla place
     * @param lugar Atributo para obtener los datos del modelo Lugar
     * @return
     * @throws SQLException
     */
    public boolean insertarLugar(Lugar lugar) throws SQLException {

        String sqlInsertarLugar = "INSERT INTO LUGAR (idlugar,ciudad,sitio,cp) VALUES (?,?,?,?)";

        try (Connection con = ConexionDB.getConexion()){
            PreparedStatement ps = con.prepareStatement(sqlInsertarLugar);

            ps.setInt(1, lugar.idLugar);
            ps.setString(2, lugar.ciudad);
            ps.setString(3, lugar.sitio);
            ps.setInt(4, lugar.cp);

            return ps.executeUpdate() > 0;
        }
    }
}
