package ed2026.PI_I.G505;

public interface Pila<T> {
	void apilar(T elemento);

	T desapilar();

	T tope();

	boolean estaVacia();

	int cantidadElementos();

}
