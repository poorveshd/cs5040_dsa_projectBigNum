// On my honor:
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
// with anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

/**
 * BigNumArithmetic Class contains main function.
 * It parses an input file (given as argument),
 * evaluates the expressions in that file and prints
 * it to standard output.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class BigNumArithmetic {
    /**
     * Parse input file, evaluate expressions mentioned in the file
     * and print the output to standard output.
     *
     * @param args
     *            command line arguments for the main function
     */
    public static void main(String[] args) {
        // File path for file that contains expressions
        final String inputFile = args[0];

        // FileParser instance used for parsing the expressions
        FileParser fp = new FileParser(inputFile);
        // Expressions from `inputFile` as linked list of `String`
        final LList<String> expressions = fp.readExpressions();

        // Calculator instance used for expression evaluation
        Calculator calc = new Calculator();

        // For every expression in `expressions`, evaluate and get the result
        // Print the result if expression is valid
        for (expressions.moveToStart(); !expressions.isAtEnd(); expressions
            .next()) {
            // Expression in current node of `expressions` list
            String expression = expressions.getValue();
            // Result obtained by evaluating the expression
            String evaluation = calc.evaluate(expression);

            // Print result along with the expression only if it is valid
            if (evaluation == null) {
                System.out.println(expression + " = ");
            }
            else {
                System.out.println(expression + " = " + evaluation);
            }
        }
    }
}
