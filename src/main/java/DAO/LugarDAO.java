package DAO;

import db.ConexionDB;
import modelos.Lugar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LugarDAO {

    public static Lugar consultarLugar(Connection con, int idLugar) {
        // Sentencia SQL parametrizada para buscar un bus por su registro
        String sql = "SELECT * FROM Lugar WHERE registro = ?;";


        // Prepara la sentencia SQL
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLugar);


            // Ejecuta la consulta y obtiene el resultado
            try (ResultSet rs = ps.executeQuery()) {


                // Si se encuentra un registro, crea y devuelve el objeto Bus
                if (rs.next()) {
                    int registroBus = rs.getInt(idLugar);
                    String tipo = rs.getString("tipo");
                    String licencia = rs.getString("licencia");
                    return new Lugar(registroBus, tipo, licencia);
                }
            }
        } catch (SQLException e) {
            // Imprime información de error si ocurre una excepción SQL
            e.printStackTrace();
        }
        // Devuelve null si no se encontró el bus o hubo algún error
        return null;
    }

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
