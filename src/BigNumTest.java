import student.TestCase;

/**
 * BigNumTest Class contains test cases for
 * `BigNum` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class BigNumTest extends TestCase {
    /**
     * Test whether `BigNum` can store a small integer.
     */
    public void testBigNumSmallInteger() {
        // Expected number
        final String expectedResult = "205";
        // Buffer for holding the big number
        BigNum num = new BigNum();

        // Prepend every digit from `expectedResult` into `num`
        for (int i = expectedResult.length() - 1; i >= 0; i--) {
            // Digit at ith index of `expectedResult`
            int digit = expectedResult.charAt(i) - '0';
            num.prependDigit(digit);
        }

        // Big number as `String`
        final String result = num.getNum();
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test whether `BigNum` can store a large integer.
     */
    public void testBigNumLargeInteger() {
        // Expected number
        final String expectedResult = "50968709867353123123";
        // Buffer for holding the big number
        BigNum num = new BigNum();

        // Prepend every digit from `expectedResult` into `num`
        for (int i = expectedResult.length() - 1; i >= 0; i--) {
            // Digit at ith index of `expectedResult`
            int digit = expectedResult.charAt(i) - '0';
            num.prependDigit(digit);
        }

        // Big number as `String`
        final String result = num.getNum();
        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test whether `BigNum` can prepend repeating digits.
     */
    public void testBigNumPrependNDigits() {
        // Expected number
        final String expectedResult = "888888888888888";
        // Buffer for holding the big number
        BigNum num = new BigNum();

        // Digit to be prepended
        final int digit = 8;
        // Number of times the `digit` is to be prepended
        final int n = 15;
        // Reconstruct `expectedResult`
        num.prependDigitNTimes(digit, n);

        // Big number as `String`
        final String result = num.getNum();
        assertTrue(result.equals(expectedResult));
    }
}
