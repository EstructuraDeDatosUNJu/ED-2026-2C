package ed2026.PI_I.G102;

import java.util.Random;

public class Juego {
    private Jugador[] jugadores; // Arreglo de jugadores
    private Pila<Carta> mazo; // Pila de cartas
    private static final int NUM_JUGADORES = 4;
    private static final int NUM_RONDAS = 3;

    public Juego() {
        jugadores = new Jugador[NUM_JUGADORES];
        mazo = new Pila<>();
        inicializarJugadores();
        inicializarMazo();
        mezclar();
    }

    private void inicializarJugadores() {
        jugadores[0] = new Jugador("Gabriel", "Armella", 22);
        jugadores[1] = new Jugador("Enzo", "Cancino", 22);
        jugadores[2] = new Jugador("Tomas", "Burgos", 21);
        jugadores[3] = new Jugador("Leandro", "Ruiz", 21);
    }

    private void inicializarMazo() {
        String[] palos = { "Trebol", "Corazón", "Diamante", "Pica" };
        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                mazo.apilar(new Carta(palo, valor));
            }
        }
    }

    private void mezclar() {
        // Convertir pila a lista, mezclar y volver a apilar
        java.util.List<Carta> cartas = new java.util.ArrayList<>();
        while (!mazo.esVacia()) {
            cartas.add(mazo.desapilar());
        }
        java.util.Collections.shuffle(cartas, new Random());
        for (Carta c : cartas) {
            mazo.apilar(c);
        }
    }

    public void jugar() {
        System.out.println("=== INICIO DEL JUEGO ===");
        for (int ronda = 1; ronda <= NUM_RONDAS; ronda++) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            jugarRonda();
        }
        mostrarResultados();
    }

    private void jugarRonda() {
        Carta[] cartasRonda = new Carta[NUM_JUGADORES];
        int maxValor = -1;

        // Cada jugador toma una carta del mazo (pila)
        for (int i = 0; i < NUM_JUGADORES; i++) {
            if (mazo.esVacia()) {
                System.out.println("El mazo se ha agotado.");
                return;
            }
            cartasRonda[i] = mazo.desapilar();
            System.out.println(jugadores[i].getNombreCompleto() + " saca: " + cartasRonda[i]);
            if (cartasRonda[i].getValor() > maxValor) {
                maxValor = cartasRonda[i].getValor();
            }
        }

        // Contar cuántos tienen el valor máximo (empate)
        int ganadores = 0;
        for (Carta c : cartasRonda) {
            if (c.getValor() == maxValor)
                ganadores++;
        }

        if (ganadores > 1) {
            System.out.println("¡Empate! Cada jugador conserva su carta.");
            for (int i = 0; i < NUM_JUGADORES; i++) {
                if (cartasRonda[i].getValor() == maxValor) {
                    jugadores[i].agregarCartaGanada(cartasRonda[i]);
                }
            }
        } else {
            // Un solo ganador se lleva todas las cartas
            for (int i = 0; i < NUM_JUGADORES; i++) {
                if (cartasRonda[i].getValor() == maxValor) {
                    System.out.println("¡" + jugadores[i].getNombreCompleto() + " gana la ronda!");
                    for (int j = 0; j < NUM_JUGADORES; j++) {
                        jugadores[i].agregarCartaGanada(cartasRonda[j]);
                    }
                }
            }
        }
    }

    private void mostrarResultados() {
        System.out.println("\n=== RESULTADOS FINALES ===");
        int maxPuntaje = -1;
        for (Jugador j : jugadores) {
            System.out.println(j);
            if (j.getPuntaje() > maxPuntaje)
                maxPuntaje = j.getPuntaje();
        }
        System.out.println("\nGanador(es):");
        for (Jugador j : jugadores) {
            if (j.getPuntaje() == maxPuntaje) {
                System.out.println("  - " + j.getNombreCompleto() + " con " + j.getPuntaje() + " puntos");
            }
        }
    }
}
