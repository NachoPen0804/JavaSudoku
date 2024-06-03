import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JuegosDeVerano {

    // Clase la cual llamara a los juegos que hagamos
    static Scanner sc = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        int opcion = 0, numJugadores;

        numJugadores = menuJugadores();

        if (numJugadores <= 0) {
            gestionOpcion(numJugadores, opcion);
        } else {
            opcion = menuJuegos(numJugadores);
        }

        gestionOpcion(numJugadores, opcion);
    }

    public static int menuJugadores() {

        System.out.println("""
                Bienvenido a los juegos de verano
                
                Indique el número de jugadores que van a jugar: """);

        int numJugadores;

        try {
            numJugadores = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Tipo de valor no aceptado.");
            LOGGER.error(e.getMessage());
            return 0;
        }

        if (numJugadores <= 0) {
            System.out.println("Opción no válida");
        }

        return numJugadores;

    }

    public static int menuJuegos(int numJugadores) {

        int opcion;

        if (numJugadores == 1) {
            opcion = menuJuegosSingleplayer();
        } else {
            opcion = menuJuegosMultijugador(numJugadores);
        }

        return opcion;
    }

    public static int menuJuegosSingleplayer() {
        System.out.println("""
                Elige el juego que quieras jugar: 
                
                1. Sudoku
                2. Salir""");
        // Para juegos multiplayer más adelante

        int opcion;

        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Tipo de valor no aceptado.");
            LOGGER.error(e.getMessage());
            return 2;
        }

        if (opcion <= 0 || opcion > 2) {
            System.out.println("Opción no válida");
        }

        return opcion;
    }

    public static int menuJuegosMultijugador(int numJugadores) {
        System.out.println("""
                Elige el juego que quieras jugar: 
                
                1. Salir""");
        // Para juegos multiplayer más adelante

        int opcion;

        try {
            opcion = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Tipo de valor no aceptado.");
            LOGGER.error(e.getMessage());
            return 1;
        }

        if (opcion <= 0 || opcion > 1) {
            System.out.println("Opción no válida");
        }

        return opcion;
    }

    public static void gestionOpcion(int numJugadores, int opcion) {

        Juego juego;

        switch (opcion) {
            case 1:
                if (numJugadores == 1) {
                    juego = new Sudoku();
                } else {
                    System.out.println("Saliendo del programa. Adios :)");
                    System.exit(0);
                }

            default:
                System.out.println("Saliendo del programa. Adios :)");
                System.exit(0);
        }
    }
}
