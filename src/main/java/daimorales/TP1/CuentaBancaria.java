package daimorales.TP1;

public class CuentaBancaria {
    // Atributos
    private String titular;
    private double saldo;
    private String tipoCuenta; //  "Ahorro" o "Corriente"

   
    //Constructor por defecto
    public CuentaBancaria(){
        this.titular = "invitado";
        this.saldo = 0;
        this.tipoCuenta = "ahorro";
        
    }

    //Constructor especializado
    public CuentaBancaria(String titular, Double saldo, String tipoCuenta){
        this.titular = titular;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    //Metodo depositar monto
    public void depositar (double monto){
        if (monto>0){
            this.saldo +=monto;
        }else{
            System.out.print("El monto debe ser positivo");
        }
    }

    //Metodo retirar monto
    public  boolean retirar(double monto){
        if (monto> this.saldo){ 
            System.out.print("ERROR....el monto no debe superar el saldo disponible");
            return false;
        }else if (monto<0){
            System.out.print("ERROR... wl motno no debe ser menor a 0");
            return false;
        }else{
            this.saldo-=monto;
            return true;
        }
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Titular: " + this.titular + 
            ", Tipo de cuenta: " + this.tipoCuenta + 
            ", Saldo: $" + String.format("%.2f", this.saldo); 
    }
}
