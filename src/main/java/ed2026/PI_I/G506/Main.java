package ed2026.PI_I.G506;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO JUEGO DE CARTAS ---");

        // 1. Inicialización de Jugadores (Arreglo)
        Jugador[] jugadores = new Jugador[4];
        jugadores[0] = new Jugador("Ana", "Perez", 25);
        jugadores[1] = new Jugador("Luis", "Gomez", 30);
        jugadores[2] = new Jugador("María", "López", 22);
        jugadores[3] = new Jugador("Carlos", "Diaz", 28);

        // 2. Creacion y mezcla del mazo
        String[] palos = { "Trebol", "Pica", "Corazones", "Diamantes" };
        Carta[] mazoInicial = new Carta[52];
        int indice = 0;

        for (String palo : palos) {
            for (int valor = 1; valor <= 13; valor++) {
                mazoInicial[indice++] = new Carta(palo, valor);
            }
        }

        Random rand = new Random();
        for (int i = 0; i < mazoInicial.length; i++) {
            int swapIndex = rand.nextInt(52);
            Carta temp = mazoInicial[i];
            mazoInicial[i] = mazoInicial[swapIndex];
            mazoInicial[swapIndex] = temp;
        }

        Pila mazo = new Pila();
        for (Carta c : mazoInicial) {
            mazo.apilar(c);
        }

        // 3. Jugar rondas llamando al modulo externo
        int ronda = 1;
        while (!mazo.estaVacia() && ronda <= 13) {
            MotorJuego.jugarRonda(mazo, jugadores, ronda);
            ronda++;
        }

        // 4. Calcular ganador final
        System.out.println("\n - RESULTADOS FINALES -");
        int puntajeMaximo = -1;
        String nombresGanadores = "";

        for (int i = 0; i < 4; i++) {
            int puntaje = jugadores[i].calcularPuntajeFinal();
            System.out.println(jugadores[i].getNombreCompleto() + " - Puntaje: " + puntaje);

            if (puntaje > puntajeMaximo) {
                puntajeMaximo = puntaje;
                nombresGanadores = jugadores[i].getNombreCompleto();
            } else if (puntaje == puntajeMaximo) {
                nombresGanadores += " y " + jugadores[i].getNombreCompleto();
            }
        }

        System.out.println("\n ¡GANADOR(ES): " + nombresGanadores + " con " + puntajeMaximo + " puntos! ");
    }
}