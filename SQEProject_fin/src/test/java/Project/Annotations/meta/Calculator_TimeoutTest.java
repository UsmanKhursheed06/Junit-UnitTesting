package Project.Annotations.meta;

import Project.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    /**
     * Basic timeout test using JUnit 5's Assertions.assertTimeout.
     * This ensures that the method completes within the specified duration.
     */
    @Test
    void testAdditionWithTimeout() {
        assertTimeout(Duration.ofMillis(500), () -> {
            // Simulating some computation
            Thread.sleep(100); // Replace with actual logic if needed
            assertEquals(5, calculator.add(2, 3));
        });
    }

    /**
     * Timeout test using Assertions.assertTimeoutPreemptively.
     * This interrupts the execution if it exceeds the specified duration.
     */
    @Test
    void testSubtractionWithPreemptiveTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            // Simulating some computation
            Thread.sleep(100); // Replace with actual logic if needed
            assertEquals(1, calculator.subtract(3, 2));
        });
    }

    /**
     * Timeout annotation at the method level.
     * Test fails if it does not complete within the specified time.
     */
    @Test
    @Timeout(1) // Timeout of 1 second
    void testMultiplicationWithAnnotationTimeout() {
        // Simulating some computation
        try {
            Thread.sleep(500); // Replace with actual logic if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(6, calculator.multiply(2, 3));
    }

    /**
     * Timeout applied to long-running tasks using assertTimeout.
     * Example of a divide method.
     */
    @Test
    void testDivisionWithTimeout() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            // Simulating computation
            Thread.sleep(200); // Replace with actual logic if needed
            assertEquals(2, calculator.divide(4, 2));
        });
    }

    /**
     * Test for timeout on exceptional cases.
     * Verifies that exception handling completes within the specified time.
     */
    @Test
    void testDivisionByZeroWithTimeout() {
        assertTimeout(Duration.ofMillis(500), () -> {
            Exception exception = assertThrows(ArithmeticException.class,
                    () -> calculator.divide(6, 0));
            assertEquals("Cannot divide by zero", exception.getMessage());
        });
    }

    /**
     * Using preemptive timeout for long-running or stuck processes.
     */
    @Test
    void testStuckProcessWithPreemptiveTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            while (true) {
                // Simulating an infinite loop or stuck process
                if (System.currentTimeMillis() % 10 == 0) break;
            }
            assertTrue(true);
        });
    }
}
