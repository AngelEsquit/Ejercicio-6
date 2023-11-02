/*
Universidad del Valle de Guatemala
Angel Esteban Esquit Hernández - 23221
Ejercicio 6
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
        int num_telefonos = 0;
        int num_computadoras = 0;
        int num = 0;


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
                                break;
                            case 1: // Modelo
                                modelo = datos;
                                break;
                            case 2: // Estado
                                if (Integer.parseInt(datos) == 1) {
                                    estado = true;
                                }

                                else if (Integer.parseInt(datos) == 0) {
                                    estado = false;
                                }
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
                                break;
                            case 1: // Marca
                                marca = datos;
                                break;
                            case 2: // Estado
                                if (Integer.parseInt(datos) == 1) {
                                    estado = true;
                                }

                                else if (Integer.parseInt(datos) == 0) {
                                    estado = false;
                                }
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
                    preguntarTipo();

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
                            System.out.println("Ingrese el modelo");
                            modelo = scanner.nextLine();
                            System.out.println("Ingrese el estado");
                            System.out.println("1: Encendido");
                            System.out.println("2: Apagado");
                            num = scanner.nextInt();
                            scanner.nextLine();
                            switch (num) {
                                case 1:
                                    estado = true;
                                    dispositivos.add(new Telefono(modelo, estado));
                                    break;
                                case 2:
                                    estado = false;
                                    dispositivos.add(new Telefono(modelo, estado));
                                    break;
                                default:
                                    System.out.println("");
                                    System.out.println("Número inválido. Intente nuevamente.");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Ingrese la marca");
                            modelo = scanner.nextLine();
                            System.out.println("Ingrese el estado");
                            System.out.println("1: Encendido");
                            System.out.println("2: Apagado");
                            num = scanner.nextInt();
                            scanner.nextLine();
                            switch (num) {
                                case 1:
                                    estado = true;
                                    dispositivos.add(new Computadora(marca, estado));
                                case 2:
                                    estado = false;
                                    dispositivos.add(new Computadora(marca, estado));
                                default:
                                    System.out.println("");
                                    System.out.println("Número inválido. Intente nuevamente.");
                                    break;
                            }
                            break;
                        case 0:
                            continue;
                        default:
                            System.out.println("");
                            System.out.println("Número inválido. Intente nuevamente.");
                            break;
                    }

                    break;
                case 4:
                    String csvFilePath2 = "telefonos.csv"; // Establecer el archivo CSV

                    try (FileWriter writer = new FileWriter(csvFilePath2)) {
                        writer.append("id;modelo;estado\n"); // Escribir encabezados

                        for (DispositivoElectronico dispositivo : dispositivos) { // Escribir cada dispositivo en una nueva fila
                            if (dispositivo instanceof Telefono) {
                                Telefono telefono = (Telefono) dispositivo;
                                if (telefono.getEstado() == true) {
                                    writer.append(num_telefonos + ";" + telefono.getModelo() + ";1" + "\n");
                                }

                                else if (telefono.getEstado() == false) {
                                    writer.append(num_telefonos + ";" + telefono.getModelo() + ";0" + "\n");
                                }
                            }
                            num_telefonos += 1;
                        }     
                        System.out.println("");       
                        System.out.println("Datos guardados en " + csvFilePath2);
                    }
                    
                    catch (IOException e) { // Catch para errores al guardar el CSV
                        System.err.println("Error al guardarTelefono el archivo CSV: " + e.getMessage());
                    }

                    String csvFilePath3 = "computadoras.csv"; // Establecer el archivo CSV

                    try (FileWriter writer = new FileWriter(csvFilePath3)) {
                        writer.append("id;marca;estado\n"); // Escribir encabezados

                        for (DispositivoElectronico dispositivo : dispositivos) { // Escribir cada dispositivo en una nueva fila
                            if (dispositivo instanceof Computadora) {
                                Computadora computadora = (Computadora) dispositivo;
                                if (computadora.getEstado() == true) {
                                    writer.append(num_computadoras + ";" + computadora.getMarca() + ";1" + "\n");
                                }

                                else if (computadora.getEstado() == false) {
                                    writer.append(num_computadoras + ";" + computadora.getMarca() + ";0" + "\n");
                                }
                            }
                            num_computadoras += 1;
                        }     
                        System.out.println("");       
                        System.out.println("Datos guardados en " + csvFilePath3);
                    }
                    
                    catch (IOException e) { // Catch para errores al guardar el CSV
                        System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
                    }

                    salir = false;
                    System.out.println("Hasta pronto :)");
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

    public static void preguntarTipo() {
        System.out.println("");
        System.out.println("Ingrese la opción que desee:");
        System.out.println("1: Teléfono");
        System.out.println("2: Computadora");
        System.out.println("");
    }
}
