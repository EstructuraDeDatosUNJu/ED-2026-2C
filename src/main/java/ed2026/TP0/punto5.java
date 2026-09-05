import java.util.Random;

public class punto5 {

    public static void main(String[] args) {

        Random random = new Random();

        int limiteInferior = random.nextInt(100) + 1;
        int limiteSuperior = random.nextInt(100) + 101;
        int divisor = random.nextInt(8) + 2;

        int suma = 0;
        int cantidad = 0;

        System.out.println("Límite inferior: " + limiteInferior);
        System.out.println("Límite superior: " + limiteSuperior);
        System.out.println("Divisor: " + divisor);

        System.out.println("\nNúmeros divisibles por " + divisor + ":");

        for (int i = limiteInferior; i <= limiteSuperior; i++) {

            if (i % divisor == 0) {
                System.out.println(i);

                suma += i;
                cantidad++;
            }
        }

        if (cantidad > 0) {
            int promedio = suma / cantidad;
            System.out.println("\nPromedio entero: " + promedio);
        } else {
            System.out.println("\nNo se encontraron números divisibles.");
        }
    }
}