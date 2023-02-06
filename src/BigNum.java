/**
 * BigNum Class is used to store any arbitrary-precision number
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class BigNum {
    // Big number stored as linked-list of `String`
    private LList<Character> num;

    /**
     * Constructor for `BigNum`. Initializes `num` with an empty
     * linked-list of `String`.
     */
    public BigNum() {
        num = new LList<Character>();
    }


    /**
     * Prepend a digit into `num`.
     *
     * @param digit
     *            digit that is to be prepended
     */
    public void prependDigit(int digit) {
        num.insert((char)(digit + '0'));
    }


    /**
     * Prepend a digit into `num` n times.
     *
     * @param digit
     *            digit that is to be prepended
     * @param n
     *            num of times digit is to be prepended
     */
    public void prependDigitNTimes(int digit, int n) {
        // In every iteration, prepend `digit` into `num`
        for (int i = 0; i < n; i++) {
            num.insert((char)(digit + '0'));
        }
    }


    /**
     * Prepend a digit into `num`.
     * 
     * @return number as a string
     */
    public String getNum() {
        // Big number in the form of character array
        char[] numArr = new char[num.length()];

        // Convert list of characters to array of characters
        // Add each node's value to a char array sequentially
        for (int i = 0; !num.isAtEnd(); num.next(), i++) {
            numArr[i] = num.getValue();
        }
        // Reset current element to point at start of the list
        num.moveToStart();

        return new String(numArr);
    }
}
