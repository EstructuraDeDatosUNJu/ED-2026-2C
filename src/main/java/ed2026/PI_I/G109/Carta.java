package ed2026.PI_I.G109;

public class Carta {

	private String palo;
	private int valor;
	private boolean disponible;

	public Carta(String palo, int valor) {
		this.palo = palo;
		this.valor = valor;
		this.disponible = true;
	}

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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", valor=" + valor + ", disponible=" + disponible + "]";
	}

}
