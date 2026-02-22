import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

import DAO.*;
import modelos.*;

class RutaDAOTest {

    private static Connection con;
    private RutaDAO rutaDAO;
    private BusDAO busDAO;
    private DriverDAO driverDAO;
    private LugarDAO lugarDAO;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Aucorsa",
                "root",
                "root");
    }

    @BeforeEach
    void prepararDatos() throws SQLException {
        con.createStatement().executeUpdate("DELETE FROM Ruta");
        con.createStatement().executeUpdate("DELETE FROM Bus");
        con.createStatement().executeUpdate("DELETE FROM Conductor");
        con.createStatement().executeUpdate("DELETE FROM Lugar");

        rutaDAO = new RutaDAO();
        busDAO = new BusDAO();
        driverDAO = new DriverDAO();
        lugarDAO = new LugarDAO();

        busDAO.insertBus(new Bus("RB1","Urbano","L1"), con);
        driverDAO.insertConductor(new Conductor("Pedro","Mayor",123), con);
        lugarDAO.insertLugar(new Lugar(10,"Centro","Dir",46577), con);
    }

    @Test
    void testInsertRuta() throws SQLException {
        Ruta r = new Ruta("Martes",3,"999",10);
        assertTrue(rutaDAO.insertRuta(r, con));
    }

    @Test
    void testFindRuta() throws SQLException {
        rutaDAO.insertRuta(new Ruta("Jueves",5,"999",10), con);
        assertNotNull(rutaDAO.findRuta(2, con));
    }

    @Test
    void testFindAllRuta() throws SQLException {
        rutaDAO.insertRuta(new Ruta("Viernes",6,"999",10), con);
        rutaDAO.insertRuta(new Ruta("Lunes",9,"999",10), con);

        ArrayList<Ruta> lista = rutaDAO.findAllRuta(con);
        assertEquals(2, lista.size());
    }

    @Test
    void testUpdateRuta() throws SQLException {
        rutaDAO.insertRuta(new Ruta("Miercoles",2,"999",10), con);
        assertTrue(rutaDAO.updateRuta(5,"RB1",999,10, con));
    }

    @Test
    void testDeleteRuta() throws SQLException {
        rutaDAO.insertRuta(new Ruta("Jueves",10,"999",10), con);
        assertTrue(rutaDAO.deleteRuta(6, con));
    }
}
