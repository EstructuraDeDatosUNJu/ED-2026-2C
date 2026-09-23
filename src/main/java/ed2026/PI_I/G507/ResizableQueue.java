package ed2026.PI_I.G507;

import java.util.NoSuchElementException;

public class ResizableQueue<E> implements Queue<E> {
  private Object[] queue;
  private int head;
  private int tail;
  private int count;

  public ResizableQueue() {
    this(10);
  }

  public ResizableQueue(int initialCapacity) {
    if (initialCapacity <= 0)
      throw new IllegalArgumentException("La capacidad inicial debe ser mayor a 0");
    this.queue = new Object[initialCapacity];
    this.head = 0;
    this.tail = 0;
    this.count = 0;
  }

  @Override
  public boolean add(E element) {
    if (isFull())
      resize(queue.length * 2);

    queue[tail] = element;
    tail = next(tail);
    count++;
    return true;
  }

  @Override
  public boolean offer(E element) {
    return add(element);
  }

  @Override
  @SuppressWarnings("unchecked")
  public E poll() {
    if (isEmpty())
      return null;

    E element = (E) queue[head];
    queue[head] = null;
    head = next(head);
    count--;
    return element;
  }

  @Override
  public E remove() {
    if (isEmpty())
      throw new NoSuchElementException("La cola esta vacia.");
    return poll();
  }

  @Override
  @SuppressWarnings("unchecked")
  public E peek() {
    if (isEmpty())
      return null;
    return (E) queue[head];
  }

  @Override
  @SuppressWarnings("unchecked")
  public E element() {
    if (isEmpty())
      throw new NoSuchElementException("La cola esta vacia.");
    return (E) queue[head];
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public boolean isEmpty() {
    return count == 0;
  }

  @Override
  public Object[] toArray() {
    if (isEmpty())
      return new Object[0];

    Object[] array = new Object[count];
    int copyHead = this.head;
    for (int i = 0; i < count; i++) {
      array[i] = queue[copyHead];
      copyHead = next(copyHead);
    }
    return array;
  }

  @Override
  public String toString() {
    if (isEmpty())
      return "[]";

    int copyHead = this.head;
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < count; i++) {
      if (i > 0)
        sb.append(", ");
      sb.append(queue[copyHead]);
      copyHead = next(copyHead);
    }
    sb.append("]");
    return sb.toString();
  }

  public boolean isFull() {
    return count == queue.length;
  }

  private int next(int pos) {
    pos++;
    if (pos >= queue.length)
      return 0;
    return pos;
  }

  private void resize(int newCapacity) {
    Object[] newQueue = new Object[newCapacity];
    int copyHead = this.head;

    for (int i = 0; i < count; i++) {
      newQueue[i] = queue[copyHead];
      copyHead = next(copyHead);
    }

    this.queue = newQueue;
    this.head = 0;
    this.tail = count;
  }
}
