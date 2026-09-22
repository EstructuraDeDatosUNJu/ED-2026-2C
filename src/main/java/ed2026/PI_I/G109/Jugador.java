package ed2026.PI_I.G109;

public class Jugador {

	private String nombre;
	private String apellido;
	private int edad;
	private Queue<Carta> cartasGanadas;

	public Jugador(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.cartasGanadas = new Queue<Carta>(52);
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void agregarCartaGanada(Carta carta) {
		cartasGanadas.offer(carta);
	}

	public int calcularPuntaje() {
		int puntaje = 0;
		Queue<Carta> aux = new Queue<>(52);

		while (!cartasGanadas.isEmpty()) {
			Carta c = cartasGanadas.pool();
			if (c != null) {
				puntaje += c.getValor();
				aux.offer(c);
			}
		}

		while (!aux.isEmpty()) {
			Carta cAux = aux.pool();
			if (cAux != null) {
				cartasGanadas.offer(cAux);
			}
		}
		return puntaje;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}

}
