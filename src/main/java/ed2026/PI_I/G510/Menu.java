package ed2026.PI_I.G510;

/**
 * PROYECTO INTEGRADOR I - Ciclo 2026
 *
 * @author: Grupo 5.10
 *          _Peñaranda, Pablo Adrian
 *          _Ramos, Ana Laura Esmeralda
 *          _Ramos, Evelyn Nahila
 *          _Rios, Mauro Matias Facundo
 *          _Sajama, Claribel Ayelen
 *
 * @version: 1.0
 * 
 *           Caso de Estudio:
 *           Juego de cartas Cuatro jugadores se enfrentan en un juego de cartas, el cual consiste
 *           en varias rondas en las que cada jugador
 *           toma un naipe de un mazo de cartas francesas (trébol, pica, corazones y diamantes)
 *           ordenadas al azar; luego,
 *           los jugadores comparan sus cartas (solo las de la ronda actual) y el que resulte con la
 *           carta de mayor valor
 *           numérico les quita a los demás las suyas y las conserva. En el caso en el que más de un
 *           jugador tenga una carta
 *           con el mismo valor máximo (empate), cada jugador conserva su carta. Las rondas se
 *           repiten hasta que los
 *           naipes del mazo se acaban (*).
 *           Al finalizar, cada jugador obtiene su puntaje de competencia sumando el valor de las
 *           cartas que obtuvo a lo
 *           largo de las rondas efectuadas. El jugador con mayor puntaje se convierte en el ganador
 *           del juego; puede haber empates.
 *           Por cada naipe o carta se debe conocer la siguiente información: palo (trébol, corazón,
 *           diamante o pica), valor
 *           (1 a 13) y estado (disponible o no disponible).
 *           Por cada jugador se debe conocer la siguiente información: nombre, apellido y edad.
 *           (*) Nota: a los fines de simplificar el juego, el mismo puede finalizar tras jugar tres
 *           rondas.
 */

import java.util.Scanner;

public class Menu {

   public Menu() {
   }

   public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
      Juego juego = null;
      int opcionPrincipal = 0; // Variable para controlar la opcion del menu principal
      int repetirPartida = 0; // Variable para controlar la repeticion de la partida

      while (opcionPrincipal != 3) {
         System.out.println("\n=================================" +
               "\n    EL JUEGO DE CARTAS G.510     " +
               "\n=================================" +
               "\n1. Cargar Jugadores y Rondas" +
               "\n2. Menu de Partida" +
               "\n3. Salir");

         opcionPrincipal = EntradaValida.leerEntero(entrada, "Ingrese su opcion: ");

         if (opcionPrincipal == 1) {
            System.out.println("\n--- CONFIGURACIÓN DEL JUEGO ---");

            int rondas = 0;

            // Validar que la cantidad de rondas ingresada este entre 1 y 13
            while (rondas < 1 || rondas > 13) {
               rondas = EntradaValida.leerEntero(entrada,
                     "Ingrese la cantidad de rondas totales a jugar (máximo 13): ");
               if (rondas < 1 || rondas > 13) {
                  System.out.println("Numero de rondas inválido. Debe estar entre 1 y 13.");
               } else {
                  System.out.println("cantidad de rondas validas: " + rondas);
               }
            }
            // Crear una instancia de Juego con la cantidad de rondas y el objeto Scanner   
            juego = new Juego(rondas, entrada);

            System.out.println("\nJugadores cargados y mazo listo para comenzar la partida!" +
                  "\nCantidad de rondas a jugar: " + rondas +
                  "\nlos jugadores son: ");
            juego.mostrarJugador();

            System.out.println(
                  "--------------------------------------------------------------------------------------------" +
                        "\n                           -Las reglas son las siguientes-" +
                        "\n   Cada jugador levanta una carta, el que tenga la carta de mayor valor gana la ronda" +
                        "\n   y se lleva todas las cartas jugadas. En caso de empate, cada jugador conserva su carta." +
                        "\n            Al final del juego, el jugador con más puntos es el ganador." +
                        "\n-----------------------------------------------------------------------------------------");
         } else if (opcionPrincipal == 2) {

            if (juego == null) { // verifica que los datos de los jugadores y rondas hayan sido cargados antes de entrar al submenu
               System.out.println("ATENCION! Debe cargar los jugadores y rondas primero (Opcion 1)");
            } else {
               int opcionSubmenu = 0;

               while (opcionSubmenu != 4) {
                  System.out.println("\n--- MENU DE PARTIDA ---" +
                        "\n1. Mostrar Jugadores" +
                        "\n2. Mostrar Puntajes" +
                        "\n3. Iniciar Juego" +
                        "\n4. Volver al Menu Principal");

                  opcionSubmenu = EntradaValida.leerEntero(entrada, "Ingrese su opcion: ");
                  if (opcionSubmenu == 1) {
                     juego.mostrarJugador();
                  } else if (opcionSubmenu == 2) {
                     System.out.println("\n=== PUNTAJES ACTUALES ===");
                     if (!juego.isJuegoIniciado()) {
                        System.out.println("Aun no se han jugado rondas. Los puntajes estan en cero.");
                     } else {
                        juego.mostrarResultadoFinal();
                     }
                  }

                  else if (opcionSubmenu == 3) {

                     juego.iniciarJuego();
                     repetirPartida = +1;

                     // Preguntar al usuario si desea repetir la partida con los mismos jugadores y rondas
                     while (repetirPartida == 1) {
                        System.out.println("\nDesea repetir la partida con los mismos jugadores y rondas?" +
                              "\n1) Si" +
                              "\n2) No, volver al menu principal" +
                              "\n3) Salir y conservar los resultados de la partida actual");
                        repetirPartida = EntradaValida.leerEntero(entrada, "Ingrese su opcion: ");
                        if (repetirPartida == 1) {
                           juego.reiniciarJuego();
                           juego.iniciarJuego();
                        } else if (repetirPartida == 2) {
                           System.out.println("__Volviendo al menu principal...");
                           juego.reiniciarJuego();
                        } else if (repetirPartida == 3) {
                           System.out.println(
                                 "__¡Gracias por jugar! volviendo al menu principal y conservando los resultados de la partida actual...");

                           repetirPartida = 2; // fuerza a salir del bucle
                        } else {
                           System.out.println("__Opcion invalida, volviendo al menu principal...");
                           repetirPartida = 2; // fuerza a salir del bucle

                        }
                     }

                  } else if (opcionSubmenu == 4) {
                     System.out.println("Volviendo al menu principal...");
                  } else {
                     System.out.println("Opcion invalida en el submenu");
                  }
               }
            }
         } else if (opcionPrincipal == 3) {
            System.out.println("\n¡Gracias por jugar! Saliendo del sistema...");
         }
      }
      entrada.close();
   }
}