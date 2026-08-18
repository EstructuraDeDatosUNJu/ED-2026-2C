package ed2026.TP1;

/**
 * Clase que representa un cilindro en el espacio tridimensional.
 * 
 * @author Julio Tentor
 * @version 1.0
 * 
 *          Enunciado del ejercicio:
 * 
 *          Diseñar una clase llamada Cilindro que represente una figura geométrica tridimensional.
 *          Esta clase debe tener los atributos radio (de la base) y altura.
 *          La clase Cilindro debe incluir:
 *          Constructor predeterminado que inicialice ambos valores en 1.0.
 *          Un constructor con argumentos para establecer el radio y la altura del cilindro.
 *          Un método que devuelva el volumen del cilindro (Fórmula: π * radio² * altura).
 *          Un método que devuelva el área de la superficie total (Fórmula: 2 * π * radio * (radio +
 *          altura)).
 * 
 */
public class Cilindro {
    // Atributos
    private double radio;
    private double altura;

    // Constructor por defecto
    public Cilindro() {
        this.radio = 1.0;
        this.altura = 1.0;
    }

    // Constructor especializado
    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    // Métodos de acceso (getters y setters)
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo, no seas tan bruto");
        }
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura no puede ser negativa");
        }
        this.altura = altura;
    }

    // Método para calcular y devolver el volumen del cilindro
    public double getVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    // Método para calcular y devolver el área de la superficie del cilindro
    public double getAreaSuperficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }
}
