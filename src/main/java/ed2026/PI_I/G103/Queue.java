package ed2026.PI_I.G103;

import java.util.Arrays;

// Circular queue (own ADT) backed by a fixed-size array
public class Queue<ELEMENT> {
    //region constant
    private static final int DEFAULT_PLAYERS = 4;
    //endregion

    //region attributes
    private Object[] elements;
    private int head;
    private int tail;
    private int count;
    //endregion

    //region constructors
    public Queue() {
        this(Queue.DEFAULT_PLAYERS);
    }

    public Queue(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Error. Capacity must be greater than 0");
        }
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    //endregion

    // Moves one position forward and wraps around to 0 at the end of the array
    protected int next(int pos) {
        if (++pos >= this.elements.length) {
            pos = 0;
        }
        return pos;
    }

    @SuppressWarnings("unchecked")
    public ELEMENT peek() {
        if (this.size() <= 0) {
            throw new RuntimeException("Error. The queue is empty. ...");
        }
        return (ELEMENT) this.elements[this.head];
    }

    public boolean add(ELEMENT element) {
        if (this.size() >= this.elements.length) {
            throw new RuntimeException("Error. The queue is full ...");
        }

        this.elements[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    public boolean offer(ELEMENT element) {
        if (this.size() >= this.elements.length) {
            return false;
        }

        this.elements[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }

    public ELEMENT poll() {
        if (this.isEmpty()) {
            return null;
        }

        @SuppressWarnings("unchecked")
        ELEMENT temp = (ELEMENT) this.elements[this.head];
        this.head = this.next(this.head);
        --this.count;
        return temp;
    }

    public ELEMENT remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("ERROR. The Queue is empty.");
        }

        @SuppressWarnings("unchecked")
        ELEMENT temp = (ELEMENT) this.elements[this.head];
        this.head = this.next(this.head);
        --this.count;
        return temp;
    }

    public boolean isEmpty() {
        return this.count <= 0;
    }

    public int size() {
        return this.count;
    }

    // aliases used by Main
    public void enqueue(ELEMENT element) {
        this.offer(element);
    }

    public ELEMENT dequeue() {
        return this.poll();
    }

    // Lists the elements from head to tail without modifying the queue
    @Override
    public String toString() {
        if (this.size() <= 0) {
            return "[]";
        }

        Object[] result = new Object[this.count];
        for (int x = 0, pos = this.head, cta = this.size(); cta > 0; ++x, pos = this.next(pos), --cta) {
            result[x] = this.elements[pos];
        }
        return Arrays.toString(result);
    }
}
