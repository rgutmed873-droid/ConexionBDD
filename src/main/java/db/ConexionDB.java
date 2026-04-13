/**
 * Paquete donde esta el metodo donde se realiza la conexión a la base de datos
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de Conexión DB que almacena los diferentes atributos que tiene y el metodo donde se establece conexión
 * con la base de datos
 */
public class ConexionDB {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/AUCORSA";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Metodo para establecer conexión con la base de datos
     * @return Devuelte la conexión con la base de datos de los atributos principales
     * @throws SQLException
     */
    public static Connection getConexion() throws SQLException {

        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
