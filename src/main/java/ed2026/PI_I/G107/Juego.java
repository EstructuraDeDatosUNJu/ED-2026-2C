package ed2026.PI_I.G107;

import java.util.Scanner;

public class Juego {

    public static void cargarJugadores(Queue<Persona> cola, Scanner sc) {

        while (cola.size() < 4) {

            String nombre = Helper.leerCadena(sc, "Ingrese nombre: ");
            String apellido = Helper.leerCadena(sc, "Ingrese apellido: ");
            int edad = Helper.leerEnteroPositivo(sc, "Ingrese edad: ");

            Persona persona = new Persona(nombre, apellido, edad, null);

            cola.add(persona);
        }
    }

    //repartir cartas
    public static void repartirCartas(Queue<Persona> cola, Mazo mazo) {

        int contador = 0;

        while (contador < 4) {

            System.out.println("---- SE PROCEDE A SACAR CARTA ----");

            Persona persona = cola.pool();

            Carta carta = mazo.sacarCarta();

            persona.setCarta(carta);

            cola.add(persona);

            contador++;
        }
    }

    //buscar Maximo
    public static int buscarMaximo(Queue<Persona> cola) {

        Persona persona = cola.peek();

        int maximo = persona.getCarta().getValor();

        int contador = 0;

        while (contador < 4) {
            Persona x = cola.pool();
            int valor = x.getCarta().getValor();

            if (valor > maximo) {
                maximo = valor;
            }
            cola.add(x);
            contador++;
        }

        return maximo;
    }

    //Contar Maximos
    public static int contarMaximos(Queue<Persona> cola, int maximo) {
        int cantidadMaximos = 0;
        int contador = 0;
        while (contador < 4) {
            Persona persona = cola.pool();
            if (persona.getCarta().getValor() == maximo) {
                cantidadMaximos++;
            }
            cola.add(persona);
            contador++;
        }
        return cantidadMaximos;
    }

    public static void repartirCartasGanadas(Queue<Persona> cola, int maximo, int cantidadMaximos) {
        if (cantidadMaximos > 1) {
            System.out.println("Hay empate. Cada jugador conserva su carta.");
            int contador = 0;
            while (contador < 4) {
                Persona persona = cola.pool();
                persona.agregarCartaGanada(persona.getCarta());
                persona.setCarta(null);
                cola.add(persona);
                contador++;
            }

        } else {

            Persona personaMaximo = null;
            int contador = 0;
            while (contador < 4) {
                Persona persona = cola.pool();
                if (persona.getCarta().getValor() == maximo) {
                    personaMaximo = persona;
                }
                cola.add(persona);
                contador++;
            }

            System.out.println("Ganador de la ronda: " + personaMaximo.getNombre() + " " + personaMaximo.getApellido());
            contador = 0;
            while (contador < 4) {
                Persona persona = cola.pool();
                personaMaximo.agregarCartaGanada(persona.getCarta());
                persona.setCarta(null);
                cola.add(persona);
                contador++;
            }
        }
    }

    public static void mostrarPuntajes(Queue<Persona> cola) {
        System.out.println();
        System.out.println("----- PUNTAJES FINALES -----");

        int contador = 0;
        int ganadores = 0;
        int mayorPuntaje = -1;

        while (contador < 4) {

            Persona persona = cola.pool();

            int puntaje = persona.calcularPuntaje();

            System.out.println(persona.getNombre() + " " + persona.getApellido() + ": " + puntaje);

            if (puntaje > mayorPuntaje) {
                mayorPuntaje = puntaje;
            }

            cola.add(persona);

            contador++;
        }

        System.out.println();
        System.out.println("----- GANADOR DEL JUEGO -----");

        contador = 0;

        while (contador < 4) {
            Persona persona = cola.pool();
            if (persona.calcularPuntaje() == mayorPuntaje && ganadores == 0) {
                System.out.println(
                        persona.getNombre() + " " + persona.getApellido() + " con " + mayorPuntaje + " puntos.");
                ganadores++;
            }
            cola.add(persona);
            contador++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Persona> Colapersonas = new Queue<>(4);

        Mazo mazo = new Mazo();

        mazo.crearMazo();
        mazo.mezclarMazo();
        mazo.conversionPilaMazo();

        System.out.println("----- JUEGO DE CARTAS -----");

        System.out.println();
        System.out.println("AGREGUE JUGADORES");

        cargarJugadores(Colapersonas, sc);

        int ronda = 0;

        while (ronda < 3) {

            System.out.println();
            System.out.println("----- RONDA " + (ronda + 1) + " -----");

            repartirCartas(Colapersonas, mazo);

            System.out.println("---- SE PROCEDE A COMPARAR CARTAS ----");

            int maximo = buscarMaximo(Colapersonas);

            System.out.println("Valor máximo: " + maximo);

            int cantidadMaximos = contarMaximos(Colapersonas, maximo);

            repartirCartasGanadas(Colapersonas, maximo, cantidadMaximos);
            ronda++;
        }
        mostrarPuntajes(Colapersonas);
    }
}