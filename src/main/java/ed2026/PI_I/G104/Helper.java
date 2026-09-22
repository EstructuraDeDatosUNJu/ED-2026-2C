package ed2026.PI_I.G104;

import java.util.Scanner;

public class Helper {
    /*
     * Objeto Scanner para leer datos desde la consola
     * Este objeto Scanner pertenece a la clase Helper y no a una instancia en particular
     * de este modo no es necesario crear el objeto cada vez que se necesita
     */
    static Scanner scanner = new Scanner(System.in);

    /**
     * Método que solicita al usuario un caracter y lo devuelve.
     * 
     * @param scanner      objeto de la clase Scanner
     * @param inputMessage mensaje que se muestra al usuario para solicitar el caracter
     * @param errorMessage mensaje que se muestra al usuario en caso de error
     * @return el caracter ingresado por el usuario
     */
    public static Character nextCharacter(Scanner scanner, String inputMessage, String errorMessage) {
        Character characterValue;
        while (true) {
            System.out.print(inputMessage);
            try {
                characterValue = scanner.nextLine().charAt(0);
                return characterValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    // Sobrecargas del método nextCharacter para permitir diferentes combinaciones de parámetros

    // No hace falta el mensaje de error, se utiliza un mensaje por defecto
    public static Character nextCharacter(Scanner scanner, String inputMessage) {
        return nextCharacter(scanner, inputMessage, "Ingrese un caracter válido");
    }

    // No hace falta el objeto Scanner, se utiliza el objeto Scanner de la clase Helper
    public static Character nextCharacter(String inputMessage, String errorMessage) {
        return nextCharacter(Helper.scanner, inputMessage, errorMessage);
    }

    // No hace falta el objeto Scanner ni el mensaje de error, se utilizan los valores por defecto
    public static Character nextCharacter(String inputMessage) {
        return nextCharacter(Helper.scanner, inputMessage, "Ingrese un caracter válido");
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

    public static Integer nextInteger(Scanner scanner, String inputMessage) {
        return nextInteger(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Integer nextInteger(String inputMessage, String errorMessage) {
        return nextInteger(Helper.scanner, inputMessage, errorMessage);
    }

    public static Integer nextInteger(String inputMessage) {
        return nextInteger(Helper.scanner, inputMessage, "Ingrese un número válido");
    }

    public static int nextNonNegativeInteger(Scanner scanner, String mensaje, String mensajeError) {
        int numero = -1;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                numero = Integer.parseInt(entrada);

                if (numero < 0) {
                    System.out.println("Error: El número no puede ser negativo.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
            }

        } while (!valido);

        return numero;
    }

    /**
     * Método que solicita al usuario un número doble y lo devuelve.
     * 
     * @param scanner      objeto de la clase Scanner
     * @param inputMessage mensaje que se muestra al usuario para solicitar el caracter
     * @param errorMessage mensaje que se muestra al usuario en caso de error
     * @return el número doble ingresado por el usuario
     */
    public static Double nextDouble(Scanner scanner, String inputMessage, String errorMessage) {
        Double doubleValue = 0.0;
        while (true) {
            try {
                System.out.print(inputMessage);
                doubleValue = Double.parseDouble(scanner.nextLine());
                return doubleValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    public static Double nextDouble(Scanner scanner, String inputMessage) {
        return nextDouble(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Double nextDouble(String inputMessage, String errorMessage) {
        return nextDouble(Helper.scanner, inputMessage, errorMessage);
    }

    public static Double nextDouble(String inputMessage) {
        return nextDouble(Helper.scanner, inputMessage, "Ingrese un número válido");
    }

    public static Boolean nextBoolean(Scanner scanner, String inputMessage, String errorMessage) {
        while (true) {
            System.out.print(inputMessage);
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("s")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    public static Boolean nextBoolean(String inputMessage, String errorMessage) {
        return nextBoolean(Helper.scanner, inputMessage, errorMessage);
    }

    public static Boolean nextBoolean(String inputMessage) {
        return nextBoolean(Helper.scanner, inputMessage, "Debe ingresar 's' para Sí o 'n' para No.");
    }

    public static String nextString(Scanner scanner, String inputMessage, String errorMessage) {
        String stringValue = "";
        while (true) {
            try {
                System.out.print(inputMessage);
                stringValue = scanner.nextLine();
                return stringValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    /**
     * Imprime un arreglo de una dimensión.
     * 
     * @param textBefore mensaje que se muestra antes del arreglo
     * @param array      el arreglo a imprimir
     * @param textAfter  mensaje que se muestra después del arreglo
     */
    static void printOneDimensionArray(String textBefore, Object[] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; ++i) {
            System.out.print("," + array[i]);
        }
        System.out.print("]");
        System.out.print(textAfter);
    }

    /**
     * Imprime un arreglo de dos dimensiones.
     * 
     * @param textBefore mensaje que se muestra antes del arreglo
     * @param array      el arreglo a imprimir
     * @param textAfter  mensaje que se muestra después del arreglo
     */
    static void printTwoDimensionArray(String textBefore, Object[][] array, String textAfter) {
        System.out.print(textBefore);

        System.out.print("[[" + array[0][0]);
        for (int j = 1; j < array[0].length; ++j) {
            System.out.print("," + array[0][j]);
        }
        System.out.print("]");

        for (int i = 1; i < array.length; ++i) {
            System.out.print(",[" + array[i][0]);
            for (int j = 1; j < array[i].length; ++j) {
                System.out.print("," + array[i][j]);
            }
            System.out.print("]");
        }
        System.out.print("]");
        System.out.print(textAfter);
    }

}