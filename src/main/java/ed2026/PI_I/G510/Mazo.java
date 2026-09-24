package ed2026.PI_I.G510;

// para podes usar Collections.shuffle.
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    // Atributo que representa la pila de cartas del mazo
    private Pila<Carta> pilaDeCartas;

    public Mazo() {
        this.pilaDeCartas = new Pila<>();
        inicializarYMezclar();
    }

    // Metodo para inicializar y mezclar las cartas del mazo
    private void inicializarYMezclar() {
        String[] tipos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
        ArrayList<Carta> listaTemporal = new ArrayList<>();

        // Crear todas las cartas y agregarlas a la lista temporal
        for (String tipo : tipos) {
            for (int i = 1; i <= 13; i++) {
                listaTemporal.add(new Carta(tipo, i, true));
            }
        }

        // Mezclar la lista temporal de cartas con .shuffle.
        Collections.shuffle(listaTemporal);

        //Apilar las cartas mezcladas en la pilaDeCartas
        for (Carta carta : listaTemporal) {
            pilaDeCartas.apilar(carta);
        }
    }

    // Metodo para levantar una carta del mazo
    public Carta levantarCarta() {
        if (!pilaDeCartas.esVacia()) {
            return pilaDeCartas.desapilar();
        }
        return null;
    }

    // Metodo para verificar si el mazo esta vacio
    public boolean esVacio() {
        return pilaDeCartas.esVacia();
    }

    // Metodo para obtener la cantidad de cartas restantes en el mazo
    public int getCantidadCartas() {
        return pilaDeCartas.getTamanio();
    }
}