package ed2026.PI_I.G505;

public interface Cola<T> {
	void encolar(T elemento);

	T desencolar();

	T frente();

	boolean estaVacia();

	int cantidadDeElementos();
}