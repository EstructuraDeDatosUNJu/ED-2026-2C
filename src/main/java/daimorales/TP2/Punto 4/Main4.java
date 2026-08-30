import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("sistema de gestion de equipos....");

        Scanner sc=new Scanner(System.in);

        int equipos=Helper.leerEnteroPositivo(sc, "ingrese cantidad de equipos: ");

        int[] arregloEquipo=new int[equipos];

        for (int i : arregloEquipo) {
            arregloEquipo[i]=new Equipo4();
        }

    }
}
