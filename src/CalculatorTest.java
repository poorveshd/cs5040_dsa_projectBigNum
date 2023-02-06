import student.TestCase;

/**
 * CalculatorTest Class contains test cases for
 * `Calculator` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class CalculatorTest extends TestCase {
    /**
     * Test for invalid expressions with extra operator.
     */
    public void testCalculatorInvalidExpressionExtraOperator() {
        // Expression to be evaluated by `Calculator` instance
        final String expression = "8 2 + 9 * ^";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertNull(calc.evaluate(expression));
    }


    /**
     * Test for invalid expressions with extra operand.
     */
    public void testCalculatorInvalidExpressionExtraOperand() {
        // Expression to be evaluated by `Calculator` instance
        final String expression = "3 1 + 3 7 +";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertNull(calc.evaluate(expression));
    }


    /**
     * Test for a simple expression.
     */
    public void testCalculatorSimpleExpression() {
        // Expression to be evaluated by `Calculator` instance
        final String expression = "5 2 + 3 * 2 ^";
        // Expected answer
        final String answer = "441";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.evaluate(expression).equals(answer));
    }


    /**
     * Test for a complex expression.
     */
    public void testCalculatorComplexExpression() {
        // Expression to be evaluated by `Calculator` instance
        final String expression = String.join(" ", "2647246527634587",
            "9674786324578", "+", "4345", "*", "4", "^");
        // Expected answer
        final String answer = String.join("", "17761265004719901021797518",
            "90385565365220038519133693", "3622300520949094781640625");

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.evaluate(expression).equals(answer));
    }


    /**
     * Test for simple addition.
     */
    public void testCalculatorSimpleAdd() {
        // 1st operand for addition
        final String operand1 = "5";
        // 2nd operand for addition
        final String operand2 = "66";
        // Expected answer
        final String answer = "71";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.add(operand1, operand2).equals(answer));
    }


    /**
     * Test for complex addition with non-zero carry at the end.
     */
    public void testCalculatorComplexAddCarryNonZero() {
        // 1st operand for addition
        final String operand1 = "111111111111111111111111111111";
        // 2nd operand for addition
        final String operand2 = "888888888888888888888888888889";
        // Expected answer
        final String answer = "1000000000000000000000000000000";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.add(operand1, operand2).equals(answer));
    }


    /**
     * Test for complex addition with zero carry at the end.
     */
    public void testCalculatorComplexAddCarryZero() {
        // 1st operand for addition
        final String operand1 = "111111111111111111111111111111";
        // 2nd operand for addition
        final String operand2 = "788888888888888888888888888889";
        // Expected answer
        final String answer = "900000000000000000000000000000";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.add(operand1, operand2).equals(answer));
    }


    /**
     * Test for simple multiplication.
     */
    public void testCalculatorSimpleMultiply() {
        // 1st operand for multiplication
        final String operand1 = "5";
        // 2nd operand for multiplication
        final String operand2 = "66";
        // Expected answer
        final String answer = "330";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.multiply(operand1, operand2).equals(answer));
    }


    /**
     * Test for complex multiplication.
     */
    public void testCalculatorComplexMultiply() {
        // `Calculator` instance
        Calculator calc = new Calculator();
        // Buffer for actual result
        String result = "1";

        // Number for which factorial has to be computed
        final int factorialTarget = 35;

        // Calculating factorial of `factorialTarget`
        for (int i = 1; i <= factorialTarget; i++) {
            result = calc.multiply(result, Integer.toString(i));
        }

        // Expected answer
        final String answer = "10333147966386144929666651337523200000000";
        assertTrue(result.equals(answer));
    }


    /**
     * Test for simple exponentiation.
     */
    public void testCalculatorSimpleExponent() {
        // 1st operand for exponentiation
        final String operand1 = "0";
        // 2nd operand for exponentiation
        final String operand2 = "5";
        // Expected answer
        final String answer = "1";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.exponent(operand1, operand2).equals(answer));
    }


    /**
     * Test for complex exponentiation.
     */
    public void testCalculatorComplexExponent() {
        // 1st operand for exponentiation
        final String operand1 = "35";
        // 2nd operand for exponentiation
        final String operand2 = "13";
        // Expected answer
        final String answer = "972786042517719014174576083150881262357";

        // `Calculator` instance
        Calculator calc = new Calculator();
        assertTrue(calc.exponent(operand1, operand2).equals(answer));
    }
}
