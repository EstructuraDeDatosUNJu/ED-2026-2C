package ed2026.TP6;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
public class EjercicioPropuesto1 {

    public void Run() {
        System.out.println("Ejercicio Propuesto 1 - Arbol Binario");

        BinaryTree<Character> a1 = new BinaryTree<Character>('B', new BinaryTree<Character>('A'),
                new BinaryTree<Character>('C'));
        BinaryTree<Character> a2 = new BinaryTree<Character>('G', new BinaryTree<Character>('F'), null);
        BinaryTree<Character> a3 = new BinaryTree<Character>('E', null, a2);
        BinaryTree<Character> a = new BinaryTree<Character>('D', a1, a3);

        //        BinaryTree<Integer> a1 = new BinaryTree<Integer>(33, new BinaryTree<Integer>(56), new BinaryTree<Integer>(6));
        //        BinaryTree<Integer> a2 = new BinaryTree<Integer>(17, new BinaryTree<Integer>(7), null);
        //        BinaryTree<Integer> a3 = new BinaryTree<Integer>(29, null, a2);
        //        BinaryTree<Integer> a = new BinaryTree<Integer>(8, a1, a3);

        System.out.printf("Arbol...... %s", a.toString());
        System.out.println();

        System.out.print("Pre Orden.. ");
        a.PreOrder();
        System.out.println();
        System.out.print("En Orden... ");
        a.InOrder();
        System.out.println();
        System.out.print("Post Orden. ");
        a.PostOrder();
        System.out.println();
        System.out.print("Descendente ");
        a.DescendingOrder();
        System.out.println();

        System.out.printf("Cantidad de Nodos %s\n", a.NodeCount());
        System.out.printf("Cantidad de Hojas %s\n", a.LeafCount());
        System.out.printf("Nodos Internos    %s\n", a.InternalCount());
        System.out.printf("Máximo Nivel      %s\n", a.MaxLevel());
        System.out.printf("Altura            %s\n", a.Height());

    }
}
