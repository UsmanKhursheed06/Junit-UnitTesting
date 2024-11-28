import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.Test;

class CalculatorAssumptionsTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAddWithAssumption() {
        // AssumeTrue: Test will run only if the condition is true
        assumeTrue(System.getProperty("os.name").startsWith("Windows"), "Test runs only on Windows OS");
        assertEquals(5, calculator.add(2, 3), "Addition should be 5");
    }

    @Test
    void testSubtractWithAssumption() {
        // AssumeFalse: Test will run only if the condition is false
        assumeFalse(System.getenv("ENV").equals("PROD"), "Test skips in production environment");
        assertEquals(2, calculator.subtract(5, 3), "Subtraction should be 2");
    }

    @Test
    void testMultiplyWithAssumingThat() {
        // AssumingThat: Runs specific assertions only if the condition is true, rest of the test still executes
        assumingThat(
                System.getProperty("java.version").startsWith("17"),
                () -> {
                    assertEquals(12, calculator.multiply(3, 4), "Multiplication should be 12 for Java 17");
                }
        );
        // This part always executes regardless of the assumption
        assertEquals(15, calculator.multiply(3, 5), "Multiplication should be 15");
    }

    @Test
    void testDivideWithAssumption() {
        // AssumeTrue with a dynamic condition
        int divisor = 2;
        assumeTrue(divisor != 0, "Test runs only if divisor is not zero");
        assertEquals(5, calculator.divide(10, divisor), "Division result should be 5");

        // Fail-safe assumption
        assumeTrue(() -> calculator.divide(10, divisor) > 0, "Result of division should be positive");
    }

    @Test
    void testAdditionalAssumptions() {
        // AssumeTrue with System properties
        assumeTrue("TEST".equals(System.getenv("TEST_ENV")), "Runs only in TEST environment");

        // AssumeFalse with a specific scenario
        assumeFalse(calculator.add(0, 0) != 0, "Sum of 0 + 0 should be 0");

        // AssumingThat for conditional execution of a part of the test
        assumingThat(
                calculator.subtract(10, 5) == 5,
                () -> assertEquals(5, calculator.subtract(10, 5), "Conditionally testing subtraction")
        );
    }
}
