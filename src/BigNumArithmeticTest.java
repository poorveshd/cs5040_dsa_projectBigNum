import student.TestCase;

/**
 * BigNumArithmeticTest Class contains test cases for
 * `BigNumArithmetic` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class BigNumArithmeticTest extends TestCase {
    /**
     * Test the main function for valid input.
     */
    public void testMainValidInput() {
        // Arguments for the main method
        String[] args = { "test_bignumarithmetic_validinput.txt" };
        BigNumArithmetic.main(args);

        // Expected output
        String expectedResult = "5 1 + 3 * 1 ^ = 18\n";

        // Actual output
        String result = systemOut().getHistory();
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test the main function for invalid input.
     */
    public void testMainInvalidInput() {
        // Arguments for the main method
        String[] args = { "test_bignumarithmetic_invalidinput.txt" };
        BigNumArithmetic.main(args);

        // Expected output
        String expectedResult = "2 8 + 9 * 4 ^ 2 = \n";

        // Actual output
        String result = systemOut().getHistory();
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test the main function for a mix of valid and
     * invalid input.
     */
    public void testMainMixedInput() {
        // Arguments for the main method
        String[] args = { "input.txt" };
        BigNumArithmetic.main(args);

        // Expected output
        String expectedResult = String.join("",
            "56669777 99999911111 + 352324012 + 3 ^ 555557778 *",
            " = 562400792227677956625810678708149922000000\n",
            "99999999 990001 * 1119111 55565 33333 + * + 88888888 +",
            " = 99099674628565\n",
            "123456789 1111111111 * 111119 2111111 9111111 * + * 1 ^",
            " = 2638486500477638652325851269760\n", "9 1 + 5 * 0 + = 50\n",
            "999999999 0 * = 0\n", "9 0 ^ = 1\n",
            "5555555 333333 5454353 999999 666666 1 ^ * * + = \n",
            "3432 3333 9999 + * ^ * * 6666 + = \n");

        // Actual output
        String result = systemOut().getHistory();
        assertTrue(result.equals(expectedResult));
    }
}
