package ed2026.PI_I.G109;

import java.util.Random;

public class Mazo {
	private StackGenerica<Carta> mazoPila;

	public Mazo() {
		mazoPila = new StackGenerica<Carta>();
		inicializarMazo();
	}

	public void inicializarMazo() {
		String[] palos = { "Corazon", "Diamante", "Trébol", "Pica" };
		Carta[] baraja = new Carta[52];
		int contador = 0;

		//generar 52 cartas
		for (String palo : palos) {
			for (int valor = 1; valor <= 13; valor++) {
				baraja[contador] = new Carta(palo, valor);
				contador++;
			}
		}

		//mezclar las cartas
		Random random = new Random();
		for (int i = baraja.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);

			//intercambiar posiciones
			Carta temp = baraja[i];
			baraja[i] = baraja[j];
			baraja[j] = temp;
		}

		//agregar cartas al maazo (en la pila)
		for (Carta carta : baraja) {
			mazoPila.push(carta);
		}
	}

	public Carta agarrarCarta() {
		if (mazoPila.isEmpty())
			return null;
		Carta c = mazoPila.pop();
		c.setDisponible(false);
		return c;
	}

	public boolean tieneCartas() {
		return !mazoPila.isEmpty();
	}

}
