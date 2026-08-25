package daimorales.TP1;

import java.util.Scanner;
/*2) Crear una clase llamada CuentaBancaria que modele una cuenta bancaria. Esta clase debe contener los
siguientes atributos: titular, saldo y tipoCuenta (ahorro o corriente). La clase CuentaBancaria debe
implementar:
    a) Constructor predeterminado que inicializa el titular con "Invitado", saldo en 0 y tipoCuenta en "ahorro".
    b) Constructor con argumentos que permite establecer el titular, saldo inicial y tipo de cuenta.
    c) Un método depositar(double monto) que simule la adición de fondos a la cuenta. Debe validar que el
    monto sea positivo.
    d) Un método retirar(double monto) que simule la extracción de dinero. Debe disminuir el saldo y
    retornar true si la operación es exitosa. Si el monto excede el saldo disponible, no debe realizar la
    extracción, debe mostrar un mensaje de error por consola y retornar false.
    e) El método toString() que imprima en consola el titular, tipo de cuenta y saldo actual formateado.

    En el programa principal (main) se debe:
    f) Crear una instancia de CuentaBancaria.
    g) Inicializar la cuenta con algunos valores (ej. "Juan Perez", 50000.0, "corriente").
    h) Permitir al usuario, a través de un menú sencillo, realizar operaciones de depósito o retiro para esta
    cuenta, mostrando los detalles actualizados después de cada operación. El menú debe repetirse hasta
    que el usuario decida salir.

Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.

Preguntas sobre el problema
    a) ¿Por qué es conveniente que el atributo saldo sea privado y no se pueda modificar directamente
    desde el método main (ej. cuenta.saldo = 1000000;)? ¿Qué garantiza el uso de los métodos depositar y
    retirar?
    b) Un compañero propone que el método retirar sea de tipo void (sin retorno) y que solo muestre un
    mensaje de error si falla. Otro propone que retorne un boolean como pide el enunciado. ¿Qué ventajas y
    desventajas presenta cada alternativa? ¿Cuál solución permite que se tomen mejores decisiones?
    c) ¿Qué sucede si el usuario intenta retirar exactamente el mismo monto que tiene de saldo
    disponible? ¿Y si intenta depositar un monto negativo?
    d) El banco ahora pide agregar un límite de descubierto para las cuentas "corriente". Es decir, si es de
    tipo corriente, el saldo puede llegar a ser negativo hasta un límite (ej. -50000). ¿Qué método de la clase
    debería modificar? y ¿qué nueva validación debería agregar?*/

public class TP1_02 {
    
    public static void main (String[]args){

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner (System.in);


         //Crear una instancia de la clase CuentaBancaria
        CuentaBancaria cuentaBancaria =new CuentaBancaria("Juan Perez" ,50000.0, "corriente");

        int opcion;
        boolean salirDelMenu = false; 
        while (!salirDelMenu) {
            // Mostrar el menú
            System.out.println("----MENU CUENTA BANCARIA------");
            System.out.println("1. Mostrar informacion");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Mostrar información de la cuenta
                    System.out.println("Titular: " + cuentaBancaria.getTitular());
                    System.out.println("Saldo: " + cuentaBancaria.getSaldo());
                    System.out.println("Tipo de cuenta: " + cuentaBancaria.getTipoCuenta());
                    break;
                case 2:
                    // Depositar dinero
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    scanner.nextLine(); // limpia el buffer
                    if (montoDeposito <= 0) {
                        System.out.println("El monto a depositar debe ser mayor que cero.");
                    } else {
                        cuentaBancaria.depositar(montoDeposito);
                        System.out.println("Depósito realizado. Nuevo saldo: " + cuentaBancaria.getSaldo());
                    }
                    break;
                case 3:
                    // Retirar dinero
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    scanner.nextLine(); // limpia el buffer
                    if (montoRetiro <= 0) {
                        System.out.println("El monto a retirar debe ser mayor que cero.");
                    } else if (montoRetiro > cuentaBancaria.getSaldo()) {
                        System.out.println("Fondos insuficientes. Saldo actual: " + cuentaBancaria.getSaldo());
                    } else {
                        cuentaBancaria.retirar(montoRetiro);
                        System.out.println("Retiro realizado. Nuevo saldo: " + cuentaBancaria.getSaldo());
                    }
                    break;
                case 4:
                    salirDelMenu = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } 

        scanner.close();
        
    }
}
