package ed2026.PI_I.G510;

import java.util.Scanner;

public class Juego {
    private Mazo mazo;
    private Jugador[] jugadores;
    private int rondasTotales;
    private boolean juegoIniciado = false; // Estado inicial

    // Getter para consultar si el juego inicio
    public boolean isJuegoIniciado() {
        return this.juegoIniciado;
    }

    // Getters y setters
    public int getRondasTotales() {
        return rondasTotales;
    }

    public void setRondasTotales(int rondasTotales) {
        this.rondasTotales = rondasTotales;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }

    // Constructor del juego
    public Juego(int rondasTotales, Scanner scanner) {
        this.rondasTotales = Math.min(rondasTotales, 13);
        this.mazo = new Mazo();
        cargarJugadoresManualmente(scanner);
    }

    // Metodo para cargar jugadores manualmente
    private void cargarJugadoresManualmente(Scanner scanner) {
        jugadores = new Jugador[4];
        System.out.println("\n--- REGISTRO DE LOS 4 JUGADORES ---");

        for (int i = 0; i < 4; i++) {
            System.out.println("\nIngrese los datos del Jugador " + (i + 1) + ":");
            String nombre = EntradaValida.leerTexto(scanner, "Ingrese el nombre: ");
            String apellido = EntradaValida.leerTexto(scanner, "Ingrese el apellido: ");
            int edad = EntradaValida.leerEnteroPositivo(scanner, "Ingrese la edad: ");

            jugadores[i] = new Jugador(nombre, apellido, edad);
        }
    }

    // Metodo para mostrar la lista de jugadores
    public void mostrarJugador() {
        System.out.println("\n=== LISTA DE JUGADORES ===");
        for (Jugador j : jugadores) {
            if (j != null) {
                System.out.println(" - " + j.getNombreCompleto() + " (Edad: " + j.getEdad() + ") | Puntaje actual: "
                        + j.getPuntaje() + " pts");
            }
        }
    }

    // Metodo para levantar una carta del mazo
    public Carta levantarCarta() {
        if (mazo != null && !mazo.esVacio()) {
            return mazo.levantarCarta();
        }
        return null;
    }

    // Metodo principal para iniciar el juego
    public void iniciarJuego() {
        this.juegoIniciado = true;
        System.out.println("\n=== INICIO DEL JUEGO ===");

        for (int ronda = 1; ronda <= rondasTotales; ronda++) {
            if (mazo.esVacio()) {
                System.out.println("\n¡El mazo se ha quedado sin cartas! El juego finaliza antes de tiempo.");
                break;
            }

            System.out.println("\n--- Ronda N° " + ronda + " ---");

            int valorMaximo = -1;

            // Usamos Cola propia para determinar el orden de los jugadores en la ronda
            Cola<Jugador> ordenRonda = new Cola<>();
            int indiceInicio = (ronda - 1) % jugadores.length;
            for (int i = 0; i < jugadores.length; i++) {
                ordenRonda.encolar(jugadores[(indiceInicio + i) % jugadores.length]);
            }

            // Colas auxiliares para almacenar el turno de la ronda
            Cola<Carta> cartasEnRonda = new Cola<>();
            Cola<Jugador> jugadoresEnRonda = new Cola<>();

            while (!ordenRonda.esVacia()) {
                Jugador jugador = ordenRonda.desencolar();
                Carta cartaJugada = levantarCarta();

                if (cartaJugada != null) {
                    System.out.println(jugador.getNombreCompleto() + " levantó: " + cartaJugada);

                    cartasEnRonda.encolar(cartaJugada);
                    jugadoresEnRonda.encolar(jugador);

                    if (cartaJugada.getValorCarta() > valorMaximo) {
                        valorMaximo = cartaJugada.getValorCarta();
                    }
                }
            }

            if (cartasEnRonda.esVacia()) {
                break;
            }

            // Pasada auxiliar para contar cuantas cartas alcanzaron el valor máximo
            int contadorMaximos = 0;
            Cola<Carta> auxCartas = new Cola<>();

            while (!cartasEnRonda.esVacia()) {
                Carta c = cartasEnRonda.desencolar();
                if (c.getValorCarta() == valorMaximo) {
                    contadorMaximos++;
                }
                auxCartas.encolar(c);
            }

            // Caso 1: Hay un unico ganador de ronda
            if (contadorMaximos == 1) {
                Jugador ganadorRonda = null;

                // Buscamos quién fue el jugador que levanto el valor maximo
                Cola<Jugador> auxJugadores = new Cola<>();
                while (!jugadoresEnRonda.esVacia()) {
                    Jugador j = jugadoresEnRonda.desencolar();
                    Carta c = auxCartas.desencolar();

                    if (c.getValorCarta() == valorMaximo && ganadorRonda == null) {
                        ganadorRonda = j;
                    }

                    auxJugadores.encolar(j);
                    cartasEnRonda.encolar(c); // Recomponemos cartasEnRonda
                }

                // El ganador se lleva todas las cartas acumuladas en la ronda
                while (!cartasEnRonda.esVacia()) {
                    ganadorRonda.agregarCartaGanada(cartasEnRonda.desencolar());
                }

                System.out.println(
                        "¡" + ganadorRonda.getNombreCompleto() + " gana la ronda y se lleva todas las cartas! ");

            } else {
                // Caso 2: Empate en la ronda -> Cada jugador conserva la carta que levanto
                System.out.println(
                        "¡Empate en esta ronda (valor maximo: " + valorMaximo + ")! Cada jugador conserva su carta.");

                while (!jugadoresEnRonda.esVacia() && !auxCartas.esVacia()) {
                    Jugador jugador = jugadoresEnRonda.desencolar();
                    Carta cartaPropia = auxCartas.desencolar();

                    jugador.agregarCartaGanada(cartaPropia);
                    System.out.println("   - " + jugador.getNombreCompleto() + " conserva su " + cartaPropia);
                }
            }
        }

        mostrarResultadoFinal();
    }

    // Metodo para mostrar el resultado final del juego
    public void mostrarResultadoFinal() {
        System.out.println("\n=== RESULTADO FINAL DEL JUEGO ===");

        if (jugadores == null || jugadores.length == 0) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        int puntajeMaximo = -1;
        for (Jugador jugador : jugadores) {
            if (jugador != null) {
                System.out.println(jugador);
                if (jugador.getPuntaje() > puntajeMaximo) {
                    puntajeMaximo = jugador.getPuntaje();
                }
            }
        }

        // Contamos cuantos ganadores hay para dimensionar el arreglo
        int cantidadGanadores = 0;
        for (Jugador jugador : jugadores) {
            if (jugador != null && jugador.getPuntaje() == puntajeMaximo) {
                cantidadGanadores++;
            }
        }

        Jugador[] ganadoresJuego = new Jugador[cantidadGanadores];
        int idx = 0;
        for (Jugador jugador : jugadores) {
            if (jugador != null && jugador.getPuntaje() == puntajeMaximo) {
                ganadoresJuego[idx++] = jugador;
            }
        }

        System.out.println("\n=================================");
        if (ganadoresJuego.length == 1) {
            System.out.println("¡EL GANADOR DEL JUEGO ES: " + ganadoresJuego[0].getNombreCompleto() + " con "
                    + puntajeMaximo + " puntos!-- FELICIDADES ");
        } else if (ganadoresJuego.length > 1) {
            System.out.println("¡EMPATE FINAL EN EL JUEGO! Los ganadores con " + puntajeMaximo + " puntos son:");
            for (Jugador g : ganadoresJuego) {
                System.out.println("   - " + g.getNombreCompleto());
            }
        } else {
            System.out.println("No se pudo determinar un ganador");
        }
        System.out.println("========================");

    }

    // Metodo para reiniciar el juego
    public void reiniciarJuego() {
        this.mazo = new Mazo();
        for (Jugador jugador : jugadores) {
            if (jugador != null) {
                jugador.reiniciarPuntaje();
            }
        }
        this.juegoIniciado = false; // Reiniciamos el estado del juego
    }
}