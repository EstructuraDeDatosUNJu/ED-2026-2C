package daimorales.TP2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class validacionHelper {
    // Método para validar que el usuario ingrese un número entero.
    public static int leerEntero(Scanner scanner)
    {
        int numero = 0;
        boolean entradaValida = false;
        
        while (!entradaValida)
        {
            try
            {
                numero = scanner.nextInt(); 
                entradaValida = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Debe ingresar un valor numérico.");
                scanner.nextLine(); 
            }
        }
        return numero;
    }
    
    // Método para validar enteros positivos
    public static int leerEnteroPositivo(Scanner scanner, String mensaje)
    {
        int numero = 0;
        boolean entradaValida = false;
        
        while ( !entradaValida )
        {
            System.out.print(mensaje);
            try
            {
                numero = scanner.nextInt(); 
                
                if (numero > 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: El número debe ser mayor a cero.");
                }
                
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Debe ingresar un valor numérico.");
                scanner.nextLine();
            }
        }
        return numero;
    }

    // Método para validar enteros positivos
    public static int leerEnteroNoNegativo(Scanner scanner, String mensaje)
    {
        int numero = 0;
        boolean entradaValida = false;
        
        while ( !entradaValida )
        {
            System.out.print(mensaje);
            try
            {
                numero = scanner.nextInt(); 
                
                if (numero >= 0) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: El número debe ser mayor o igual a cero.");
                }
                
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Debe ingresar un valor numérico.");
                scanner.nextLine();
            }
        }
        return numero;
    }

    // Método para leer un entero dentro de un rango
    public static int leerEnteroEnRango(Scanner scanner, String mensaje, int min, int max)
    {
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida)
        {
            System.out.print(mensaje);

            try
            {
                numero = scanner.nextInt();

                if (numero >= min && numero <= max)
                {
                    entradaValida = true;
                }
                else
                {
                    System.out.println("Error: Debe ingresar un valor entre " + min + " y " + max + ".");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Debe ingresar un valor numérico.");
                scanner.nextLine();
            }
        }

        return numero;
    }

    // Método para leer números tipo double
    public static double leerDouble(Scanner scanner, String mensaje)
    {
        double valor = 0;
        boolean entradaValida = false;

        while (!entradaValida)
        {
            System.out.print(mensaje);

            try
            {
                valor = scanner.nextDouble();
                entradaValida = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Debe ingresar un valor numérico.");
                scanner.nextLine(); // limpia el buffer
            }
        }

        return valor;
    }

    // Método para leer números positivos del tipo double 
    public static double leerDoublePositivo(Scanner scanner, String mensaje)
    {
        double valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida)
        {
            System.out.print(mensaje);
            
            try
            { 
                valor = scanner.nextDouble();
                
                if (valor > 0)
                {
                    entradaValida = true;
                }
                else
                {
                    System.out.println("Error: el valor debe ser mayor a 0.");
                }
                
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: debe ingresar un valor numérico");
                scanner.nextLine();
            }
        }
        return valor;
    }
    
    // Para elegir un núm mínimo y máximo
    public static double leerDoubleEnRango(Scanner scanner, String mensaje, double min, double max)
    {
        double valor = 0;
        boolean entradaValida = false;
        
        while (!entradaValida)
        {
            System.out.print(mensaje);
            try
            {
                valor = scanner.nextDouble();
                
                if (valor >= min && valor <= max)
                {
                    entradaValida = true;
                } else {
                    System.out.println("Error: Debes elegir un valor entre " + min + " y " + max + ".");
                }
            
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: debe ingresar un valor numérico.");
                scanner.nextLine();
            }
        }
        return valor;
    }
    
    // Leer cadena y verificar si no esta vacía
    public static String leerCadena(Scanner scanner, String mensaje)
    {
        String palabra = null;
        boolean entradaValida = false;
        
        while (!entradaValida)
        {
            System.out.print(mensaje);
            palabra = scanner.nextLine(); 
            
            if ( !palabra.trim().isEmpty() )
            {
                entradaValida = true;
            }
            else
            {
                System.out.println("Error: No puedes ingresar una cadena vacía.");
            }
        }
        return palabra;
    }
    
    // Metodo para para pedirle al usuario que escriba un solo carácter
    public static char leerCaracter(Scanner scanner, String mensaje)
    {
    	String input;
    	while (true)
    	{
    		System.out.print(mensaje);
    		input = scanner.nextLine();
        
    		if (input.length() == 1)
    		{
    			return input.charAt(0);
    		}
    		else
    		{
    			System.out.println("Error: Por favor, ingrese un único carácter.");
    		}
    	}
    }
    
    // Metodo que verifica que lo que el usuario escriba sea un número de tipo float
    public static float leerFloat(Scanner scanner, String mensaje)
    {
        float valor;

        while (true)
        {
            try
            {
                System.out.print(mensaje);
                valor = scanner.nextFloat();
                scanner.nextLine(); // Limpia el buffer
                return valor;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Por favor, ingrese un número decimal válido.");
                scanner.nextLine(); // Limpia el buffer de entrada incorrecta
            }
        }
    }

}

    

