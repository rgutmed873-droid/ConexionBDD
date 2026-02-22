import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;

import DAO.DriverDAO;
import org.junit.jupiter.api.*;

import modelos.Conductor;

class ConductorDAOTest {

    private static Connection con;
    private DriverDAO driverDAO;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Aucorsa",
                "root",
                "root");
    }

    @BeforeEach
    void limpiarTabla() throws SQLException {
        con.createStatement().executeUpdate("DELETE FROM Conductor");
        driverDAO = new DriverDAO();
    }

    @Test
    void testInsertConductor() throws SQLException {
        Conductor c = new Conductor("Juan","Perez",115);
        assertTrue(driverDAO.insertConductor(c, con));
    }

    @Test
    void testFindConductor() throws SQLException {
        driverDAO.insertConductor(new Conductor("Ana","García",114), con);
        assertNotNull(driverDAO.findConductor(222, con));
    }

    @Test
    void testFindAllConductor() throws SQLException {
        driverDAO.insertConductor(new Conductor("Luis","Garcia",1), con);
        driverDAO.insertConductor(new Conductor("Pepe","Barranco",2), con);

        ArrayList<Conductor> lista = driverDAO.findAllConductor(con);
        assertEquals(2, lista.size());
    }

    @Test
    void testUpdateConductor() throws SQLException {
        driverDAO.insertConductor(new Conductor("Maria","Martinez",112), con);
        assertTrue(driverDAO.updateConductor(333,"PedroNuevo","699999999", con));
    }

    @Test
    void testDeleteConductor() throws SQLException {
        driverDAO.insertConductor(new Conductor("Luna","Lopez",122), con);
        assertTrue(driverDAO.deleteConductor(444, con));
    }
}