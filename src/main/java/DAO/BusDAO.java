package DAO;

import db.ConexionDB;
import modelos.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusDAO {

    /**
     * Metodo para insertar Bus en la base de datos
     * @param bus Atributo para obtener los datos
     * @param con Establezco el parámetro de la conexión y así no tiene que estar en el metodo
     * @return
     */
    public boolean insertarBus(Bus bus, Connection con) {
        String sqlinsertarBus = "INSERT INTO Bus (register, type, license) VALUES (?, ?, ?)";

       try (PreparedStatement ps = con.prepareStatement(sqlinsertarBus)){//Preparar para hacer la conexión de la consulta

           ps.setString(1,bus.getRegistro());
           ps.setString(2,bus.getTipo());
           ps.setString(3,bus.getLicencia());

           return ps.executeUpdate() > 0;
       }catch (SQLException e){
           e.printStackTrace();
           return false;
       }
    }
}
