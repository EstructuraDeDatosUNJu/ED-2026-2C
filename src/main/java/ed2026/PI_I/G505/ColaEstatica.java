package ed2026.PI_I.G505;

public class ColaEstatica<T> implements Cola<T> {

	private T[] datos;
	private int indiceFrente;
	private int cantidad;

	@SuppressWarnings("unchecked")
	public ColaEstatica(int capacidad) {
		datos = (T[]) new Object[capacidad];
		indiceFrente = 0;
		cantidad = 0;
	}

	@Override
	public void encolar(T elemento) {
		if (cantidad == datos.length) {
			throw new RuntimeException("Cola llena");
		}
		int indiceLibre = (indiceFrente + cantidad) % datos.length;
		datos[indiceLibre] = elemento;
		cantidad++;
	}

	@Override
	public T desencolar() {
		if (estaVacia()) {
			throw new RuntimeException("Cola vacia");
		}
		T elemento = datos[indiceFrente];
		datos[indiceFrente] = null;
		indiceFrente = (indiceFrente + 1) % datos.length;
		cantidad--;
		return elemento;
	}

	@Override
	public T frente() {
		if (estaVacia()) {
			throw new RuntimeException("Cola vacia");
		}
		return datos[indiceFrente];
	}

	@Override
	public boolean estaVacia() {
		return cantidad == 0;
	}

	@Override
	public int cantidadDeElementos() {
		return cantidad;
	}
}