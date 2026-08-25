import java.util.Scanner;

public class punto6 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String ciudad;
        String pais;
        String cadenaFinal;

        ciudad = ValidacionHelper.leerCadena(sc, "Ingrese el nombre de la ciudad: ");
        pais = ValidacionHelper.leerCadena(sc, "Ingrese el nombre del país: ");

        // Concatenar ciudad y país
        cadenaFinal = ciudad + ", " + pais;

        System.out.println("\nResultado: " + cadenaFinal);

        // Cantidad de caracteres
        System.out.println("Cantidad de caracteres de la ciudad: " + ciudad.length());
        System.out.println("Cantidad de caracteres del país: " + pais.length());

        // Comparar longitud
        if (ciudad.length() > pais.length()) {
            System.out.println("La ciudad tiene más caracteres.");
        } else if (pais.length() > ciudad.length()) {
            System.out.println("El país tiene más caracteres.");
        } else {
            System.out.println("La ciudad y el país tienen la misma cantidad de caracteres.");
        }

        // Verificar si contiene ñ
        if (ciudad.toLowerCase().contains("ñ")) {
            System.out.println("La ciudad contiene la letra ñ.");
        } else {
            System.out.println("La ciudad no contiene la letra ñ.");
        }

        // Mostrar todo en minúsculas
        System.out.println("Cadena final en minúsculas: " + cadenaFinal.toLowerCase());
    }
}