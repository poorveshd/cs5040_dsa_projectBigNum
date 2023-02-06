/**
 * Citation: Implementation of this entire file is taken from the OpenDSA
 * textbook.
 *
 * LStack Class containing a stack implementation.
 *
 * @author OpenDSA authors
 * @version 2/13/2022
 *
 * @param <E>
 */
public class LStack<E> implements Stack<E> {
    // Pointer to first element
    private Link<E> top;
    // Number of elements
    private int size;

    /**
     * Constructor for stack.
     */
    LStack() {
        top = null;
        size = 0;
    }


    /**
     * Put "it" on stack.
     *
     * @param it
     *            value to be pushed
     * 
     * @return true if value pushed and false otherwise
     */
    public boolean push(E it) {
        top = new Link<E>(it, top);
        size++;
        return true;
    }


    /**
     * Remove "it" from stack.
     * 
     * @return value popped
     */
    public E pop() {
        if (top == null) {
            return null;
        }

        // Value of top element of stack
        E it = top.element();
        top = top.next();
        size--;
        return it;
    }


    /**
     * Return stack length.
     * 
     * @return length of stack
     */
    public int length() {
        return size;
    }
}
