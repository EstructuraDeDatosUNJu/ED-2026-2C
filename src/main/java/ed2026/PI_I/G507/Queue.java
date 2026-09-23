package ed2026.PI_I.G507;

public interface Queue<E> {
  public boolean add(E element);

  public boolean offer(E element);

  public E poll();

  public E remove();

  public E peek();

  public E element();

  public boolean isEmpty();

  public int size();

  public Object[] toArray();
}
