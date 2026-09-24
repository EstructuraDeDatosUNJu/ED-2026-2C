package ed2026.PI_I.G513;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private String apellido;
	private int edad;
	private int puntaje;
	private ArrayList<Carta> cartasObtenidas;

	public Jugador(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.puntaje = 0;
		this.cartasObtenidas = new ArrayList<>();
	}

	//Getters y Setters

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

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public void agregarCarta(Carta carta) {
		cartasObtenidas.add(carta);
		sumarPuntaje(carta.getValor());
	}

	public ArrayList<Carta> getCartasObtenidas() {
		return cartasObtenidas;
	}

	public void sumarPuntaje(int puntos) {
		this.puntaje += puntos;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellido;
	}
}
