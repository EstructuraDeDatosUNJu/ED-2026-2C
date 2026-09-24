package ed2026.PI_I.G513;

public class Carta {

	private String palo;
	private int valor;

	public Carta(String palo, int valor) {
		this.palo = palo;
		this.valor = valor;
	}

	//Getters y Setters

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor + " de " + palo;
	}
}
