package app;



import DAO.DriverDAO;
import DAO.RutaDAO;
import View.Driverview;
import modelos.Bus;
import modelos.Conductor;
import modelos.Lugar;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {


        Driverview vistaConductor = new Driverview();
        DriverController control = new DriverController();


        ArrayList<Conductor> conductores = new ArrayList<>();
        ArrayList<RutaDAO> ruta = new ArrayList<>();
        ArrayList<Bus> bus = new ArrayList<>();
        ArrayList<Lugar> lugar = new ArrayList<>();

        menu(conductores, ruta, bus);


    }

    private static void menu(ArrayList<Conductor> conductores, ArrayList<RutaDAO> ruta, ArrayList<Bus> bus) {

        DriverDAO driverDAO = new DriverDAO();
        RutaDAO rutaDAO = new RutaDAO();
        int opcion;

        Scanner sc = new Scanner(System.in);

        //Para hacer:
        // Insertar bus, conductor, lugar y ruta
        // consultas de bus, lugar y ruta CONDUCTOR YA TENGO
        // Actualizar rutas por dias a la semana
        // borrar rutas, bus, conductor y lugar
        // Consultas de datos de conductor por numdriver
        // Dias a la semana preguntando la ciudad
        // datos de los conductores que conducen un bus por registro de numero de bus

        do {
            System.out.println("Bienvenido al sistema de AUCORSA");
            System.out.println("Que desea hacer?");
            System.out.println("\n 1. Consultar conductor"+
                               "\n 2. Insertar conductor"+
                                "\n 3. Borrar conductor"+
                                "\n 4. Consultar bus"+
                                "\n 5. Insertar bus"+
                                "\n 6. Borrar bus"+
                                "\n 7. Consultar lugar"+
                                "\n 8. Insertar lugar"+
                                "\n 9. Borrar lugar"+
                                "\n 10. Consultar ruta"+
                                "\n 11. Insertar ruta"+
                                "\n 12. Borrar ruta"+
                                "\n 0. Salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println(" Dime numero de conductor a consultar");
                    int numDriver = sc.nextInt();
                    conductores.add(driverDAO.consultarConductor(numDriver));
                    System.out.println(conductores.getFirst().getNombre() + " " +  conductores.getFirst().getApellidos());
                    break;
                case 2:
                    System.out.println("Dime los datos para introducir conductor");

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                break;
                case 6:

                break;
                case 7:

                break;
                case 8:

                break;
                case 9:

                break;
                case 10:

                break;
                case 11:
                    System.out.println("Dime los datos de la ruta");
                    int numRuta = sc.nextInt();
                    String dia = sc.nextLine();
                    int idLugar = sc.nextInt();
                    ruta.add(rutaDAO.insertRuta(numRuta,dia,idLugar));
                break;
                case 12:

                break;
                case 0:
                    System.out.println("Saliendo de la aplicación");
                    break;
            }
        }while (opcion != 0);
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
