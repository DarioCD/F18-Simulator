import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        Avion F18 = null;

        String nombreFichero = "data/plane.dat";
        FileInputStream inputFile = null;
        BufferedInputStream bufferedInput = null;
        ObjectInputStream objectInput = null;
        try {
            inputFile = new FileInputStream(nombreFichero);
            bufferedInput = new BufferedInputStream(inputFile);
            objectInput = new ObjectInputStream(bufferedInput);

            try {
                Avion p = (Avion) objectInput.readObject();
                while (true) {
                    System.out.println(p);
                    p = (Avion) objectInput.readObject();
                }
            } catch (EOFException ex) {
                System.out.println("↑ ↑ ↑ AVIÓN ANTERIOR ↑ ↑ ↑");
            } catch (ClassNotFoundException e) {
                System.out.println("Se ha producido un error al leer un objeto");
            }

        } catch (FileNotFoundException e) {
            System.out.println("--- NO HAY AVIÓN ---");
        } catch (IOException e) {
            System.out.println("Se ha producido un error de entrada salida");
        }

        while (!salir) {

            System.out.println("1 --> Inicializar F18");
            System.out.println("2 --> Alternar el estado de los flaps");
            System.out.println("3 --> Alternar el estado del tren de aterrizaje");
            System.out.println("4 --> Armar sistema de eyección");
            System.out.println("5 --> Eyectar piloto");
            System.out.println("Q --> Salir del programa");
            System.out.print("Inotrduce una ocpión: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduzca el número de litros de combustible cargados: ");
                    float fuelLevel = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Introduzca apodo del piloto: ");
                    String pilotCallSign = sc.nextLine();
                    System.out.print("Introduzca número de escuadrón: ");
                    String squadNumber = sc.nextLine();
                    F18 = new Avion(fuelLevel, pilotCallSign, squadNumber);
                    System.out.println(F18);
                    break;
                case "2":
                    if (F18 != null) {
                        F18.toggleFlaps();
                        System.out.println(F18);
                    } else {
                        System.out.println("F-18 no inicializado");
                    }
                    break;
                case "3":
                    if (F18 != null) {
                        F18.toggleLandingGear();
                        System.out.println(F18);
                    } else {
                        System.out.println("F-18 no inicializado");
                    }
                    break;
                case "4":
                    if (F18 != null) {
                        F18.ejectionSystem();
                        System.out.println(F18);
                    } else {
                        System.out.println("F-18 no inicializado");
                    }
                    break;
                case "5":
                    if (F18 != null && F18.getEjectionSystem()) {
                        F18.setSeatOccupation(false);
                        System.out.println(F18);
                    } else {
                        System.out.println("Sistema de eyección no está armado");
                    }
                    break;
                case "Q":
                    FileOutputStream outputFile = null;
                    BufferedOutputStream bufferedOutput = null;
                    ObjectOutputStream objectOutput = null;

                    try {
                        outputFile = new FileOutputStream(nombreFichero);
                        bufferedOutput = new BufferedOutputStream(outputFile);
                        objectOutput = new ObjectOutputStream(bufferedOutput);

                        objectOutput.writeObject(F18);
                    } catch (FileNotFoundException e) {
                        System.out.println("Archivo f");
                    } catch (IOException e) {
                        System.out.println("Error entrada salida");
                    } finally {
                        try {
                            if (objectOutput != null) objectOutput.close();
                            if (bufferedOutput != null) bufferedOutput.close();
                            if (outputFile != null) outputFile.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    salir = true;
                    break;

            }
        }
    }
}