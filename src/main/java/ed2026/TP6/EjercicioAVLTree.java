package ed2026.TP6;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

public class EjercicioAVLTree {

    public void Run() {
        menu();
    }

    private static void menu() {
        int option;
        while (true) {
            System.out.print("\nOpciones:");
            System.out.print("\n  1. Agregar con Rotación Simple LL");
            System.out.print("\n  2. Agregar con Rotación Doble LR");
            System.out.print("\n  3. Remover con Rotación Simple RR");
            System.out.print("\n  4. Remover con Rotación Doble RR RL");
            option = Helper.getInteger("\nSu opción (0 finaliza): ");
            if (option == 0) {
                break;
            }
            switch (option) {
                case 1:
                    addDemo1();
                    break;
                case 2:
                    addDemo2();
                    break;
                case 3:
                    removeDemo1();
                    break;
                case 4:
                    removeDemo2();
                    break;
            }
        }
    }

    private static void addDemo1() {
        System.out.print("\n\nDemo Arbol AVL Agregar con Rotación Simple LL\n");
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.setVerbose(true);
        // Gnarled trees 29 19 50 12 22 60 8 17
        int[] numbers = { 29, 19, 50, 12, 22, 60, 8, 17 };
        for (int number : numbers) {
            tree.add(number);
        }
        tree.add(5);
    }

    private static void addDemo2() {
        System.out.print("\n\nDemo Arbol AVL Agregar con Rotación Doble LR\n");
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.setVerbose(true);
        // Gnarled trees 40 20 80 10 30 50 90 45 75
        int[] numbers = { 40, 20, 80, 10, 30, 50, 90, 45, 75 };
        for (int number : numbers) {
            tree.add(number);
        }
        tree.add(60);
    }

    private static void removeDemo1() {
        System.out.print("\n\nDemo Arbol AVL Remover con Rotación Simple RR\n");
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.setVerbose(true);
        // Gnarled trees 29 20 61 25 40 70 55 79
        int[] numbers = { 29, 20, 61, 25, 40, 70, 55, 79 };
        for (int number : numbers) {
            tree.add(number);
        }
        tree.remove(25);
    }

    private static void removeDemo2() {
        System.out.print("\n\nDemo Arbol AVL Remover con Rotación Doble RR RL\n");
        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.setVerbose(true);
        // Gnarled trees 70 43 90 21 58 80 110 62 72 88 95 85
        int[] numbers = { 70, 43, 90, 21, 58, 80, 110, 62, 72, 88, 95, 85 };
        for (int number : numbers) {
            tree.add(number);
        }
        tree.remove(21);
    }

}
