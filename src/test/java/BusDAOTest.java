import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

import DAO.BusDAO;
import modelos.Bus;

class BusDAOTest {

    private static Connection con;
    private BusDAO busDAO;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Aucorsa",
                "root",
                "root");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        con.close();
    }

    @BeforeEach
    void limpiarTabla() throws SQLException {
        con.createStatement().executeUpdate("DELETE FROM Bus");
        busDAO = new BusDAO();
    }

    @Test
    void testInsertBus() throws SQLException {
        Bus bus = new Bus("B1","Urbano","LIC1");
        assertTrue(busDAO.insertBus(bus, con));
    }

    @Test
    void testFindBus() throws SQLException {
        Bus bus = new Bus("B2","Escolar","LIC2");
        busDAO.insertBus(bus, con);

        Bus encontrado = busDAO.findBusByRegistro("B2", con);
        assertNotNull(encontrado);
    }

    @Test
    void testFindAllBus() throws SQLException {
        busDAO.insertBus(new Bus("B3","Urbano","L1"), con);
        busDAO.insertBus(new Bus("B4","Escolar","L2"), con);

        ArrayList<Bus> lista = busDAO.consultBus(con);
        assertEquals(2, lista.size());
    }

    @Test
    void testUpdateBus() throws SQLException {
        busDAO.insertBus(new Bus("B5","Urbano","L5"), con);

        assertTrue(busDAO.updateBus("B5","Escolar","NEWL", con));
    }

    @Test
    void testDeleteBus() throws SQLException {
        busDAO.insertBus(new Bus("B6","Urbano","L6"), con);

        assertTrue(busDAO.deleteBus("B6", con));
    }
}