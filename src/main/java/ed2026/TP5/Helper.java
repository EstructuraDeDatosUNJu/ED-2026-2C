package ed2026.TP5;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Helper {

    //region Static Objects
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    //endregion

    //region Character Helpers
    public static Character getCharacter(Scanner scanner, String inputMessage, String errorMessage) {
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

    public static Character getCharacter(Scanner scanner, String inputMessage) {
        return getCharacter(scanner, inputMessage, "Ingrese un caracter válido");
    }

    public static Character getCharacter(String inputMessage, String errorMessage) {
        return getCharacter(Helper.scanner, inputMessage, errorMessage);
    }

    public static Character getCharacter(String inputMessage) {
        return getCharacter(Helper.scanner, inputMessage, "Ingrese un caracter válido");
    }
    //endregion

    //region Integer Helpers
    public static Integer getInteger(Scanner scanner, String inputMessage, String errorMessage) {
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

    public static Integer getInteger(Scanner scanner, String inputMessage) {
        return getInteger(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Integer getInteger(String inputMessage, String errorMessage) {
        return getInteger(Helper.scanner, inputMessage, errorMessage);
    }

    public static Integer getInteger(String inputMessage) {
        return getInteger(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion

    //region Double Helpers
    public static Double getDouble(Scanner scanner, String inputMessage, String errorMessage) {
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

    public static Double getDouble(Scanner scanner, String inputMessage) {
        return getDouble(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Double getDouble(String inputMessage, String errorMessage) {
        return getDouble(Helper.scanner, inputMessage, errorMessage);
    }

    public static Double getDouble(String inputMessage) {
        return getDouble(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion

    //region Float Helpers
    public static Float getFloat(Scanner scanner, String inputMessage, String errorMessage) {
        Float floatValue = 0f;
        while (true) {
            try {
                System.out.print(inputMessage);
                floatValue = Float.parseFloat(scanner.nextLine());
                return floatValue;
            } catch (Exception exception) {
                System.out.println(errorMessage);
            }
        }
    }

    public static Float getFloat(Scanner scanner, String inputMessage) {
        return getFloat(scanner, inputMessage, "Ingrese un número válido");
    }

    public static Float getFloat(String inputMessage, String errorMessage) {
        return getFloat(Helper.scanner, inputMessage, errorMessage);
    }

    public static Float getFloat(String inputMessage) {
        return getFloat(Helper.scanner, inputMessage, "Ingrese un número válido");
    }
    //endregion

    //region Array Helpers

    static void printOneDimensionArray(String textBefore, Object[] array, String textAfter) {
        System.out.print(textBefore);
        System.out.print("[" + array[0]);
        for (int i = 1; i < array.length; ++i) {
            System.out.print("," + array[i]);
        }
        System.out.print("]");
        System.out.print(textAfter);
    }

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
    //endregion

    //region Enum Helpers

    // from http://stackoverflow.com/questions/13783295/getting-all-names-in-an-enum-as-a-string
    public static String[] getEnumNames(Class<? extends Enum<?>> e) {
        return Arrays.toString(e.getEnumConstants()).replaceAll("^.|.$", "").split(", ");
    }

    //endregion

}
