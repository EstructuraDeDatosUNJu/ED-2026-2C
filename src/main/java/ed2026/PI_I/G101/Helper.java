package ed2026.PI_I.G101;

import java.util.Scanner;

/**
 * Clase helper con metodos estaticos para la validacion de entradas
 * Helper
 */
public class Helper {
    /**
     * Scanner estatico para ser usado en toda la aplicacion
     */
    static Scanner scanner = new Scanner(System.in);

    /**
     * Metodo que valida el ingreso de caracteres
     * 
     * @param scanner de tipo Scanner
     * @param mensaje de tipo String
     * @return caracter de tipo Character
     */
    public static Character nextCharacter(Scanner scanner, String mensaje) {
        Character caracter;
        while (true) {
            System.out.println(mensaje);
            if (scanner.hasNext(".")) {
                caracter = scanner.next().charAt(0);
                return caracter;
            }
            System.out.println("[Error]: No ingresaste in caracter");
        }
    }

    /***
     * Metodo que valida el ingreso de valores enteros positivos
     */
    public static Integer nextInteger(Scanner scanner, String mensaje, int min) {
        int valor;
        while (true) {
            System.out.println(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor > min) {
                    scanner.nextLine();
                    return valor;
                }
                System.out.println("[Error] Valor invalido, debe ingresar valor positivo");
            } else {
                System.out.println("[Error] Valor invalido, debe ser un numero entero");
            }
        }
    }

    /**
     * Metodo que valida el ingreso de valores enteros positivos
     */
    public static Integer nextInteger(String mensaje, int min) {
        return nextInteger(Helper.scanner, mensaje, min);
    }

    /**
     * Metodo que valida el ingreso de caracteres
     */
    public static Character nexCharacter(String mensaje) {
        return nextCharacter(Helper.scanner, mensaje);
    }

    public static Integer randomInteger(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static Integer nextInteger(Scanner scanner, String mensaje) {
        return nextInteger(scanner, mensaje, 0);
    }

    /**
     * Método que solicita al usuario un número entero y lo devuelve.
     * 
     * @param scanner      objeto de la clase Scanner
     * @param inputMessage mensaje que se muestra al usuario para solicitar el caracter
     * @param errorMessage mensaje que se muestra al usuario en caso de error
     * @return el número entero ingresado por el usuario
     */
    public static Integer nextInteger(Scanner scanner, String inputMessage, String errorMessage) {
        Integer integerValue = 0;
        while (true) {
            try {
                System.out.print(inputMessage);
                integerValue = Integer.parseInt(scanner.nextLine());
                return integerValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    public static Integer nextInteger(String inputMessage, String errorMessage) {
        return nextInteger(Helper.scanner, inputMessage, errorMessage);
    }

    /**
     * Método que solicita al usuario un número entero dentro de un rango y lo devuelve.
     * 
     * @param scanner      objeto de la clase Scanner
     * @param inputMessage mensaje que se muestra al usuario para solicitar el número
     * @param minValue     valor mínimo del rango
     * @param maxValue     valor máximo del rango
     * @return el número entero ingresado por el usuario
     */
    public static Integer nextInteger(Scanner scanner, String inputMessage, int minValue, int maxValue) {
        int valor;
        while (true) {
            System.out.println(inputMessage);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= minValue && valor <= maxValue) {
                    return valor;
                }
                System.out.println(
                        "[Error] Valor invalido, debe ingresar un numero entre " + minValue + " y " + maxValue);
            } else {
                System.out.println("[Error] Valor invalido, debe ser un numero entero");
            }
        }
    }

    /**
     * Método que solicita al usuario un número entero dentro de un rango y lo devuelve.
     * 
     * @param inputMessage mensaje que se muestra al usuario para solicitar el número
     * @param minValue     valor mínimo del rango
     * @param maxValue     valor máximo del rango
     * @return el número entero ingresado por el usuario
     */
    public static Integer nextInteger(String inputMessage, int minValue, int maxValue) {
        return nextInteger(Helper.scanner, inputMessage, "Error: Ingrese un número entero válido.");
    }

    /**
     * Método que solicita al usuario un String y lo devuelve.
     * 
     * @param mensaje mensaje que se muestra al usuario para solicitar el String
     * @return el String ingresado por el usuario
     */
    public static String nextString(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

}