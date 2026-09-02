package ed2026.TP1_2020;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
public class Program {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        Integer option;
        while (true) {
            System.out.println(
                    "\nEjercicios del Trabajo Práctico Nº 1" +
                    // "\n 1. Arreglos de una dimensión" +
                    // "\n 2. Algoritmos para Arreglos" +
                    // "\n 3. Arreglo de dos dimensiones" +
                    // "\n 4. Arreglo dinámico" +
                            "\n 5. Arreglo de libros" +
                            "\n 6. Libro con varios autores" +
                            "\n    (0 Finaliza el programa)");
            option = Helper.getInteger("\nSu opción: ");

            switch (option) {
                case 0:
                    return;
                // case 1:
                //     (new TP1E01()).Run();
                //     return;
                // case 2:
                //     (new TP1E02()).Run();
                //     return;
                // case 3:
                //     (new TP1E03()).Run();
                //     return;
                // case 4:
                //     (new TP1E04()).Run();
                //     return;
                case 5:
                    (new TP1E05()).Run();
                    return;
                case 6:
                    (new TP1E06()).Run();
                    return;
            }
        }
    }

}
