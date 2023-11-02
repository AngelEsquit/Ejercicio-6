import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Tienda {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = true;
        int opcion = 0;

        while (salir) {
            printMenu();
        }
    }

    public static void printMenu() {
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("                Menú");
        System.out.println("**************************************");
        System.out.println("Ingrese la opción que desee:");
        System.out.println("1: Agregar un nuevo jugador");
        System.out.println("2: Mostrar los jugadores del campeonato");
        System.out.println("3: Mejores porteros");
        System.out.println("4: Mejores extremos");
        System.out.println("5: Salir");
        System.out.println("");
    }
}
