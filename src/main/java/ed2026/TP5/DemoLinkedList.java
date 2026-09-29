package ed2026.TP5;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.Random;

public class DemoLinkedList {
    private static Random random = new Random();

    public void Run() {
        System.out.println("Demo de lista enlazada ");

        ILinkedList<Integer> list1 = new DoubleLinkedList<Integer>();
        ILinkedList<Integer> list2 = new SimpleLinkedList<Integer>();

        int num;
        System.out.print("Numeros: ");
        for (int i = 0; i < 6; ++i) {
            num = random.nextInt(101);
            System.out.printf("%d ", num);
            list1.addFirst(num);
            list2.addLast(num);
        }
        System.out.println();

        System.out.println("Lista1.: " + list1.toString());
        System.out.println("Lista2.: " + list2.toString());

        System.out.print("Extrae.: ");
        for (int i = 0; i < 3; ++i) {
            System.out.printf("%d ", list1.removeFirst());
            System.out.printf("%d ", list2.removeLast());
        }
        System.out.println();

        System.out.println("Lista1.: " + list1.toString());
        System.out.println("Lista2.: " + list2.toString());

        System.out.print("Extrae el último hasta vaciar la lista1: ");
        while (list1.size() > 0) {
            System.out.printf("%d ", list1.removeLast());
        }
        System.out.println();

    }

}
