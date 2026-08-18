package ed2026.TP1;

/**
 * Clase que representa una cuenta bancaria.
 * 
 * @author Julio Tentor
 * @version 1.0
 */

public class CuentaBancaria {
    // Atributos
    private String titular;
    private double saldo;
    private String tipoCuenta; // Puede ser "Ahorro" o "Corriente"

    // Constructor por defecto
    public CuentaBancaria() {
        this.titular = "Invitado";
        this.saldo = 0.0;
        this.tipoCuenta = "Ahorro"; // Valor por defecto
    }

    // Constructor personalizado
    public CuentaBancaria(String titular, double saldo, String tipoCuenta) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío");
        }
        this.titular = titular;
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        this.saldo = saldo;
        if (!tipoCuenta.equals("Ahorro") && !tipoCuenta.equals("Corriente")) {
            throw new IllegalArgumentException("Tipo de cuenta inválido. Debe ser 'Ahorro' o 'Corriente'");
        }
        this.tipoCuenta = tipoCuenta;
    }

    // Métodos de acceso (getters y setters)
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío");
        }
        this.titular = titular;
    }

    private void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
        this.saldo = saldo;
    }

    // public void setTipoCuenta(String tipoCuenta) {
    //     this.tipoCuenta = tipoCuenta;
    // }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        setSaldo(this.saldo + cantidad);
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        setSaldo(this.saldo - cantidad);
    }

    // Método para mostrar información de la cuenta
    public void mostrarInformacion() {
        System.out.println("Titular.......: " + titular);
        System.out.println("Saldo.........: " + saldo);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
    }

    // Método toString para representar la cuenta bancaria como una cadena
    @Override
    public String toString() {
        return "CuentaBancaria [titular=" + titular + ", saldo=" + saldo + ", tipoCuenta=" + tipoCuenta + "]";
    }
}
