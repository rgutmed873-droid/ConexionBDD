
import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import java.util.ArrayList;

import org.junit.jupiter.api.*;

import DAO.LugarDAO;
import modelos.Lugar;

class LugarDAOTest {

    private static Connection con;
    private LugarDAO lugarDAO;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Aucorsa",
                "root",
                "root");
    }

    @BeforeEach
    void limpiarTabla() throws SQLException {
        con.createStatement().executeUpdate("DELETE FROM Lugar");
        lugarDAO = new LugarDAO();
    }

    @Test
    void testInsertLugar() throws SQLException {
        Lugar l = new Lugar(1,"Centro","Calle Mayor",1234);
        assertTrue(lugarDAO.insertLugar(l, con));
    }

    @Test
    void testFindLugar() throws SQLException {
        lugarDAO.insertLugar(new Lugar(2,"Norte","Calle Norte",2345), con);
        assertNotNull(lugarDAO.findLugar(2, con));
    }

    @Test
    void testFindAllLugar() throws SQLException {
        lugarDAO.insertLugar(new Lugar(3,"A","A",34567), con);
        lugarDAO.insertLugar(new Lugar(4,"B","B",55473), con);

        ArrayList<Lugar> lista = lugarDAO.findAllLugar(con);
        assertEquals(2, lista.size());
    }

    @Test
    void testUpdateLugar() throws SQLException {
        lugarDAO.insertLugar(new Lugar(5,"Sur","Calle Sur",9827), con);
        assertTrue(lugarDAO.updateLugar(5,"SurMod","Nueva Dir",5555, con));
    }

    @Test
    void testDeleteLugar() throws SQLException {
        lugarDAO.insertLugar(new Lugar(6,"Este","Dir",23455), con);
        assertTrue(lugarDAO.deleteLugar(6, con));
    }
}