import student.TestCase;

/**
 * FileParserTest Class contains test cases for
 * `FileParser` class.
 * 
 * @author Gautam Sharma <gautams@vt.edu>
 * @author Poorvesh Dongre <poorvesh@vt.edu>
 * @version 2/13/2022
 */
public class FileParserTest extends TestCase {
    /**
     * Test for stripping arbitrary number of prefixed zeros.
     */
    public void testFileParserPrefixZeros() {
        // Expected expressions
        LList<String> expectedResult = new LList<String>();
        expectedResult.append("0 2 + 5 *");

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("test_fileparser_zeros.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for stripping arbitrary number of whitespace characters.
     */
    public void testFileParserWhiteSpace() {
        LList<String> expectedResult = new LList<String>();
        // Expected expressions
        expectedResult.append("52 2 + 3 ^");

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("test_fileparser_whitespace.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for parsing an empty file.
     */
    public void testFileParserEmptyFile() {
        // Expected expressions
        LList<String> expectedResult = new LList<String>();

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("test_fileparser_empty.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for file containing multiple expressions.
     */
    public void testFileParserMultipleExpressions() {
        // Expected expressions
        LList<String> expectedResult = new LList<String>();
        expectedResult.append("32 5 + 2 *");
        expectedResult.append("5 1 * 2 ^");
        expectedResult.append("1 10 3 ^");
        expectedResult.append("27 2 * +");

        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser(
            "test_fileparser_multipleexpressions.txt");
        // Expressions parsed by `fp`
        final LList<String> result = fp.readExpressions();

        assertTrue(result.equals(expectedResult));
    }


    /**
     * Test for file that doesn't exist.
     */
    public void testFileParserFileDoesNotExist() {
        // `FileParser` instance for parsing given file
        FileParser fp = new FileParser("does_not_exist.txt");

        assertNull(fp.readExpressions());
    }
}
