package app;



import DAO.BusDAO;
import DAO.DriverDAO;
import DAO.LugarDAO;
import DAO.RutaDAO;
import View.Driverview;
import modelos.Bus;
import modelos.Conductor;
import modelos.Lugar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                    insertarBus();
                    break;
                    case 2:
                    insertarConductor();
                    break;
                    case 3:
                    insertarLugar();
                    break;
                    case 4:
                    insertarRuta();
                    break;
                    case 5:
                    actualizarDiaRuta();
                    break;
                    case 6:
                    eliminarRuta();
                    break;
                    case 7:
                    consultarConductor();
                    break;
                    case 8:
                    consultarDiaCiudad();
                    break;
                    case 9:
                    consultarConductoresBus();
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

    private static void insertarBus() throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Dimer el número de registro del bus: ");

        String registro = sc.nextLine();
        System.out.println("Tipo de bus");
        String tipo = sc.nextLine();
        System.out.println("Licencia");
        String licencia = sc.nextLine();

        Bus bus = new Bus(registro, tipo, licencia);
        BusDAO busDAO = new BusDAO();
        boolean conseguido = busDAO.insertarBus(bus);

        System.out.println(conseguido ? "Autobus insertado correctamente." : "Error al insertar el autobus");
    }

    private static void insertarConductor() throws SQLException{
        Scanner sc = new Scanner(System.in);


        System.out.println("Nombre del conductor");
        String nombre = sc.nextLine();

        System.out.println("Apellido del conductor");
        String apellido = sc.nextLine();

        System.out.println("Introduce el número del conductor: ");
        int numConductor = sc.nextInt();

        Conductor conductor = new Conductor(nombre, apellido, numConductor);
        DriverDAO driverDAO = new DriverDAO();

        boolean conseguido = driverDAO.insertarConductor(conductor);
        System.out.println(conseguido ? "Conductor insertado correctamente." : "Error al insertar el conductor");

    }

    private static void insertarLugar() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el id del lugar");
        int idLugar = sc.nextInt();
        System.out.println("Nombre de la ciudad");
        String nombreCiudad = sc.nextLine();
        System.out.println("Nombre del sitio");
        String sitio = sc.nextLine();
        System.out.println("Introduce el código postal");
        int numPostal = sc.nextInt();

        Lugar lugar = new Lugar(idLugar, nombreCiudad, sitio, numPostal);
        LugarDAO lugarDAO = new LugarDAO();
        boolean conseguido = lugarDAO.insertarLugar(lugar);
        System.out.println(conseguido ? " Lugar insertado correctamente" : "Error al insertar el Lugar");
    }

    private static void insertarRuta() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el registro del bus");
        String registroBus = sc.nextLine();
        System.out.println("Introduce número del conductor");
        int numConductor = sc.nextInt();
        System.out.println("Introduce el id del lugar");
        int idLugar = sc.nextInt();
        System.out.println("Introduce el día de la semana");
        String diaSemana = sc.nextLine();

        RutaDAO rutaDAO = new RutaDAO();
        boolean conseguido = rutaDAO.insertRuta(registroBus,numConductor,idLugar,diaSemana);

        System.out.println(conseguido ? "Ruta insertada correctamente." : "Error al insertar el Ruta");
    }

    private static void actualizarDiaRuta() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el registro del bus");
        String registro = sc.nextLine();
        System.out.println("Dime el número de conductor");
        int numConductor = sc.nextInt();
        System.out.println("Dime el id del lugar");
        int idLugar = sc.nextInt();
        System.out.println("Nuevo día de la semana");
        String diaSemana = sc.nextLine();

        RutaDAO rutaDAO = new RutaDAO();
        boolean conseguidao = rutaDAO.actualizarDiaRuta(registro,numConductor,idLugar,diaSemana);

        System.out.println(conseguidao ? "Día de la ruta actualizado." : "Error al actualizar");
    }

    private static void eliminarRuta() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número del conductor");
        int numconductor =  sc.nextInt();
        System.out.println("Introduce el id del lugar");
        int idLugar = sc.nextInt();
        System.out.println("Introduce el registro del bus");
        String registroBus = sc.nextLine();

        RutaDAO rutaDAO = new RutaDAO();
        boolean conseguido = rutaDAO.eliminarRuta(numconductor,idLugar,registroBus);

        System.out.println(conseguido ? "Ruta eliminado." : "Error al eliminar");
    }

    private static void consultarConductor() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el número del conductor");
        int numConductor = sc.nextInt();

        DriverDAO driverDAO = new DriverDAO();
        Conductor conductor = driverDAO.consultarConductor(numConductor);

        if (conductor != null) {
            System.out.println("Conductor: " + conductor.getNombre() + " " + conductor.getApellidos());
        } else {
            System.out.println("Conductor no encontrado");
        }
    }

    private static void consultarDiaCiudad() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ciudad");
        String ciudad = sc.nextLine();

        RutaDAO rutaDAO = new RutaDAO();
        String dia = rutaDAO.consultaDiaCiudad(ciudad);

        if (dia != null) {
            System.out.println("Dia de la ruta: " + dia);
        }else  {
            System.out.println("No se encontró ruta para esa ciudad");
        }
    }

    private static void consultarConductoresBus() throws SQLException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Registro del bus");
        String registroBus = sc.nextLine();

        RutaDAO rutaDAO = new RutaDAO();
        List<Conductor> conductores = rutaDAO.consultarConductorBus(registroBus);
        if (conductores.isEmpty()){
            System.out.println("No hay conductores asignados a ese bus.");
        }else {
            System.out.println("Conductores del bus " + registroBus + ":");
            for (Conductor c : conductores) {
                System.out.println(c.getNombre() + " " + c.getApellidos());
            }
        }
    }

    /**
     * Para más adelante para las interfaz
     */
//        JFrame miVentana = new JFrame("Curro es mi primera ventana");
//
//        miVentana.setTitle("Aucorsa");
//        miVentana.setBounds(200,200,800,600);
//        miVentana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        JPanel panelPrincipal = new JPanel();
//
//        JLabel numConductor = new JLabel("Numero conductor: ");
//        JTextField txtNumConductor = new JTextField(10);
//        JButton bntBuscar = new JButton("Buscar");
//        JLabel mostrarResultado = new JLabel();
//        mostrarResultado.setText("cargando...");
//
//        txtNumConductor.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                if (e.getKeyChar() == 'Q'){
//                    System.out.println("Vas a salir.");
//                    System.exit(0);
//                }
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//        });
//
//        txtNumConductor.addActionListener(e -> {
//
//
//            }
//        );
//        bntBuscar.addActionListener(e -> {
//            String numdriver = txtNumConductor.getText();
//            JOptionPane.showMessageDialog(null,"Numero de conductor " + numdriver);
//            int resultado = JOptionPane.showConfirmDialog(null,"¿Estas seguro que quieres guardar?");
//            switch (resultado)
//            {
//                case 0 -> {
//
//                }
//                case 1 -> {}
//            }
//
//         }
//        );
//
//
//        panelPrincipal.add(numConductor);
//        panelPrincipal.add(txtNumConductor);
//        panelPrincipal.add(bntBuscar);
//        panelPrincipal.add(mostrarResultado);
//
//        miVentana.add(panelPrincipal);
//        miVentana.setVisible(true);
}
