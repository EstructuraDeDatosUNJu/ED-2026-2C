package ed2026.TP2;
/*
* Crear un programa para la gestión de vuelos en un aeródromo. Solicitar la cantidad de vuelos a gestionar.
Para cada vuelo, el usuario debe ingresar un número de vuelo y su estado actual, el cual puede ser:
"Programado", "En Vuelo", "Cancelado" o "Aterrizado". Estos datos deben almacenarse en arreglos
paralelos (uno para el número y otro para el estado). El programa debe:a) Buscar un número de vuelo específico y, si lo encuentra, mostrar su estado actual y su posición en el
arreglo.
b) Obtener la cantidad de vuelos que se encuentran en un estado particular ingresado por el usuario.
c) Solicitar al usuario el ingreso de un estado y devolver un arreglo que contenga los números de los
vuelos que corresponden a ese estado.
d) Reorganizar los arreglos (intercambiando elementos) de manera que todos los vuelos "Cancelados" se
muevan al final del arreglo, manteniendo el orden relativo del resto. Mostrar los vuelos y sus estados
después de esta operación.
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
* */

import java.util.Scanner;

public class EJ2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidad_de_vuelos;
        //Base: Carga de vuelos

        do {
            System.out.println("Ingrese la cantidad de vuelos a cargar");

            while (!scanner.hasNextInt()) {
                System.out.println("Debes ingresar un numero entero");
                scanner.nextLine();
                System.out.println("Ingrese la cantidad de vuelos a cargar");
            }

            cantidad_de_vuelos = scanner.nextInt();
            scanner.nextLine();

            if (cantidad_de_vuelos <= 0) {
                System.out.println("Debes ingresar más de 0 vuelos");
            }

        } while (cantidad_de_vuelos <= 0);

        String[] numerosVuelo = new String[cantidad_de_vuelos];
        String[] estadosVuelo = new String[cantidad_de_vuelos];

        cargarVuelos(scanner,numerosVuelo,estadosVuelo);
        mostrarVuelos(numerosVuelo,estadosVuelo);
        //A) Buscar vuelo
        System.out.print("\nIngrese el número de vuelo que desea buscar: ");
        String vueloBuscado = scanner.nextLine();

        int posicion = buscarVuelo(numerosVuelo, vueloBuscado);

        if (posicion == -1) {
            System.out.println("El vuelo no fue encontrado.");
        } else {
            System.out.println("Vuelo encontrado en la posición " + (posicion + 1));
            System.out.println("Estado actual: " + estadosVuelo[posicion]);
        }

        //B) contar vuelos por estado

        String estadoBuscado;
        do{
            System.out.print(
                    "\nIngrese un estado para contar vuelos " +
                            "(Programado, En Vuelo, Cancelado o Aterrizado): "
            );
            estadoBuscado = scanner.nextLine();
            if(!esEstadoValido(estadoBuscado)){
                System.out.print("No es valido ");
            }
        }while(!esEstadoValido(estadoBuscado));
        int cantidadPorEstado = contarVuelosPorEstado(estadosVuelo, estadoBuscado);
        System.out.println("Cantidad de vuelos con estado \"" + estadoBuscado + "\": " +
                cantidadPorEstado
        );

        //C) devolver un arreglo con los números de vuelos que tengan un estado determinado.

        String estadoParaFiltrar;
        do {
            System.out.print(
                    "\nIngrese un estado para obtener sus vuelos " +
                            "(Programado, En Vuelo, Cancelado o Aterrizado): "
            );

            estadoParaFiltrar = scanner.nextLine();

            if (!esEstadoValido(estadoParaFiltrar)) {
                System.out.println("Estado inválido.");
            }

        } while (!esEstadoValido(estadoParaFiltrar));

        String[] vuelosFiltrados = obtenerVuelosPorEstado(
                numerosVuelo,
                estadosVuelo,
                estadoParaFiltrar
        );

        System.out.println("Vuelos en estado " + estadoParaFiltrar + ":");

        for (int i = 0; i < vuelosFiltrados.length; i++) {
            System.out.println(vuelosFiltrados[i]);
        }
        //D) Mover cancelados al final

        moverCanceladosAlFinal(numerosVuelo, estadosVuelo);

        System.out.println("\nVuelos luego de mover los cancelados al final:");
        mostrarVuelos(numerosVuelo, estadosVuelo);

        scanner.close();
    }


    public static void moverCanceladosAlFinal(String[] numerosVuelo, String[] estadosVuelo) {
        int ultimoNoCancelado = numerosVuelo.length - 1;

        for (int i = 0; i <= ultimoNoCancelado; i++) {
            if (estadosVuelo[i].equalsIgnoreCase("Cancelado")) {

                String numeroTemporal = numerosVuelo[i];
                String estadoTemporal = estadosVuelo[i];

                for (int j = i; j < ultimoNoCancelado; j++) {
                    numerosVuelo[j] = numerosVuelo[j + 1];
                    estadosVuelo[j] = estadosVuelo[j + 1];
                }

                numerosVuelo[ultimoNoCancelado] = numeroTemporal;
                estadosVuelo[ultimoNoCancelado] = estadoTemporal;

                ultimoNoCancelado--;

                i--;
            }
        }
    }

    public static String[] obtenerVuelosPorEstado(String[] numerosVuelo, String[] estadosVuelo, String estadoBuscado) {
        int cantidad = contarVuelosPorEstado(estadosVuelo, estadoBuscado);

        String[] vuelosEncontrados = new String[cantidad];

        int posicionResultado = 0;

        for (int i = 0; i < estadosVuelo.length; i++) {
            if (estadosVuelo[i].equalsIgnoreCase(estadoBuscado)) {
                vuelosEncontrados[posicionResultado] = numerosVuelo[i];
                posicionResultado++;
            }
        }

        return vuelosEncontrados;
    }

    public static int contarVuelosPorEstado(String[] estadosVuelo, String estadoBuscado) {
        int contador = 0;

        for (int i = 0; i < estadosVuelo.length; i++) {
            if (estadosVuelo[i].equalsIgnoreCase(estadoBuscado)) {
                contador++;
            }
        }
        return contador;
    }

    public static int buscarVuelo(
            String[] numerosVuelo,
            String vueloBuscado
    ) {
        for (int i = 0; i < numerosVuelo.length; i++) {
            if (numerosVuelo[i].equalsIgnoreCase(vueloBuscado)) {
                return i;
            }
        }

        return -1;
    }

    public static void mostrarVuelos(String[] numerosVuelo,String[] estadosVuelo){
        System.out.println("Vuelos ingresados:");
        for (int i = 0; i < numerosVuelo.length; i++) {
            System.out.println(
                    "Posición " + (i + 1) +
                            " - Vuelo: " + numerosVuelo[i] +
                            " - Estado: " + estadosVuelo[i]
            );
        }
    }

    public static void cargarVuelos(Scanner scanner, String[] numerosVuelo, String[] estadosVuelo
    ) {
        for (int i = 0; i < numerosVuelo.length; i++) {
            System.out.println("\nVuelo " + (i + 1));

            System.out.print("Ingrese el número de vuelo: ");
            numerosVuelo[i] = scanner.nextLine();

            do {
                System.out.print(
                        "Ingrese el estado (Programado, En Vuelo, Cancelado o Aterrizado): "
                );

                estadosVuelo[i] = scanner.nextLine();

                if (!esEstadoValido(estadosVuelo[i])) {
                    System.out.println("Estado inválido. Intente nuevamente.");
                }

            } while (!esEstadoValido(estadosVuelo[i]));
        }
    }

    public static boolean esEstadoValido(String estado){
        return estado.equalsIgnoreCase("Programado")
                ||estado.equalsIgnoreCase("En Vuelo")
                ||estado.equalsIgnoreCase("Cancelado")
                ||estado.equalsIgnoreCase("Aterrizado");
    }

}


/*
* Preguntas sobre el problema
a) ¿Por qué se utilizan arreglos paralelos en lugar de un solo arreglo? ¿Qué riesgo existe al reorganizar los
arreglos en el punto d) si nos olvidamos de actualizar uno de los dos arreglos?
*
* Se utilizan arreglos paralelos para separar los tipos de informacion que contienen y se sincronizan con el indice para no perder informacion
* El riesgo al reorganizar es perder esa relación. Si movés un número de vuelo pero no movés su estado en la misma
* posición, podrías mostrar un estado que pertenece a otro vuelo.
*
b) Comprobar el funcionamiento del programa en diferentes situaciones, es decir, cuando haya vuelos
"Cancelados" al principio, en el medio y al final. ¿Qué resultado espera obtener en el punto d)?
*
* Todos los vuelos cancelados quedaran al final
*
c) Si ahora se deseara agregar la fecha de salida a cada vuelo, ¿cómo se vería afectada la estructura de
arreglos paralelos? ¿Cree que existe otra forma de almacenar más datos sobre los vuelos y mantenerlos
en un solo arreglo?
*
*  Se agregaria un String[] fechasSalida = new String[cantidad_de_vuelos]; y personalmente importaria la libreria de LocalDate
*
d) En el punto c), el tamaño del arreglo a devolver no se conoce de antemano. ¿Cómo resolvería la
creación de este nuevo arreglo sabiendo que los arreglos estáticos no pueden cambiar de tamaño una
vez creados?
*
*   Contar cuántos vuelos tienen el estado solicitado.
    Crear el nuevo arreglo con esa cantidad exacta.
    Recorrer de nuevo y copiar los números de los vuelos coincidentes.
*
* */