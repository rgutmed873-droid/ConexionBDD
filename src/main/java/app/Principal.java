package app;



import DAO.DriverDAO;
import modelos.Conductor;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {

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

        ArrayList<Conductor> conductores = new ArrayList<>();


        menu(conductores);


    }

    private static void menu(ArrayList<Conductor> conductores) {

        DriverDAO driverDAO = new DriverDAO();
        int opcion;

        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Bienvenido al sistema de AUCORSA");
            System.out.println("Que desea hacer?");
            System.out.println("\t 1. Consultar conductor");
            System.out.println("\t 2. Insertar conductor");
            System.out.println("\t 3. Borrar conductor");
            System.out.println("\t 0. Salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println(" Dime numero de conductor a consultar");
                    int numDriver = sc.nextInt();
                    conductores.add(driverDAO.consultarConductor(numDriver));
                    conductores.getFirst().getNombre();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación");
                    break;
            }
        }while (opcion != 0);
    }


}
