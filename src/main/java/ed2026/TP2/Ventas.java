import java.util.Scanner;

// Métodos de procesamiento de ventas.
public class Ventas {

    // Solicita y valida un número entero positivo.
    public static int leerEnteroPositivo(Scanner scanner,String mensaje) {
        int numero;

        do {
            System.out.print(mensaje);

            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.nextLine();
                System.out.print(mensaje);
            }

            numero = scanner.nextInt();
            scanner.nextLine();

            if (numero <= 0) {
                System.out.println( "Error: el número debe ser mayor que cero." );
            }

        } while (numero <= 0);

        return numero;
    }

    // Solicita y valida un monto no negativo y trabaja con double.
    public static double leerMontoNoNegativo(Scanner scanner,String mensaje) {
        double monto;

        do {
            System.out.print(mensaje);

            while (!scanner.hasNextDouble()) {
                System.out.println( "Error: debe ingresar un número.");
                scanner.nextLine();
                System.out.print(mensaje);
            }

            monto = scanner.nextDouble();
            scanner.nextLine();

            if (monto < 0) {
                System.out.println(
                        "Error: la venta no puede ser negativa."
                );
            }

        } while (monto < 0);

        return monto;
    }

    // Carga las ventas de cada vendedor por día.
    public static void cargarVentas(
            Scanner scanner,
            double[][] ventas
    ) {

        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            for (int dia = 0;
                 dia < ventas[vendedor].length;
                 dia++) {

                ventas[vendedor][dia] =
                        leerMontoNoNegativo(
                                scanner,
                                "Venta del vendedor "
                                        + (vendedor + 1)
                                        + ", día "
                                        + (dia + 1)
                                        + ": "
                        );
            }
        }
    }

    // Muestra el total vendido por cada vendedor.
    public static void mostrarTotalesPorVendedor(
            double[][] ventas
    ) {

        System.out.println(
                "\nTotal de ventas por vendedor:"
        );

        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            double total = 0;

            for (int dia = 0;
                 dia < ventas[vendedor].length;
                 dia++) {

                total += ventas[vendedor][dia];
            }

            System.out.println(
                    "Vendedor " + (vendedor + 1)
                            + ": $" + total
            );
        }
    }

    // Muestra el promedio de ventas por día.
    public static void mostrarPromediosPorDia(
            double[][] ventas
    ) {

        System.out.println(
                "\nPromedio de ventas por día:"
        );

        for (int dia = 0;
             dia < ventas[0].length;
             dia++) {

            double suma = 0;

            for (int vendedor = 0;
                 vendedor < ventas.length;
                 vendedor++) {

                suma += ventas[vendedor][dia];
            }

            double promedio = suma / ventas.length;

            System.out.println(
                    "Día " + (dia + 1)
                            + ": $" + promedio
            );
        }
    }

    // Busca y muestra la venta mayor y la menor.
    public static void mostrarVentaMayorYMenor(
            double[][] ventas
    ) {

        double ventaMayor = ventas[0][0];
        double ventaMenor = ventas[0][0];

        int vendedorMayor = 0;
        int diaMayor = 0;

        int vendedorMenor = 0;
        int diaMenor = 0;

        // Recorre toda la matriz.
        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            for (int dia = 0;
                 dia < ventas[vendedor].length;
                 dia++) {

                // Actualiza la venta máxima.
                if (ventas[vendedor][dia] > ventaMayor) {
                    ventaMayor = ventas[vendedor][dia];
                    vendedorMayor = vendedor;
                    diaMayor = dia;
                }

                // Actualiza la venta mínima.
                if (ventas[vendedor][dia] < ventaMenor) {
                    ventaMenor = ventas[vendedor][dia];
                    vendedorMenor = vendedor;
                    diaMenor = dia;
                }
            }
        }

        System.out.println(
                "\nVenta mayor: $" + ventaMayor
        );

        System.out.println(
                "Vendedor: " + (vendedorMayor + 1)
                        + " - Día: "
                        + (diaMayor + 1)
        );

        System.out.println(
                "\nVenta menor: $" + ventaMenor
        );

        System.out.println(
                "Vendedor: " + (vendedorMenor + 1)
                        + " - Día: "
                        + (diaMenor + 1)
        );
    }

    // Cuenta los vendedores que superan un objetivo.
    public static int contarVendedoresQueSuperanObjetivo(
            double[][] ventas,
            double objetivo
    ) {

        int contador = 0;

        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            double total = 0;

            for (int dia = 0;
                 dia < ventas[vendedor].length;
                 dia++) {

                total += ventas[vendedor][dia];
            }

            if (total > objetivo) {
                contador++;
            }
        }

        return contador;
    }

    // Solicita y valida un día dentro del rango.
    public static int leerDiaValido(
            Scanner scanner,
            int cantidadDias
    ) {

        int dia;

        do {
            System.out.print(
                    "\nIngrese un día entre 1 y "
                            + cantidadDias + ": "
            );

            while (!scanner.hasNextInt()) {
                System.out.println(
                        "Error: debe ingresar un número entero."
                );

                scanner.nextLine();

                System.out.print(
                        "\nIngrese un día entre 1 y "
                                + cantidadDias + ": "
                );
            }

            dia = scanner.nextInt();
            scanner.nextLine();

            if (dia < 1 || dia > cantidadDias) {
                System.out.println(
                        "Error: día fuera de rango."
                );
            }

        } while (dia < 1 || dia > cantidadDias);

        return dia;
    }

    // Cuenta las ventas superiores al promedio del día.
    public static int contarVentasSobrePromedioDelDia(
            double[][] ventas,
            int dia
    ) {

        double suma = 0;

        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            suma += ventas[vendedor][dia];
        }

        double promedio = suma / ventas.length;

        int contador = 0;

        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            if (ventas[vendedor][dia] > promedio) {
                contador++;
            }
        }

        return contador;
    }

    // Calcula el promedio de ventas de cada vendedor.
    public static double[] obtenerPromediosPorVendedor(
            double[][] ventas
    ) {

        double[] promedios =
                new double[ventas.length];

        for (int vendedor = 0;
             vendedor < ventas.length;
             vendedor++) {

            double suma = 0;

            for (int dia = 0;
                 dia < ventas[vendedor].length;
                 dia++) {

                suma += ventas[vendedor][dia];
            }

            promedios[vendedor] =
                    suma / ventas[vendedor].length;
        }

        return promedios;
    }
}