package app;

import conexion.ConexionBBDD;

import java.util.Scanner;

public class Principal {

    static ConexionBBDD conexionBBDD;

    static void main(String[] args) {

        System.out.println("Bienvenido al sistema de AUCORSA");
        System.out.println("Que desea hacer?");
        System.out.println("\t 1. Consultar conductores");
        System.out.println("\t 2. Insertar conductores");
        System.out.println("\t 0. Salir");

        int opcion = 0;

        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();

        do {
            switch (opcion){
                case 1:
                    consultarConductor();
                    break;
            }
        }while (opcion != 0);

    }

    private static void consultarConductor() {
        conexionBBDD.consultarBBDD("select * from CONDUCTOR");
    }
}
