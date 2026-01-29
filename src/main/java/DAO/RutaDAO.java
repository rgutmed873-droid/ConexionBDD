package DAO;

import db.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

    public class RutaDAO {


    //Metodo para insertar la ruta
    public void insertRuta(int numRuta, String dia, int idLugar){
    String sql = "INSERT INTO RUTA VALUE (?,?,?)";

        try(Connection con = ConexionDB.getConexion();
        PreparedStatement ps = con.prepareStatement(sql)){

        ps.setInt(1,numRuta);
        ps.setString(2,dia);
        ps.setInt(3,idLugar);
        ps.executeUpdate();

        }catch (Exception e){
        throw new RuntimeException(e);
        }
    }

    //Metodo para actualizar dias de la semana
    public void actualizarDiaRuta(int numRuta, String nuevoDia){
        String sql = "UPDATE RUTA SET diaSemana = ? WHERE numRuta = ?";

        try(Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1,nuevoDia);
            ps.setInt(2,numRuta);
            ps.executeUpdate();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //Metodo para borrar rutas
    public void eliminarRuta(int numeroConductor, int idLugar, String registro){
        String sql = """
            DELETE FROM BDP 
            WHERE numConductor = ? 
            AND idPlace = ? 
            AND register = ?
        """;

        try (Connection con = ConexionDB.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)){

            ps.setInt(1,numeroConductor);
            ps.setInt(2,idLugar);
            ps.setString(3,registro);
            ps.executeUpdate();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
