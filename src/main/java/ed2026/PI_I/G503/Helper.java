package ed2026.PI_I.G503;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Helper {

    // Método para validar un número entero ingresado por el usuario
    public static int validarEntero(Scanner entrada, String mensaje) {
        int numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.println(mensaje);
                valorIngresado = entrada.nextLine();
                numero = Integer.parseInt(valorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
        return numero;
    }

    // Método para validar un número entero no negativo
    public static int validarEnteroNoNegativo(Scanner entrada, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 0) {
                    return numero;
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número entero.");
            }
        }
    }

    // Método para validar un número double no negativo
    public static double validarDoubleNoNegativo(Scanner entrada, String mensaje) {
        double numero;
        while (true) {
            try {
                System.out.println(mensaje);
                numero = Double.parseDouble(entrada.nextLine().trim());
                if (numero >= 0) {
                    return numero;
                } else {
                    System.out.println("Error!!! El número no puede ser negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error!!! Debe ingresar un número de tipo double.");
            }
        }
    }

    // Método para validar un número de tipo double ingresado por el usuario
    public static double validarDouble(Scanner entrada, String mensaje) {
        double numero;
        String valorIngresado;
        while (true) {
            try {
                System.out.println(mensaje);
                valorIngresado = entrada.nextLine();
                numero = Double.parseDouble(valorIngresado);
                break;
            } catch (Exception e) {
                System.out.println("Error!!! Debe ingresar un número de tipo double.");
            }
        }
        return numero;
    }

    // Método para validar una respuesta de "sí" o "no"
    public static boolean validarSiNo(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {
            System.out.println(mensaje + " (sí/no):");
            valorIngresado = entrada.nextLine().trim().toLowerCase();
            if (valorIngresado.equals("sí") || valorIngresado.equals("si")) {
                return true;
            } else if (valorIngresado.equals("no")) {
                return false;
            } else {
                System.out.println("Error!!! Debe responder 'sí' o 'no'.");
            }
        }
    }

    // Método para validar un string no vacío ingresado por el usuario
    public static String validarStringNoVacio(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {
            System.out.println(mensaje);
            valorIngresado = entrada.nextLine().trim();
            if (!valorIngresado.isEmpty()) {
                return valorIngresado;
            } else {
                System.out.println("Error!!! El texto no puede estar vacío.");
            }
        }
    }

    // Método para validar un entero dentro de un rango específico
    public static int validarEnteroEnRango(Scanner entrada, String mensaje, int min, int max) {
        int numero;
        while (true) {
            numero = validarEntero(entrada, mensaje + " (entre " + min + " y " + max + "):");
            if (numero >= min && numero <= max) {
                return numero;
            } else {
                System.out.println("Error!!! El número debe estar entre " + min + " y " + max + ".");
            }
        }
    }

    public static int validarEnteroEnRango(Scanner entrada, String mensaje, String mensaje_err, int min, int max) {
        int numero;
        while (true) {
            numero = validarEntero(entrada, mensaje + " (entre " + min + " y " + max + "):");
            if (numero >= min && numero <= max) {
                return numero;
            } else {
                System.out.println(mensaje_err);
            }
        }
    }

    // Método para validar si un string contiene solo letras
    public static String validarSoloLetras(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {
            System.out.println(mensaje);
            valorIngresado = entrada.nextLine().trim();
            if (valorIngresado.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return valorIngresado;
            } else {
                System.out.println("Error!!! El texto solo puede contener letras.");
            }
        }
    }

    // Método para validar si un string contiene solo números
    public static String validarSoloNumeros(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {
            System.out.println(mensaje);
            valorIngresado = entrada.nextLine().trim();
            if (valorIngresado.matches("\\d+")) {
                return valorIngresado;
            } else {
                System.out.println("Error!!! El texto solo puede contener números.");
            }
        }
    }

    // Método para validar un valor booleano ingresado por el usuario
    public static boolean validarBooleano(Scanner entrada, String mensaje) {
        String valorIngresado;
        while (true) {
            System.out.println(mensaje + " (true/false):");
            valorIngresado = entrada.nextLine().trim().toLowerCase();
            if (valorIngresado.equals("true")) {
                return true;
            } else if (valorIngresado.equals("false")) {
                return false;
            } else {
                System.out.println("Error!!! Debe responder 'true' o 'false'.");
            }
        }
    }

    // Método para validar una fecha ingresada por consola en un formato específico
    public static LocalDate validarFecha(Scanner entrada, String mensaje, String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        LocalDate fecha;

        while (true) {
            System.out.println(mensaje + " (formato " + formato + "):");
            String valorIngresado = entrada.nextLine().trim();
            try {
                fecha = LocalDate.parse(valorIngresado, formatter);
                return fecha;
            } catch (DateTimeParseException e) {
                System.out.println("Error!!! Debe ingresar una fecha válida en el formato " + formato + ".");
            }
        }
    }

    // Método para validar la entrada de un tiempo en formato HH:mm:ss
    public static LocalTime validarHora(Scanner entrada, String mensaje) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime hora;

        while (true) {
            System.out.println(mensaje + " (formato HH:mm:ss):");
            String valorIngresado = entrada.nextLine().trim();
            try {
                hora = LocalTime.parse(valorIngresado, formatter);
                return hora;
            } catch (DateTimeParseException e) {
                System.out.println("Error!!! Debe ingresar un valor válido en formato HH:mm:ss.");
            }
        }
    }
}