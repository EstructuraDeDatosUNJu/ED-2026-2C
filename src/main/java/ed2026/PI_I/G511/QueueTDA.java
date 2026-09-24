package ed2026.PI_I.G511;
//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

/*
 * public interface QueueTDA<E>
 * extends Collection<E>
 * 
 * A collection designed for holding elements prior to processing.
 * Besides basic Collection operations, QueueTDAs provide additional insertion,
 * extraction, and inspection operations. Each of these methods exists in
 * two forms: one throws an exception if the operation fails, the other
 * returns a special value (either null or false, depending on the operation).
 * 
 * The latter form of the insert operation is designed specifically for use
 * with capacity-restricted QueueTDA implementations; in most implementations,
 * insert operations cannot fail.
 * 
 * QueueTDAs typically, but do not necessarily, order elements in a FIFO
 * (first-in-first-out) manner. Among the exceptions are priority QueueTDAs,
 * which order elements according to a supplied comparator, or the elements'
 * natural ordering, and LIFO QueueTDAs (or stacks) which order the elements
 * LIFO (last-in-first-out). Whatever the ordering used, the head of the
 * QueueTDA is that element which would be removed by a call to remove() or
 * poll(). In a FIFO QueueTDA, all new elements are inserted at the tail of
 * the QueueTDA. Other kinds of QueueTDAs may use different placement rules.
 * Every QueueTDA implementation must specify its ordering properties.
 * 
 * The offer method inserts an element if possible, otherwise returning
 * false. This differs from the Collection.add method, which can fail to
 * add an element only by throwing an unchecked exception. The offer
 * method is designed for use when failure is a normal, rather than
 * exceptional occurrence, for example, in fixed-capacity (or "bounded")
 * QueueTDAs.
 * 
 * The remove() and poll() methods remove and return the head of the QueueTDA.
 * Exactly which element is removed from the QueueTDA is a function of the
 * QueueTDA's ordering policy, which differs from implementation to
 * implementation. The remove() and poll() methods differ only in their
 * behavior when the QueueTDA is empty: the remove() method throws an
 * exception, while the poll() method returns null.
 * 
 * The element() and peek() methods return, but do not remove, the head
 * of the QueueTDA.
 * 
 * The QueueTDA interface does not define the blocking QueueTDA methods, which
 * are common in concurrent programming. These methods, which wait for
 * elements to appear or for space to become available, are defined in
 * the BlockingQueueTDA interface, which extends this interface.
 * 
 * QueueTDA implementations generally do not allow insertion of null elements,
 * although some implementations, such as LinkedList, do not prohibit
 * insertion of null. Even in the implementations that permit it, null
 * should not be inserted into a QueueTDA, as null is also used as a special
 * return value by the poll method to indicate that the QueueTDA contains no
 * elements.
 * 
 * QueueTDA implementations generally do not define element-based versions of
 * methods equals and hashCode but instead inherit the identity based
 * versions from class Object, because element-based equality is not
 * always well-defined for QueueTDAs with the same elements but different
 * ordering properties.
 * 
 * This interface is a member of the Java Collections Framework.
 * 
 * 
 * 
 * from https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/QueueTDA.html
 * from https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/QueueTDA.html
 * from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/QueueTDA.html
 * 
 */

import java.util.Arrays;

public class QueueTDA<ELEMENT> {

    private final static Integer defaulDimension = 10;
    private ELEMENT[] data;
    private int head;
    private int tail;
    private int count;

    public QueueTDA() {
        this(QueueTDA.defaulDimension);
    }

    @SuppressWarnings("unchecked")
    public QueueTDA(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }

    public boolean add(ELEMENT element) {
        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
        return true;
    }

    public ELEMENT element() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
        return this.data[this.head];
    }

    public boolean offer(ELEMENT element) {
        if (this.size() >= this.data.length) {
            return false;
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;
        return true;
    }

    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }
        return this.data[this.head];
    }

    public ELEMENT pool() {
        if (this.size() <= 0) {
            return null;
        }
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
        return result;
    }

    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
        return result;
    }

    // Método agregado para vaciar la cola antes de cada ronda
    public void removeAll() {
        Arrays.fill(this.data, null);
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    @Override
    public String toString() {
        if (this.size() <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.data[this.head].toString());
        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", ").append(this.data[pos].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public int size() {
        return this.count;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for (int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
}
