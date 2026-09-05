package daimorales.TP1;

public class Cilindro {
    // Atributos
    private double radio;
    private double altura;

    // Constructor por defecto
    public Cilindro(){
        this.radio =1.0;
        this.altura=1.0;
    }

    // Constructor especializado
    public Cilindro (double radio, double altura){
        this.radio = radio;
        this.altura = altura;
    }
    
    // Metodos getters y setters
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo");
        }
        this.radio = radio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if( altura<=0){
            throw new IllegalArgumentException("La altura no puede ser negativa");
        }
        this.altura = altura;
    }

    // Método para calcular y devolver el volumen del cilindro
    public double calcularVolumen (){
        return Math.PI * Math.pow(radio, 2) * altura;
    }
    
    public double calcularArea(){
        return 2 * Math.PI * radio * (radio + altura);
    }
}



    