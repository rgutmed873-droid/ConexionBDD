package DAO;

import db.ConexionDB;
import modelos.Conductor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RutaDAO {


    //Metodo para insertar la ruta
    public RutaDAO insertRuta(int numRuta, String dia, int idLugar){
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
        return null;
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
            AND idLugar = ? 
            AND registro = ?
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
    public RutaDAO consultarRuta(int numRuta, String dia, int idLugar) {

        String sql = """
                SELECT FROM BDP
                WHERE numConductor = ?
                AND idLugar = ?
                AND registro = ?
                AND diadelasemana = ?
        """;

        try (Connection con = ConexionDB.getConexion()){

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1,numRuta);
            ps.setString(2,dia);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Conductor c = new Conductor();

                c.setNombre(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellido"));
                return c;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
