package ed2026.TP3;

import java.util.Arrays;

/**
 * Implements a stack of objects of type ELEMENT. The stack has a fixed size, but it can be resized
 * if necessary.
 * The stack is implemented using an array of objects.
 * 
 * @author Julio Tentor
 * @version 1.0.0
 * 
 * @param <ELEMENT> the type of elements in the stack.
 */
public class Stack<ELEMENT> {

    private final static Integer defaulDimension = 10;

    private Object[] data;
    private Integer count;

    /**
     * Creates a new stack with the default dimension.
     */
    public Stack() {
        this(Stack.defaulDimension);
    }

    /**
     * Creates a new stack with the specified dimension.
     * 
     * @param dimension the dimension of the stack. Must be positive.
     * @throws RuntimeException if the dimension is not positive.
     * @see #defaulDimension
     */
    public Stack(Integer dimension) {
        if (dimension <= 0) {
            throw new RuntimeException("La cantidad de elementos en la  pila debe ser positiva");
        }
        this.data = new Object[dimension];
        this.count = 0;
    }

    /**
     * Returns true if this stack contains no elements.
     * 
     * @return true if this stack contains no elements, false otherwise.
     */
    public boolean empty() {
        return this.count <= 0;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     * 
     * @return the object at the top of this stack.
     * @throws RuntimeException if the stack is empty.
     */
    public ELEMENT peek() {
        if (this.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        return this.elementAt(this.count - 1);
    }

    /**
     * Removes the object at the top of this stack and returns that object as the value of this
     * function.
     * 
     * @return the object at the top of this stack.
     * @throws RuntimeException if the stack is empty.
     */
    public ELEMENT pop() {
        if (this.empty()) {
            throw new RuntimeException("La pila está vacía...");
        }
        --this.count;
        return this.elementAt(this.count);
    }

    /**
     * Pushes an item onto the top of this stack.
     * Resizes the stack if it is full.
     * 
     * @param element the element to be pushed onto the stack.
     * @return the element that was pushed onto the stack.
     *         // @throws RuntimeException if the stack is full.
     * 
     */
    public ELEMENT push(ELEMENT element) {
        if (this.size() >= this.data.length) {
            //            throw new RuntimeException("La pila está llena...");

            Object[] temp = new Object[this.data.length * 2];
            for (int i = 0; i < this.data.length; ++i) {
                temp[i] = this.data[i];
            }
            this.data = temp;
        }
        this.data[this.count] = element;
        ++this.count;
        return element;
    }

    /**
     * Returns the 1-based position where an object is on this stack.
     * 
     * @param element the element to search for.
     * @return the 1-based position of the element, or -1 if not found.
     */
    public int search(ELEMENT element) {
        for (int pos = this.count - 1; pos >= 0; --pos) {
            if (this.data[pos].equals(element)) {
                return this.count - pos;
            }
        }
        return -1;
    }

    /**
     * Returns the number of elements in this stack.
     * 
     * @return
     */
    public int size() {
        return this.count;
    }

    /**
     * Returns the element at the specified index in the stack.
     * It is a private method that casts the object at the given index to the generic type ELEMENT.
     * 
     * @param index the index of the element to return.
     * @return the element at the specified index in the stack.
     */
    @SuppressWarnings("unchecked")
    private ELEMENT elementAt(int index) {
        return (ELEMENT) this.data[index];
    }

    /**
     * Returns a string representation of this stack.
     * The string representation consists of a list of the stack's elements in the order they are
     * stored,
     * enclosed in square brackets ("[]").
     * Adjacent elements are separated by the characters ", " (comma and space).
     * Elements are converted to strings as by String.valueOf(Object).
     * 
     * @return a string representation of this stack.
     */
    @Override
    public String toString() {

        if (this.size() <= 0) {
            return "";
        }

        // from https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[0].toString());
        for (int i = 1; i < this.size(); ++i) {
            sb.append("," + this.data[i].toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns an array containing all of the elements in this stack in proper sequence (from first to
     * last element).
     * The returned array will be "safe" in that no references to it are maintained by this stack. (In
     * other words, this method must allocate a new array).
     * The caller is thus free to modify the returned array.
     * 
     * @return an array containing all of the elements in this stack in proper sequence.
     * @param destination The array into which the elements of the stack are to be stored.
     * @return the array containing all of the elements in this stack in proper sequence.
     * @throws ClassCastException if the runtime type of the specified array is not a supertype of the
     *                                runtime type of every element in this stack.
     */
    public ELEMENT[] toArray(ELEMENT[] destination) {
        if (destination.length < this.size()) {
            destination = Arrays.copyOf(destination, this.size());
        }

        for (int i = 0; i < this.size(); i++) {
            destination[i] = this.elementAt(i);
        }

        if (destination.length > this.size()) {
            destination[this.size()] = null;
        }

        return destination;
    }
}
