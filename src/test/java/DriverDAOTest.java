import DAO.BusDAO;
import DAO.DriverDAO;
import modelos.Bus;
import modelos.Conductor;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DriverDAOTest {
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
     * Metodo test para insertar un Conductor en la tabla de Conductor
     * @throws SQLException
     */
    @Test
    @Order(1)
    @DisplayName("Insertar Conductor en la BD")
    void testInsertarConductor() throws SQLException {

        //CAMBIAR LOS DATOS
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Conductor VALUES (?, ?, ?)"
        );
        ps.setString(1, "Pepe");
        ps.setString(2, "Garcia");
        ps.setInt(3, 111);


        int filas = ps.executeUpdate();


        assertEquals(1, filas);
    }

    /**
     * Test para buscar un Conductor existente
     * @throws SQLException
     */
    @Test
    @Order(2)
    @DisplayName("Buscar Conductor existente")
    void testBuscarConductorExistente() throws SQLException {


        con.createStatement().executeUpdate(
                "INSERT INTO Conductor VALUES ('Pepe','Garcia',111)"
        );


        Conductor conductor = DriverDAO.consultarConductor(111,con);


        assertNotNull(conductor);
        assertEquals("Pepe", conductor.getNombre());
        assertEquals("Garcia", conductor.getApellidos());
        assertEquals(111, conductor.getNumeroConductor());
    }

    /**
     * Test para buscar un Conductor inexistente
     */
    @Test
    @Order(3)
    @DisplayName("Buscar Conductor inexistente devuelve null")
    void testBuscarConductorInexistente() throws SQLException {


        Conductor conductor = DriverDAO.consultarConductor(111,con);


        assertNull(conductor);
    }

    /**
     * Test para mostrar todos los conductor
     * @throws SQLException
     */
    @Test
    @Order(4)
    @DisplayName("Mostrar todos los Conductor")
    void testMostrarTodosLosConductores() throws SQLException {


        con.createStatement().executeUpdate(
                "INSERT INTO Conductor VALUES ('B333','Turismo','LIC333')");
        con.createStatement().executeUpdate(
                "INSERT INTO Conductor VALUES ('B444','Urbano','LIC444')");


        List<Conductor> lista = Collections.singletonList(DriverDAO.consultarConductor(111, con));


        assertNotNull(lista);
        assertEquals(2, lista.size());
    }
}
