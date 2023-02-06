
/**
 * Calculator Class is used to performn addition, multiplication,
 * and exponentiation operations on any arbitrary-precision numbers.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class Calculator {
    /**
     * Evaluation the RPN(reverse polish notation) expression and
     * return the result as a `String`.
     *
     * @param expression
     *            mathematical expression in reverse polish notation
     * 
     * @return result of expression evaluation
     */
    public String evaluate(String expression) {
        // Linked-list based stack that will hold operands
        // for evaluating the given RPN based expression
        LStack<String> stck = new LStack<String>();

        // List of operands and operators in RPN sequence
        String[] tokens = expression.split(" ");

        // For every token: if it is integer, push on stack;
        // Otherwise if it is operator, pop 2 integers from
        // the stack and perform the respective operation
        for (String token : tokens) {
            if (StringOps.isInteger(token)) {
                stck.push(token);
            }
            else {
                // 1st operand for the operation
                final String operand1 = stck.pop();
                // 2nd operand for the operation
                final String operand2 = stck.pop();
                // If stack doesn't have at-least two operands,
                // then the expression is invalid
                if (operand2 == null) {
                    return null;
                }
                // Push the result of the operation back onto the stack
                stck.push(operate(operand1, operand2, token));
            }
        }

        // The expression is only valid if stack has one integer left
        if (stck.length() == 1) {
            return stck.pop();
        }
        return null;
    }


    /**
     * Perform addition of two arbitrary-precision numbers.
     *
     * @param operand1
     *            first operand for the addition operation
     * @param operand2
     *            second operand for the addition operation
     * 
     * @return addition result of given operands
     */
    public String add(String operand1, String operand2) {
        // 1st operand for the operation
        operand1 = StringOps.removePrefixZeros(operand1);
        // 2nd operand for the operation
        operand2 = StringOps.removePrefixZeros(operand2);
        // Operand with lesser number of digits
        String less;
        // Operand with greater or equal number of digits
        String more;

        if (operand1.length() < operand2.length()) {
            less = operand1;
            more = operand2;
        }
        else {
            less = operand2;
            more = operand1;
        }

        // Number which will act as buffer for the answer
        BigNum num = new BigNum();
        // Index for digits in `less` operand
        int l;
        // Index for digits in `more` operand
        int m;
        // Carry value for adding two digits
        int carry = 0;

        // Add numbers `less` and `more` one digit at a time starting from
        // the last digit and moving towards the first; Include carry
        for (l = less.length() - 1, m = more.length() - 1; l >= 0; l--, m--) {
            // Sum of lth digit in `less`, mth digit in `more`, and carry
            int sum = (less.charAt(l) - '0') + (more.charAt(m) - '0') + carry;
            carry = sum / 10;

            num.prependDigit(sum % 10);
        }

        // Add the carry onto the remaining digits of the number `more`
        for (; m >= 0; m--) {
            // Sum of mth digit in `more`, and carry
            int sum = (more.charAt(m) - '0') + carry;
            carry = sum / 10;

            num.prependDigit(sum % 10);
        }

        // Answer as `String`
        final String answer = (carry > 0 ? Integer.toString(carry) : "").concat(
            num.getNum());
        return answer;
    }


    /**
     * Perform multiplication of two arbitrary-precision numbers.
     *
     * @param operand1
     *            first operand for the multiplication operation
     * @param operand2
     *            second operand for the multiplication operation
     * 
     * @return multiplication result of given operands
     */
    public String multiply(String operand1, String operand2) {
        // Operand with lesser number of digits
        String less;
        // Operand with greater or equal number of digits
        String more;

        if (operand1.length() < operand2.length()) {
            less = operand1;
            more = operand2;
        }
        else {
            less = operand2;
            more = operand1;
        }

        // Answer buffer as `String`
        String answer = "0";
        // Carry value for multiplying two digits
        int carry = 0;

        // Multiply each digit in `less` with all digits in `more`
        // one at a time; Append `less.length() - l - 1` trailing zeros
        // to product obtained in each (outer) iteration and add them
        // together to obtain the final product

        // `l` is index for `less` operand
        for (int l = less.length() - 1; l >= 0; l--, carry = 0) {
            // Number which will act as buffer for `answer`
            BigNum num = new BigNum();

            num.prependDigitNTimes(0, less.length() - l - 1);

            // `m` is index for `more` operand
            for (int m = more.length() - 1; m >= 0; m--) {
                // Product of lth digit in `less`, mth digit in `more`,
                // and carry added to it
                int product = (less.charAt(l) - '0') * (more.charAt(m) - '0')
                    + carry;
                carry = product / 10;

                num.prependDigit(product % 10);
            }

            // Product of lth digit of `less` with all the digits of `more`
            final String rowProduct = (carry > 0 ? Integer.toString(carry) : "")
                .concat(num.getNum());
            answer = add(answer, rowProduct);
        }

        return answer;
    }


    /**
     * Perform exponentiation of two arbitrary-precision numbers.
     *
     * @param x
     *            base number for the exponentiation operation
     * @param power
     *            power of base number for the exponentiation operation
     * 
     * @return exponentiation of x with power
     */
    public String exponent(String power, String x) {
        // Answer buffer as `String`
        String answer = "1";

        // Power of the exponentiation operation
        int n = Integer.parseInt(power);
        // Base number squared
        String xSquared = multiply(x, x);

        // In case of odd power, decrease `n` by 1, and
        // initialize `answer` with `x`
        if (n % 2 == 1) {
            n--;
            answer = x;
        }

        // Multiple `answer` to `xSquared` `n/2` times and
        // accumulate the product
        for (int i = 0; i < n / 2; i++) {
            answer = multiply(answer, xSquared);
        }

        return answer;
    }


    /**
     * Perform operation based on operator.
     *
     * @param operand1
     *            first operand for the operation
     * @param operand2
     *            second operand for the operation
     * @param operator
     *            operator that denotes operation to be performed
     * 
     * @return result of the operation
     */
    private String operate(String operand1, String operand2, String operator) {
        if (operator.equals("+")) {
            return add(operand1, operand2);
        }
        else if (operator.equals("*")) {
            return multiply(operand1, operand2);
        }
        else {
            return exponent(operand1, operand2);
        }
    }
}
