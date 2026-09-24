package ed2026.PI_I.G505;

public class PilaEstatica<T> implements Pila<T> {

	private T[] datos;
	private int indiceTope;

	@SuppressWarnings("unchecked")
	public PilaEstatica(int capacidad) {
		datos = (T[]) new Object[capacidad];
		indiceTope = -1;
	}

	@Override
	public void apilar(T elemento) {
		if (indiceTope == datos.length - 1) {
			throw new RuntimeException("Pila llena");
		}
		indiceTope++;
		datos[indiceTope] = elemento;
	}

	@Override
	public T desapilar() {
		if (estaVacia()) {
			throw new RuntimeException("Pila vacia");
		}
		T elemento = datos[indiceTope];
		datos[indiceTope] = null;
		indiceTope--;
		return elemento;
	}

	@Override
	public T tope() {
		if (estaVacia()) {
			throw new RuntimeException("Pila vacia");
		}
		return datos[indiceTope];
	}

	@Override
	public boolean estaVacia() {
		return indiceTope == -1;
	}

	@Override
	public int cantidadElementos() {
		return indiceTope + 1;
	}
}