import DAO.DriverDAO;
import DAO.LugarDAO;
import modelos.Conductor;
import modelos.Lugar;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LugarDAOTest {

    private static Connection con;

    /**
     * Test para realizar la conexión con la base de datos
     * @throws SQLException
     */
    @BeforeAll
    static void conectar() throws SQLException {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Aucorsa",
                "root",
                ""
        );
    }

    /**
     * Metodo para cerrar la base datos
     * @throws SQLException
     */
    @AfterAll
    static void cerrar() throws SQLException {
        if (con != null) con.close();
    }

    /**
     * Metodo para borras las tablas
     * @throws SQLException
     */
    @BeforeEach
    void limpiarTabla() throws SQLException {
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM Ruta");
        st.executeUpdate("DELETE FROM Bus");
    }

    /**
     * Metodo test para insertar un Lugar en la tabla de Lugar
     * @throws SQLException
     */
    @Test
    @Order(1)
    @DisplayName("Insertar Lugar en la BD")
    void testInsertarLugar() throws SQLException {

        //CAMBIAR LOS DATOS
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Lugar VALUES (?, ?, ?,?)"
        );
        ps.setInt(1, 11);
        ps.setString(2, "Salamanca");
        ps.setString(3, "Mayor");
        ps.setInt(4,23400);


        int filas = ps.executeUpdate();


        assertEquals(1, filas);
    }

    /**
     * Test para buscar un Lugar existente
     * @throws SQLException
     */
    @Test
    @Order(2)
    @DisplayName("Buscar Lugar existente")
    void testBuscarLugarExistente() throws SQLException {


        con.createStatement().executeUpdate(
                "INSERT INTO Lugar VALUES ('Salamanca','Mayor',23400)"
        );


        Lugar lugar = LugarDAO.consultarLugar(con,1);


        assertNotNull(lugar);
        assertEquals(11, lugar.getIdLugar());
        assertEquals("Salamanca", lugar.getCiudad());
        assertEquals("Mayor", lugar.getSitio());
        assertEquals(23400, lugar.getCp());
    }

    /**
     * Test para buscar un Lugar inexistente
     */
    @Test
    @Order(3)
    @DisplayName("Buscar Lugar inexistente devuelve null")
    void testBuscarLugarInexistente() throws SQLException {


        Lugar lugar = LugarDAO.consultarLugar(con,1);


        assertNull(lugar);
    }

    /**
     * Test para mostrar todos los lugares
     * @throws SQLException
     */
    @Test
    @Order(4)
    @DisplayName("Mostrar todos los lugares")
    void testMostrarTodosLosLugares() throws SQLException {


        con.createStatement().executeUpdate(
                "INSERT INTO Lugar VALUES ('B333','Turismo','LIC333')");
        con.createStatement().executeUpdate(
                "INSERT INTO Lugar VALUES ('B444','Urbano','LIC444')");


        List<Lugar> lista = Collections.singletonList(LugarDAO.consultarLugar(con, 1));


        assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
