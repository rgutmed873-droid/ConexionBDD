import DAO.BusDAO;
import modelos.Bus;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BusDAOTest {
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
     * Metodo test para insertar un bus en la tabla de bus
     * @throws SQLException
     */
    @Test
    @Order(1)
    @DisplayName("Insertar Bus en la BD")
    void testInsertarBus() throws SQLException {

        //CAMBIAR LOS DATOS
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Bus VALUES (?, ?, ?)"
        );
        ps.setString(1, "B111");
        ps.setString(2, "Urbano");
        ps.setString(3, "LIC111");


        int filas = ps.executeUpdate();


        assertEquals(1, filas);
    }

    /**
     * Test para buscar un bus existente
     * @throws SQLException
     */
    @Test
    @Order(2)
    @DisplayName("Buscar bus existente")
    void testBuscarBusExistente() throws SQLException {


        con.createStatement().executeUpdate(
                "INSERT INTO Bus VALUES ('B222','Escolar','LIC222')"
        );


        Bus bus = BusDAO.findBus(con,"B333");


        assertNotNull(bus);
        assertEquals("B222", bus.getRegistro());
        assertEquals("Escolar", bus.getTipo());
        assertEquals("LIC222", bus.getLicencia());
    }

    /**
     * Test para buscar un bus inexistente
     */
    @Test
    @Order(3)
    @DisplayName("Buscar bus inexistente devuelve null")
    void testBuscarBusInexistente() {


        Bus bus = BusDAO.findBus(con, "NOEXISTE");


        assertNull(bus);
    }

    /**
     * Test para mostrar todos los buses
     * @throws SQLException
     */
    @Test
    @Order(4)
    @DisplayName("Mostrar todos los buses")
    void testMostrarTodosLosBuses() throws SQLException {


        con.createStatement().executeUpdate(
                "INSERT INTO Bus VALUES ('B333','Turismo','LIC333')");
        con.createStatement().executeUpdate(
                "INSERT INTO Bus VALUES ('B444','Urbano','LIC444')");


        List<Bus> lista = BusDAO.consultBus(con);


        assertNotNull(lista);
        assertEquals(2, lista.size());
    }

}