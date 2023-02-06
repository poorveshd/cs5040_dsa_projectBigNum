import student.TestCase;

/**
 * LStackTest Class contains test cases for
 * `LStack` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class LStackTest extends TestCase {
    /**
     * Test for pop on an empty stack.
     */
    public void testLStackEmptyPop() {
        // Empty stack
        LStack<String> stck = new LStack<String>();

        assertNull(stck.pop());
    }
}
