package Project.Annotations.Composed;


import Project.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;
        import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates assumption-based testing in JUnit 5 for the Calculator class.
 */
class CalculatorAssumptionsTesting {

    private final Calculator calculator = new Calculator();

    /**
     * Test using assumeTrue to skip test if a condition is not met.
     */
    @Test
    void testAdditionWithAssumeTrue() {
        assumeTrue(System.getProperty("os.name").contains("Windows"),
                "Test skipped: Not running on Windows.");
        // Test logic
        assertEquals(5, calculator.add(2, 3));
        System.out.println("Running testAdditionWithAssumeTrue on Windows.");
    }

    /**
     * Test using assumeFalse to skip test if a condition is met.
     */
    @Test
    void testSubtractionWithAssumeFalse() {
        assumeFalse(System.getProperty("os.name").contains("Linux"),
                "Test skipped: Running on Linux.");
        // Test logic
        assertEquals(1, calculator.subtract(3, 2));
        System.out.println("Running testSubtractionWithAssumeFalse on non-Linux systems.");
    }

    /**
     * Test using assumingThat to conditionally execute a block of code.
     */
    @Test
    void testMultiplicationWithAssumingThat() {
        assumingThat(System.getProperty("java.version").startsWith("11"), () -> {
            // Code block that runs only if Java version starts with "11"
            assertEquals(6, calculator.multiply(2, 3));
            System.out.println("Java 11 detected. Executing additional multiplication logic.");
        });
        // This code always runs
        assertEquals(6, calculator.multiply(2, 3));
    }

    /**
     * Test to demonstrate skipping when assumption fails.
     */
    @Test
    void testDivisionWithFailedAssumption() {
        assumeTrue(false, "Skipping because the condition is false.");
        // This test will not run because the assumption fails
        assertEquals(2, calculator.divide(4, 2));
        System.out.println("This message will not be printed because the assumption failed.");
    }

    /**
     * Test for division by zero using assumptions.
     * Assumes a precondition for input before running.
     */
    @Test
    void testDivisionByZeroWithAssumption() {
        int denominator = 0;
        assumeTrue(denominator != 0, "Skipping test: Cannot divide by zero.");
        // This test will be skipped due to failed assumption
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calculator.divide(6, denominator));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
