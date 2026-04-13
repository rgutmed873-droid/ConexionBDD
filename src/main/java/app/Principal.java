/**
 * Paquete donde se encuentra la clase principal que cuando se ejecuta es lo que ve el usuario
 */
package app;



import DAO.BusDAO;
import DAO.DriverDAO;
import DAO.LugarDAO;
import DAO.RutaDAO;
import db.ConexionDB;
import modelos.Bus;
import modelos.Conductor;
import modelos.Lugar;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal donde esta la app de nuestro programa
 * Aquí es donde vamos añadir solo la llamada a las diferentes clases que tiene sus metodos y ejecuciones
 */
public class Principal {


    /**
     * Principal o main donde esta todo el código donde se ejecuta el programa
     * @param args Diferentes argumentos para ejectuar la aplicación
     * @throws SQLException Error que se produce en la conexión con la base de datos
     */
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = ConexionDB.getConexion();
        BusDAO busDAO = new BusDAO();
        DriverDAO driverDAO = new DriverDAO();
        LugarDAO lugarDAO = new LugarDAO();
        RutaDAO rutaDAO = new RutaDAO();

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                    //Insertar Bus
                    System.out.println("Dime el número de registro del bus: ");
                    String registro = sc.nextLine();

                    System.out.println("Dime el tipo de bus");
                    String tipo = sc.nextLine();

                    System.out.println("Dime la licencia");
                    String licencia = sc.nextLine();

                    Bus bus = new Bus(registro, tipo, licencia);

                    boolean busInsertado = busDAO.insertBus(bus, con);

                    if (busInsertado) {
                        System.out.println("Autobus insertado correctamente");
                    }else {
                        System.out.println("No se ha insertado un nuevo Autobus");
                    }

                    break;
                    case 2:
                    //Insertar Conductor
                    System.out.println("Nombre del conductor");
                    String nombre = sc.nextLine();

                    System.out.println("Apellido del conductor");
                    String apellido = sc.nextLine();

                    System.out.println("Introduce el número del conductor: ");
                    int numConductor = sc.nextInt();

                    Conductor conductor = new Conductor(nombre, apellido, numConductor);

                    boolean conductorInsertado = driverDAO.insertConductor(conductor,con);

                    if (conductorInsertado) {
                        System.out.println("Conductor insertado correctamente");
                    }else {
                        System.out.println("No se ha insertado un nuevo el conductor");
                    }
                    break;
                    case 3:
                    //Insertar Lugar
                    System.out.println("Dime el id del lugar");
                    int idLugar = sc.nextInt();

                    System.out.println("Nombre de la ciudad");
                    String nombreCiudad = sc.nextLine();

                    System.out.println("Nombre del sitio");
                    String sitio = sc.nextLine();

                    System.out.println("Introduce el código postal");
                    int numPostal = sc.nextInt();

                    Lugar lugar = new Lugar(idLugar, nombreCiudad, sitio, numPostal);

                    boolean lugarInsertado = lugarDAO.insertLugar(lugar,con);
                    if (lugarInsertado) {
                        System.out.println("Lugar insertado correctamente");
                    }else {
                        System.out.println("No se ha insertado un nuevo lugar");
                    }
                    break;
                    case 4:
                    //Insertar Ruta
                    System.out.println("Introduce el registro del bus");
                    String registroBus = sc.nextLine();

                    System.out.println("Introduce número del conductor");
                    int numConductorRuta = sc.nextInt();

                    System.out.println("Introduce el id del lugar");
                    int idLugarRuta = sc.nextInt();

                    System.out.println("Introduce el día de la semana");
                    String diaSemana = sc.nextLine();

                    boolean insertarRuta = rutaDAO.insertRuta(con);

                    if (insertarRuta){
                        System.out.println("Ruta insertada correctamente");
                    }else {
                        System.out.println("No se ha insertado ninguna ruta");
                    }
                    break;
                    case 5:
                    // Actualizar día de ruta
                    System.out.println("Dime el registro del bus");
                    String registroDiaRuta = sc.nextLine();

                    System.out.println("Dime el número de conductor");
                    int numConductorDiaRuta = sc.nextInt();

                    System.out.println("Dime el id del lugar");
                    int idLugarDiaRuta = sc.nextInt();

                    System.out.println("Nuevo día de la semana");
                    String diaSemanaDiaRuta = sc.nextLine();

                    boolean actualizacionDiaRuta = rutaDAO.actualizarDiaRuta(registroDiaRuta,numConductorDiaRuta,idLugarDiaRuta,diaSemanaDiaRuta,con);

                    if (actualizacionDiaRuta) {
                        System.out.println("Día de la ruta actualizado correctamente");
                    }else {
                        System.out.println("No se ha podido actualizar el día para la ruta");
                    }
                    break;
                    case 6:
                    // Eliminar Ruta
                    System.out.println("Introduce el número del conductor");
                    int numConducEliminar =  sc.nextInt();

                    System.out.println("Introduce el id del lugar");
                    int idLugarEliminar = sc.nextInt();

                    System.out.println("Introduce el registro del bus");
                    String registroBusEliminar = sc.nextLine();

                    boolean rutaEliminar = rutaDAO.deleteRuta(idLugarEliminar,con);

                    if (rutaEliminar) {
                        System.out.println("Ruta eliminada correctamente");
                    }else {
                        System.out.println("No se ha podido eliminar el ruta");
                    }
                    break;
                    case 7:
                    //Consultar conductor por número de conductor
                    System.out.println("Dime el número del conductor");
                    int numConductorConsulta = sc.nextInt();

                    Conductor conductorConsulta = driverDAO.findConductor(numConductorConsulta,con);

                    if (conductorConsulta != null) {
                        System.out.println("Conductor: " + conductorConsulta.getNombre() + " " + conductorConsulta.getApellidos());
                    } else {
                        System.out.println("Conductor no encontrado");
                    }
                    break;
                    case 8:
                    //Consultar día de ruta por ciudad
                    System.out.println("Introduce la ciudad");
                    String ciudad = sc.nextLine();

                    String dia = rutaDAO.consultaDiaCiudad(ciudad,con);

                    if (dia != null) {
                        System.out.println("Dia de la ruta: " + dia);
                    }else  {
                        System.out.println("No se encontró ruta para esa ciudad");
                        }

                    break;
                    case 9:
                    //Consulta de Conductores en un bus
                    System.out.println("Registro del bus");
                    String registroBusConsulta = sc.nextLine();

                    List<Conductor> conductores = rutaDAO.consultarConductorBus(registroBusConsulta,con);
                    if (conductores.isEmpty()){
                        System.out.println("No hay conductores asignados a ese bus.");
                    }else {
                        System.out.println("Conductores del bus " + registroBusConsulta + ":");
                        for (Conductor c : conductores) {
                            System.out.println(c.getNombre() + " " + c.getApellidos());
                        }
                    }
                    break;
                    case 0:
                    System.out.println("Saliendo de la aplicación");
                    break;
                }
            }catch (SQLException e){
                System.out.println("Error en la base de datos" + e.getMessage());
            }

        }while (opcion != 0);


    }

    /**
     * Metodo que muestra el menú de opciones de la aplicación
     */
    private static void mostrarMenu() {
        System.out.println("===== MENÚ AUCORSA =====");
        System.out.println("¿QUE DESEA REALIZAR?");
        System.out.println("1. Insertar autobus");
        System.out.println("2. Insertar Conductor");
        System.out.println("3. Insertar Lugar");
        System.out.println("4. Insertar Ruta");
        System.out.println("5. Actualizar día de ruta");
        System.out.println("6. Eliminar Ruta");
        System.out.println("7. Consultar conductor por número");
        System.out.println("8. Consultar día de ruta por ciudad");
        System.out.println("9. Consultar conductor por bus");
        System.out.println("0: Saliendo de la aplicación");
    }

}
