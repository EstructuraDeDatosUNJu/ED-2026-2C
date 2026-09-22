package ed2026.PI_I.G108;

import java.util.Scanner;

public class Helper {
    public static Scanner scanner = new Scanner(System.in);

    //Lectura de enteros
    public static Integer nextInteger(Scanner scanner, String inputMessage, String errorMessage) {
        while (true) {
            try {
                System.out.print(inputMessage);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    public static Integer nextInteger(String inputMessage, String errorMessage) {
        return nextInteger(Helper.scanner, inputMessage, errorMessage);
    }

    //Lectura de enteros
    public static Integer nextInteger(String inputMessage) {
        return nextInteger(Helper.scanner, inputMessage, "Error: Ingrese un número entero válido.");
    }

    //lectura de cadenas no vacias
    public static String nextString(String inputMessage, String errorMessage) {
        while (true) {
            System.out.print(inputMessage);
            String texto = Helper.scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            } else {
                System.out.println(errorMessage);
            }
        }
    }

    public static String nextString(String inputMessage) {
        return nextString(inputMessage, "Error:No puede estar vacio.");
    }
}
