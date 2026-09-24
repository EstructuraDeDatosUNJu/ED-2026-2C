package ed2026.PI_I.G505;

public class ColaDinamica<T> implements Cola<T> {

	private class Nodo {
		T dato;
		Nodo siguiente;

		Nodo(T dato) {
			this.dato = dato;
			this.siguiente = null;
		}
	}

	private Nodo frente;
	private Nodo ultimo;
	private int cantidad;

	public ColaDinamica() {
		frente = null;
		ultimo = null;
		cantidad = 0;
	}

	@Override
	public void encolar(T elemento) {
		Nodo nuevo = new Nodo(elemento);
		if (estaVacia()) {
			frente = nuevo;
		} else {
			ultimo.siguiente = nuevo;
		}
		ultimo = nuevo;
		cantidad++;
	}

	@Override
	public T desencolar() {
		if (estaVacia()) {
			throw new RuntimeException("Cola vacia");
		}
		T elemento = frente.dato;
		frente = frente.siguiente;
		if (frente == null) {
			ultimo = null;
		}
		cantidad--;
		return elemento;
	}

	@Override
	public T frente() {
		if (estaVacia()) {
			throw new RuntimeException("Cola vacia");
		}
		return frente.dato;
	}

	@Override
	public boolean estaVacia() {
		return frente == null;
	}

	@Override
	public int cantidadDeElementos() {
		return cantidad;
	}
}