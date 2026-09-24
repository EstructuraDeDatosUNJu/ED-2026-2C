package ed2026.PI_I.G509;

import java.util.List;

public class Turno {
    private Queue<Jugador> ordenTurno = new Queue<>(4);

    public Turno(Queue<Jugador> ordenTurno) {
        this.ordenTurno = ordenTurno;
    }

    public Jugador pasarTurno() {
        Jugador jugadorActual = this.ordenTurno.dequeue();
        System.out.println("Es el turno de: " + jugadorActual.getNombreApellido());
        this.ordenTurno.enqueue(jugadorActual);
        return jugadorActual;
    }

    public Jugador compararCartas(List<Jugador> jugadores) {
        if (jugadores == null || jugadores.isEmpty()) {
            throw new IllegalArgumentException("La lista de jugadores no puede estar vacía.");
        }

        Jugador jugadorGanador = null;
        int maxValor = -1;
        boolean hayEmpateEnMaximo = false;

        for (Jugador j : jugadores) {
            if (j.getCartaActual() == null) {
                throw new IllegalArgumentException("El jugador " + j.getNombreApellido() + " no tiene carta asignada.");
            }
            int valorCarta = j.getCartaActual().getValor();

            if (valorCarta > maxValor) {
                maxValor = valorCarta;
                jugadorGanador = j;
                hayEmpateEnMaximo = false;
            } else if (valorCarta == maxValor) {
                hayEmpateEnMaximo = true;
            }
        }

        if (hayEmpateEnMaximo) {
            jugadorGanador = null;
        }

        entregarCartas(jugadorGanador, jugadores);
        return jugadorGanador;
    }

    public void entregarCartas(Jugador ganador, List<Jugador> jugadores) {
        if (ganador == null) {

            for (Jugador j : jugadores) {
                j.agregarCarta(j.getCartaActual());
            }
        } else {

            for (Jugador j : jugadores) {
                ganador.agregarCarta(j.getCartaActual());
            }
        }
    }
}
