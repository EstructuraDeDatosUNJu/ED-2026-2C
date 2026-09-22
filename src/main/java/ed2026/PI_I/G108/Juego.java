package ed2026.PI_I.G108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego {
    //Atributos
    private ColaMazo mazo; // TDA Cola propio sobre arreglo
    private Jugador[] jugadores; // Arreglo estático

    public Juego(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.mazo = new ColaMazo();
        inicializarMazo();
    }

    private void inicializarMazo() {
        List<Carta> listaCartas = new ArrayList<>();
        String[] palos = { "Trébol", "Corazón", "Diamante", "Pica" };

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                listaCartas.add(new Carta(palo, valor));
            }
        }

        Collections.shuffle(listaCartas);
        for (Carta c : listaCartas) {
            mazo.encolar(c);
        }
    }

    public void jugar() {
        int totalRondas = 3; // Simplificación a 3 rondas según el enunciado

        for (int ronda = 1; ronda <= totalRondas; ronda++) {
            System.out.println("\n-------------------------------------------");
            System.out.println("                RONDA " + ronda);
            System.out.println("-------------------------------------------");

            PilaCartas mesaRonda = new PilaCartas(); // TDA Pila propio sobre arreglo
            Carta[] cartasRonda = new Carta[jugadores.length];

            // 1. Cada jugador desencola un naipe y se apila en la mesa
            for (int i = 0; i < jugadores.length; i++) {
                Carta cartaExtraida = mazo.desencolar();
                cartaExtraida.setDisponible(false);
                cartasRonda[i] = cartaExtraida;

                mesaRonda.apilar(cartaExtraida); // Apilar en la mesa de la ronda
                System.out.println(jugadores[i].getNombre() + " robó: " + cartaExtraida);
            }

            // 2. Determinar valor máximo
            int valorMaximo = -1;
            for (Carta c : cartasRonda) {
                if (c.getValor() > valorMaximo) {
                    valorMaximo = c.getValor();
                }
            }

            // 3. Evaluar empates
            int empates = 0;
            for (Carta c : cartasRonda) {
                if (c.getValor() == valorMaximo) {
                    empates++;
                }
            }

            // 4. Asignar puntajes
            if (empates > 1) {
                System.out.println("\n-> ¡EMPATE en la ronda! Cada jugador conserva su propia carta.");
                for (int i = 0; i < jugadores.length; i++) {
                    jugadores[i].sumarPuntaje(cartasRonda[i].getValor());
                }
            } else {
                int indexGanador = -1;
                int sumaRonda = 0;
                for (int i = 0; i < jugadores.length; i++) {
                    sumaRonda += cartasRonda[i].getValor();
                    if (cartasRonda[i].getValor() == valorMaximo) {
                        indexGanador = i;
                    }
                }
                jugadores[indexGanador].sumarPuntaje(sumaRonda);
                System.out.println("\n-> ¡" + jugadores[indexGanador].getNombre() + " gana la ronda! Se lleva "
                        + sumaRonda + " puntos.");
            }
        }

        determinarGanadorFinal();
    }

    private void determinarGanadorFinal() {
        System.out.println("\n-------------------------------------------");
        System.out.println("             RESULTADOS FINALES          ");
        System.out.println("-------------------------------------------");

        int maxPuntaje = -1;
        for (Jugador j : jugadores) {
            System.out.println(j);
            if (j.getPuntaje() > maxPuntaje) {
                maxPuntaje = j.getPuntaje();
            }
        }

        System.out.println("\n--- GANADOR(ES) DEL JUEGO ---");
        for (Jugador j : jugadores) {
            if (j.getPuntaje() == maxPuntaje) {
                System.out.println("🏆 ¡" + j.getNombre() + " " + j.getApellido() + " con " + maxPuntaje + " puntos!");
            }
        }
    }
}
