package ed2026.PI_I.G505;

public class Carta {
	private PaloCarta palo;
	private Integer valor;
	private EstadoCarta estadoCarta;

	public Carta(PaloCarta palo, Integer valor, EstadoCarta estadoCarta) {
		this.palo = palo;
		this.valor = valor;
		this.estadoCarta = estadoCarta;
	}

	public PaloCarta getPalo() {
		return palo;
	}

	public void setPalo(PaloCarta palo) {
		this.palo = palo;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public EstadoCarta getEstadoCarta() {
		return estadoCarta;
	}

	public void setEstadoCarta(EstadoCarta estadoCarta) {
		this.estadoCarta = estadoCarta;
	}

	@Override
	public String toString() {
		return valor + " de " + palo;
	}
}
