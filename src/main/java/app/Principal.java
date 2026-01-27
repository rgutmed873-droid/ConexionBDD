package app;



import dao.DriverDAO;
import modelos.Conductor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ArrayList<Conductor> conductores = new ArrayList<>();


        DriverDAO driverDAO = new DriverDAO();
        int opcion = 0;

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
            }
        }while (opcion != 0);

    }


}
