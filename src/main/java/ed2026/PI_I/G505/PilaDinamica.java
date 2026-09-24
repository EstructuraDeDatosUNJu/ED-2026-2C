package ed2026.PI_I.G505;

public class PilaDinamica<T> implements Pila<T> {

	private class Nodo {
		T dato;
		Nodo siguiente;

		Nodo(T dato) {
			this.dato = dato;
			this.siguiente = null;
		}
	}

	private Nodo cima;
	private int cantidad;

	public PilaDinamica() {
		cima = null;
		cantidad = 0;
	}

	@Override
	public void apilar(T elemento) {
		Nodo nuevo = new Nodo(elemento);
		nuevo.siguiente = cima;
		cima = nuevo;
		cantidad++;
	}

	@Override
	public T desapilar() {
		if (estaVacia()) {
			throw new RuntimeException("Pila vacia");
		}
		T elemento = cima.dato;
		cima = cima.siguiente;
		cantidad--;
		return elemento;
	}

	@Override
	public T tope() {
		if (estaVacia()) {
			throw new RuntimeException("Pila vacia");
		}
		return cima.dato;
	}

	@Override
	public boolean estaVacia() {
		return cima == null;
	}

	@Override
	public int cantidadElementos() {
		return cantidad;
	}
}