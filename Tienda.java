/*
Universidad del Valle de Guatemala
Angel Esteban Esquit Hernández - 23221
Ejercicio 6
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tienda {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = true;
        int opcion = 0;
        int conteo = -1;

        ArrayList<DispositivoElectronico> dispositivos = new ArrayList<>();

        int id = 0;
        String marca = "";
        String modelo = "";
        boolean estado = true;

        // Variable para saltar la primera fila de encabezados
        boolean primera_fila = true;

        String csvFilePath = "telefonos.csv"; // Establecer el archivo CSV
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) { // Lector de CSV
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) { // Saltar la primera fila de encabezados
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") && !datos.isEmpty()) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // ID
                                id = Integer.parseInt(datos);
                                System.out.println(id);
                                break;
                            case 1: // Modelo
                                modelo = datos;
                                System.out.println(modelo);
                                break;
                            case 2: // Estado
                                if (Integer.parseInt(datos) == 1) {
                                    estado = true;
                                }

                                else if (Integer.parseInt(datos) == 0) {
                                    estado = false;
                                }

                                System.out.println(estado);
                                break;
                            default:
                                break;
                        }
                    }
                }

                dispositivos.add(new Telefono(modelo, estado));
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        // Variable para saltar la primera fila de encabezados
        primera_fila = true;

        String csvFilePath1 = "computadoras.csv"; // Establecer el archivo CSV
        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath1))) { // Lector de CSV
            String line;
            while ((line = csvReader.readLine()) != null) {
                if (primera_fila) { // Saltar la primera fila de encabezados
                    primera_fila = false;
                    continue;
                }

                String[] data = line.split(";");
                for (String datos : data) {
                    conteo += 1;

                    if (!datos.equals("-") && !datos.isEmpty()) { // Identificación y separación de los datos por columna
                        switch (conteo) {
                            case 0: // ID
                                id = Integer.parseInt(datos);
                                System.out.println(id);
                                break;
                            case 1: // Marca
                                marca = datos;
                                System.out.println(id);
                                break;
                            case 2: // Estado
                                if (Integer.parseInt(datos) == 1) {
                                    estado = true;
                                }

                                else if (Integer.parseInt(datos) == 0) {
                                    estado = false;
                                }

                                System.out.println(estado);
                                break;
                            default:
                                break;
                        }
                    }
                }

                dispositivos.add(new Computadora(marca, estado));
                System.out.println(); // Salto de línea para cada fila
                conteo = -1;
            }
        } catch (IOException e) { // Catch para errores al leer el CSV
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        System.out.println(dispositivos.size());

        while (salir) {
            printMenu();

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Ingrese un número.");
                scanner.nextLine();
            }

            switch (opcion) {
                case 1:
                    for (DispositivoElectronico dispositivo : dispositivos) {
                        if (dispositivo instanceof Telefono) {
                            Telefono telefono = (Telefono) dispositivo;
                            System.out.println("Teléfono - Modelo: " + telefono.getModelo());
                        }
                        
                        else if (dispositivo instanceof Computadora) {
                            Computadora computadora = (Computadora) dispositivo;
                            System.out.println("Computadora - Marca: " + computadora.getMarca());
                        }
                    }
                    break;
                case 2:
                    for (DispositivoElectronico dispositivo : dispositivos) {
                        if (dispositivo instanceof Telefono) {
                            Telefono telefono = (Telefono) dispositivo;
                            System.out.println("Teléfono - Modelo: " + telefono.getModelo() + " - Estado: " + dispositivo.validarEstado());
                        }
                        
                        else if (dispositivo instanceof Computadora) {
                            Computadora computadora = (Computadora) dispositivo;
                            System.out.println("Computadora - Marca: " + computadora.getMarca() + " - Estado: " + dispositivo.validarEstado());
                        }
                    }
                    break;
                case 3:
                    salir = false;
                    System.out.println("// Salir del bucle");
                    break;
                case 4:
                    salir = false;
                    System.out.println("// Salir del bucle");
                    break;
                case 0:
                    continue;
                default:
                    System.out.println("");
                    System.out.println("Número inválido. Intente nuevamente.");
                    break;
            }

            opcion = 0;
        }
    }

    public static void printMenu() {
        System.out.println("");
        System.out.println("**************************************");
        System.out.println("                Menú");
        System.out.println("**************************************");
        System.out.println("Ingrese la opción que desee:");
        System.out.println("1: Información de los dispositivos");
        System.out.println("2: Mostrar estado de los dispositivos");
        System.out.println("3: Agregar un nuevo dispositivo");
        System.out.println("4: Salir");
        System.out.println("");
    }

    public static void printMenu() {
        System.out.println("");
        System.out.println("Ingrese la opción que desee:");
        System.out.println("1: Teléfono");
        System.out.println("2: Computadora");
        System.out.println("");
    }
}
