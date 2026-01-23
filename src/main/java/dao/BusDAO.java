package dao;

import db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BusDAO {

    public boolean insertarAutobusRta(int numBus, int numRuta){

        try(Connection con = ConexionDB.getConexion()){

            con.setAutoCommit(false);

            String sql = "INSERT INTO BUS VALUES '?', '?', '?'";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "B001");
            ps.setString(2,"Urbano");
            ps.setString(3,"LC001");

            ps.executeUpdate();



        }catch (Exception e){
            throw new RuntimeException(e);
        }



        return true;

    }
}
