package ed2026.PI_I.G505;

// import ar.edu.unju.fi.ed.tda.Pila;
// import ar.edu.unju.fi.ed.tda.PilaDinamica;

public class Jugador {
	private String nombre;
	private String apellido;
	private Integer edad;
	private Pila<Carta> cartasGanadas;

	public Jugador() {
		this.cartasGanadas = new PilaDinamica<>();
	}

	public Jugador(String nombre, String apellido, Integer edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.cartasGanadas = new PilaDinamica<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Pila<Carta> getCartasGanadas() {
		return cartasGanadas;
	}

	public void ganarCarta(Carta carta) {
		cartasGanadas.apilar(carta);
	}

	public int calcularPuntaje() {

		int suma = 0;
		Pila<Carta> auxiliar = new PilaDinamica<>();

		while (!cartasGanadas.estaVacia()) {
			Carta c = cartasGanadas.desapilar();
			suma += c.getValor();
			auxiliar.apilar(c);
		}

		while (!auxiliar.estaVacia()) {
			cartasGanadas.apilar(auxiliar.desapilar());
		}

		return suma;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}
}
