package Project.Annotations.meta;

import Project.Calculator;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates parallel execution of tests in JUnit 5 for the Calculator class.
 */
class CalculatorParallelTest {

    private final Calculator calculator = new Calculator();

    /**
     * Test addition operation in parallel.
     * Verifies that the method produces correct results even when executed concurrently.
     */
    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
        System.out.println("Running testAddition on thread: " + Thread.currentThread().getName());
    }

    /**
     * Test subtraction operation in parallel.
     * Ensures that subtraction works correctly under concurrent execution.
     */
    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
        System.out.println("Running testSubtraction on thread: " + Thread.currentThread().getName());
    }

    /**
     * Test multiplication operation in parallel.
     * Validates multiplication correctness during concurrent execution.
     */
    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
        System.out.println("Running testMultiplication on thread: " + Thread.currentThread().getName());
    }

    /**
     * Test division operation in parallel.
     * Ensures division correctness and thread-safety when executed concurrently.
     */
    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(4, 2));
        System.out.println("Running testDivision on thread: " + Thread.currentThread().getName());
    }

    /**
     * Test handling of edge case (division by zero) in parallel.
     * Ensures exception handling works correctly during concurrent execution.
     */
    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> calculator.divide(6, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
        System.out.println("Running testDivisionByZero on thread: " + Thread.currentThread().getName());
    }
}
