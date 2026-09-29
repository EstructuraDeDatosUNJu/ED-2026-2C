package ed2026.TP5;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {

    public int size();

    public void addFirst(ELEMENT item);

    public void addLast(ELEMENT item);

    public ELEMENT removeFirst();

    public ELEMENT removeLast();

}
