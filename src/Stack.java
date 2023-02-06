/**
 * Citation: Implementation of this entire file is taken from the OpenDSA
 * textbook.
 *
 * Stack class ADT. Generalize the element type using Java Generics.
 * 
 * @author OpenDSA authors
 * @version 2/13/2022
 *
 * @param <E>
 */
public interface Stack<E> {
    /**
     * Push `it` onto the top of the stack.
     *
     * @param it
     *            value of element
     * @return true for success and false for failure
     */
    public boolean push(E it);


    /**
     * Remove and return the element at the top of the stack.
     *
     * @return element that was at the top of the stack
     */
    public E pop();


    /**
     * Return the number of elements in the stack.
     *
     * @return length of the stack
     */
    public int length();
}
