package ed2026.TP1;

import java.time.LocalDate; //conseguir fecha
import java.time.DateTimeException; //evita fechas erroneas 31 de feb por ej
import java.util.Scanner; //ingresar texto


public class TP1_03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("--- RESERVA 1 ---");
        String codigo1 = pedirTexto(teclado, "Codigo de reserva: ");
        Reserva reserva1 = cargarReserva(teclado, codigo1);

        System.out.println("\n--- RESERVA 2 ---");
        String codigo2;
        do {
            codigo2 = pedirTexto(teclado, "Codigo de reserva: ");
            if (codigo2.equals(codigo1)) {
                System.out.println("Ese codigo ya existe. Ingrese otro.");
            }
        } while (codigo2.equals(codigo1));
        Reserva reserva2 = cargarReserva(teclado, codigo2);

        System.out.println("\n--- FECHA DE CONSULTA ---");
        LocalDate fechaConsulta = pedirFecha(teclado);

        mostrarDatos(reserva1, fechaConsulta, teclado);
        mostrarDatos(reserva2, fechaConsulta, teclado);
        teclado.close();
    }
    public static Reserva cargarReserva(Scanner teclado, String codigo) {
        String nombre = pedirTexto(teclado, "Nombre del huesped: ");

        System.out.println("Fecha de check-in:");
        LocalDate checkIn = pedirFecha(teclado);
        System.out.println("Fecha de check-out:");
        LocalDate checkOut = pedirFecha(teclado);

        if (!checkIn.isBefore(checkOut)) {
            System.out.println("Fechas incorrectas. Se usaran las fechas por defecto.");
        }
        return new Reserva(codigo, nombre, checkIn, checkOut);
    }

    // Pide una fecha hasta que se ingrese una que exista
    public static LocalDate pedirFecha(Scanner teclado) {
        while (true) {
            try {
                System.out.print("Dia: ");
                int dia = Integer.parseInt(teclado.nextLine());
                System.out.print("Mes: ");
                int mes = Integer.parseInt(teclado.nextLine());
                System.out.print("Año: ");
                int anio = Integer.parseInt(teclado.nextLine());
                return LocalDate.of(anio, mes, dia);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar numeros enteros.");
            } catch (DateTimeException e) {
                System.out.println("La fecha no existe.");
            }
        }
    }
    // funcion para ingresar texto
    public static String pedirTexto(Scanner teclado, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = teclado.nextLine();
            if (texto.equals("")) {
                System.out.println("El dato no puede estar vacio.");
            }
        } while (texto.equals(""));
        return texto;
    }

    public static void mostrarDatos(Reserva reserva, LocalDate fechaConsulta, Scanner teclado) {
        System.out.println("\n-----------------------");
        System.out.println(reserva);
        System.out.println("Esta activa: " + reserva.estaActiva(fechaConsulta));
        System.out.println("Dias restantes o transcurridos: "
                + reserva.calcularDiasRestantesOTranscurridos(fechaConsulta));

        int diasProrroga;
        do {
            diasProrroga = pedirEntero(teclado, "Dias para simular una prorroga: ");
            if (diasProrroga < 0) {
                System.out.println("No se puede ingresar un numero negativo.");
            }
        } while (diasProrroga < 0);

        System.out.println("Nuevo check-out: " + reserva.simularProrroga(diasProrroga));
    }

    public static int pedirEntero(Scanner teclado, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero.");
            }
        }
    }

}

/*
* Preguntas sobre el problema
a) ¿Por qué se pide que la validación de fechas sea un "método auxiliar" dentro de la clase Reserva? ¿Qué
ocurriría si esa validación se hiciera en el método main antes de llamar al constructor?
b) ¿Qué sucede si el usuario ingresa la misma fecha para check-in y check-out? Según la regla del inciso (e)
¿qué debería ocurrir con el objeto?
c) Si una reserva tiene fechaCheckIn = 2025-05-01 y fechaCheckOut = 2025-05-05, y el usuario ingresa
fechaConsulta = 2025-05-03. Sin ejecutar el programa: ¿El método estaActiva retorna true o false?
¿Qué valor exacto retorna calcularDiasRestantesOTranscurridos?
d) Un compañero escribe el método simularProrroga de la siguiente manera:
return this.fechaCheckOut.plusDays(cantidadDias);
¿Esta línea constituye un error de lógica respecto al principio de encapsulamiento o inmutabilidad?
¿Modifica el estado real del objeto o solo devuelve un cálculo? Argumente si esto cumple con lo
solicitado en el inciso (h).
*
*a) Para asegurar el encapsulamiento. La clase Reserva debe garatizar por sí misma que sus datos sean válidos.
Si se hiciera en el main: Cuestión de seguridad y reusabilidad. Cualquier otra parte del sistema
* podría instanciar reservas con fechas inválidas o incoherentes, duplicando código de validación.
*b)El objeto no debe crearse (o debe lanzar una excepción). Una reserva exige al menos 1 noche de estadía
* c) No. plusDays genera una fecha nueva sin alterar el atributo del objeto (LocalDate es inmutable).
Al ser una simulación, solo debe calcular e informar la nueva fecha hipotética sin modificar la reserva real.
* */