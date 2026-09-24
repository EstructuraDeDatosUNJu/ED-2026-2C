package ed2026.PI_I.Julio;

import java.util.Arrays;
import java.util.Collection;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

/*
 * public interface Queue<E>
 * extends Collection<E>
 * 
 * A collection designed for holding elements prior to processing.
 * Besides basic Collection operations, queues provide additional insertion,
 * extraction, and inspection operations. Each of these methods exists in
 * two forms: one throws an exception if the operation fails, the other
 * returns a special value (either null or false, depending on the operation).
 * 
 * The latter form of the insert operation is designed specifically for use
 * with capacity-restricted Queue implementations; in most implementations,
 * insert operations cannot fail.
 * 
 * Queues typically, but do not necessarily, order elements in a FIFO
 * (first-in-first-out) manner. Among the exceptions are priority queues,
 * which order elements according to a supplied comparator, or the elements'
 * natural ordering, and LIFO queues (or stacks) which order the elements
 * LIFO (last-in-first-out). Whatever the ordering used, the head of the
 * queue is that element which would be removed by a call to remove() or
 * poll(). In a FIFO queue, all new elements are inserted at the tail of
 * the queue. Other kinds of queues may use different placement rules.
 * Every Queue implementation must specify its ordering properties.
 * 
 * The offer method inserts an element if possible, otherwise returning
 * false. This differs from the Collection.add method, which can fail to
 * add an element only by throwing an unchecked exception. The offer
 * method is designed for use when failure is a normal, rather than
 * exceptional occurrence, for example, in fixed-capacity (or "bounded")
 * queues.
 * 
 * The remove() and poll() methods remove and return the head of the queue.
 * Exactly which element is removed from the queue is a function of the
 * queue's ordering policy, which differs from implementation to
 * implementation. The remove() and poll() methods differ only in their
 * behavior when the queue is empty: the remove() method throws an
 * exception, while the poll() method returns null.
 * 
 * The element() and peek() methods return, but do not remove, the head
 * of the queue.
 * 
 * The Queue interface does not define the blocking queue methods, which
 * are common in concurrent programming. These methods, which wait for
 * elements to appear or for space to become available, are defined in
 * the BlockingQueue interface, which extends this interface.
 * 
 * Queue implementations generally do not allow insertion of null elements,
 * although some implementations, such as LinkedList, do not prohibit
 * insertion of null. Even in the implementations that permit it, null
 * should not be inserted into a Queue, as null is also used as a special
 * return value by the poll method to indicate that the queue contains no
 * elements.
 * 
 * Queue implementations generally do not define element-based versions of
 * methods equals and hashCode but instead inherit the identity based
 * versions from class Object, because element-based equality is not
 * always well-defined for queues with the same elements but different
 * ordering properties.
 * 
 * This interface is a member of the Java Collections Framework.
 * 
 * from https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Queue.html
 * from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html
 * from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Queue.html
 * from https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Queue.html
 * 
 */

// import java.lang.reflect.Array;
import java.util.Iterator;

public class Queue<ELEMENT> implements Iterable<ELEMENT> {

    //region Constants

    private static final int DEFAULT_DIMENSION = 10;

    //endregion

    //region Attributes

    protected Object[] data;
    protected int head;
    protected int tail;
    protected int count;

    //endregion

    //region Constructors

    // Default constructor
    public Queue() {
        this(Queue.DEFAULT_DIMENSION);
    }

    // Creates a queue with the specified dimension.
    public Queue(int dimension) {
        this.data = new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    /**
     * Creates a new queue with the elements from the specified iterable.
     * 
     * @param elements the elements to be added to the queue.
     * @throws RuntimeException if the elements collection is null or not an instance of Iterable.
     */
    public Queue(Iterable<ELEMENT> elements) {
        if (elements == null || !(elements instanceof Iterable)) {
            throw new RuntimeException("La colección de elementos no puede ser nula");
        }
        this(((Collection<ELEMENT>) elements).size());
        for (ELEMENT element : elements) {
            this.add(element);
        }
    }

    //endregion

    //region Queue Internal Methods
    protected int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    //endregion

    //region Queue Methods

    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions, returning true upon
    // success and throwing an IllegalStateException if no space is currently
    // available.
    public boolean add(ELEMENT element) {

        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    // Operacion peek en la teoría de Estructura de Datos
    //
    // Retrieves, but does not remove, the head of this queue. This method differs
    // from peek only in that it throws an exception if this queue is empty.
    @SuppressWarnings("unchecked")
    public ELEMENT element() {

        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return (ELEMENT) this.data[this.head];
    }

    // Operacion EnQueue en la teoría de Estructura de Datos
    //
    // Inserts the specified element into this queue if it is possible to do so
    // immediately without violating capacity restrictions. When using a
    // capacity-restricted queue, this method is generally preferable to add(E),
    // which can fail to insert an element only by throwing an exception.
    public boolean offer(ELEMENT element) {

        if (this.size() >= this.data.length) {
            return false;
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    // Retrieves, but does not remove, the head of this queue, or returns null if
    // this queue is empty.
    @SuppressWarnings("unchecked")
    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }
        return (ELEMENT) this.data[this.head];
    }

    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue, or returns null if this queue
    // is empty.
    public ELEMENT poll() {
        if (this.size() <= 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        ELEMENT result = (ELEMENT) this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

    // Operacion DeQueue en la teoría de Estructura de Datos
    //
    // Retrieves and removes the head of this queue. This method differs from poll()
    // only in that it throws an exception if this queue is empty.
    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        @SuppressWarnings("unchecked")
        ELEMENT result = (ELEMENT) this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }
    //endregion

    //region Override Object basic methods

    @Override
    public String toString() {

        if (this.size() <= 0) {
            return "";
        }

        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());

        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }

        sb.append("]");
        return sb.toString();
    }
    //endregion

    //region Collection Methods

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public int size() {
        return this.count;
    }

    @SuppressWarnings("unchecked")
    public ELEMENT[] toArray(ELEMENT[] destination) {
        if (destination.length < this.size()) {
            destination = Arrays.copyOf(destination, this.size());
        }
        for (int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            destination[i] = (ELEMENT) this.data[pos];
        }
        return destination;
    }
    //endregion

    //region Caso Ejemplo b) Methods

    public Queue<ELEMENT> union(Queue<ELEMENT> queue2) {
        return union(queue2, 0);
    }

    @SuppressWarnings("unchecked")
    public Queue<ELEMENT> union(Queue<ELEMENT> queue2, int moreElements) {
        Queue<ELEMENT> queue1 = this;

        Queue<ELEMENT> result = new Queue<>(queue1.size() + queue2.size() + moreElements);
        for (int pos = queue1.head, cta = queue1.size(); cta > 0; pos = queue1.next(pos), --cta) {
            result.offer((ELEMENT) queue1.data[pos]);
        }
        for (int pos = queue2.head, cta = queue2.size(); cta > 0; pos = queue2.next(pos), --cta) {
            result.offer((ELEMENT) queue2.data[pos]);
        }

        return result;

    }
    //endregion

    //region Ejercicio 3 Methods

    public Queue<ELEMENT> fusion(Queue<ELEMENT> queue2) {
        return fusion(queue2, 0);
    }

    @SuppressWarnings("unchecked")
    public Queue<ELEMENT> fusion(Queue<ELEMENT> queue2, int moreElements) {
        Queue<ELEMENT> queue1 = this;

        Queue<ELEMENT> result = new Queue<>(queue1.size() + queue2.size() + moreElements);

        int pos1 = queue1.head;
        int cta1 = queue1.size();

        int pos2 = queue2.head;
        int cta2 = queue2.size();

        while (cta1 > 0 || cta2 > 0) {
            if (cta1 > 0) {
                result.offer((ELEMENT) queue1.data[pos1]);
                pos1 = queue1.next(pos1);
                --cta1;
            }
            if (cta2 > 0) {
                result.offer((ELEMENT) queue2.data[pos2]);
                pos2 = queue2.next(pos2);
                --cta2;
            }
        }

        return result;
    }

    //endregion

    //region Iterable Methods

    @Override
    public Iterator<ELEMENT> iterator() {
        return new QueueIterator(this);
    }

    private class QueueIterator implements Iterator<ELEMENT> {

        //region Attributes

        private Queue<ELEMENT> itQueue;
        private int itCount;
        private int itPos;

        //endregion

        //region Constructor

        public QueueIterator(Queue<ELEMENT> queue) {
            this.itQueue = queue;
            this.itCount = this.itQueue.size();
            this.itPos = this.itQueue.head;
        }

        //endregion

        @Override
        public boolean hasNext() {
            return this.itCount > 0;
        }

        @Override
        public ELEMENT next() {
            if (!this.hasNext()) {
                throw new RuntimeException("Error en el iterador de la cola...");
            }
            @SuppressWarnings("unchecked")
            ELEMENT item = (ELEMENT) this.itQueue.data[this.itPos];
            this.itPos = this.itQueue.next(this.itPos);
            --this.itCount;
            return item;
        }
    }

    //endregion

}
