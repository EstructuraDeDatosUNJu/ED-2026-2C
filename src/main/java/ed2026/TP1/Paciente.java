package ed2026.TP1;

/**
 * Representa la información de salud básica de un paciente.
 */
public class Paciente {
    private String nombre;
    private String dni;
    private double peso;
    private double altura;
    //atributos / getters setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero."); //exepcion para evitar negativos
        }
        this.altura = altura;
    }
    //calculo
    public double calcularImc() {
        return peso / (altura * altura);
    }
    //metodo para calcular imc
    public String obtenerEstadoNutricional() {
        double imc = calcularImc();

        if (imc < 18.5) {
            return "Bajo peso";
        }
        if (imc < 25) {
            return "Normal";
        }
        if (imc < 30) {
            return "Sobrepeso";
        }
        return "Obesidad";
    }
}

