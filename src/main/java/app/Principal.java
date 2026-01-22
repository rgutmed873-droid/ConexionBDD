package app;



import java.sql.*;
import java.util.Scanner;

public class Principal {


    private static final String URL = "jdbc:mysql://127.0.0.1:3306/AUCORSA";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    static void main(String[] args) {



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
                    consultarConductor();
                    break;
                case 2:
                    insertarConductor();
                    break;
                case 3:
                    borrarConductor();
                    break;    
            }
        }while (opcion != 0);

    }

    private static void borrarConductor() {

    }

    private static void insertarConductor() {
        Connection con;
        try {
            con = DriverManager.getConnection(URL,USER,PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void consultarConductor() {

        Connection con;
        try{
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement s = con.createStatement();

            ResultSet rs = s.executeQuery("select * from CONDUCTOR");

            while (rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString("nombre"));

            }
            rs.close();
            s.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
