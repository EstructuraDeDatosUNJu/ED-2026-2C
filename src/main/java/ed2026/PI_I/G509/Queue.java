package ed2026.PI_I.G509;

public class Queue<ELEMENT> {
    private final static Integer defaulDimension = 4;
    private ELEMENT[] data;
    private int head;
    private int tail;
    private int count;

    public Queue() {
        this(Queue.defaulDimension);
    }

    @SuppressWarnings("unchecked")
    public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public void enqueue(ELEMENT element) {
        if (this.count == this.data.length) {
            throw new IllegalStateException("La cola está llena");
        }
        this.data[tail] = element;
        this.tail = (tail + 1) % this.data.length;
        this.count++;
    }

    public ELEMENT dequeue() {
        if (this.count == 0) {
            throw new IllegalStateException("La cola está vacía");
        }
        ELEMENT element = this.data[head];
        this.data[head] = null;
        this.head = (head + 1) % this.data.length;
        this.count--;
        return element;
    }

    public ELEMENT peek() {
        if (this.count == 0) {
            throw new IllegalStateException("La cola está vacía");
        }
        return this.data[head];
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    private int next(int pos) {
        return (pos + 1) % this.data.length;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for (int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
}
