package Project;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTesting {

    private final Calculator calculator = new Calculator();

    // 1. Assert Equality
    @Test
    void testAdd() {
        int result = calculator.add(5, 3);
        assertEquals(8, result, "Addition result should be 8");
    }

    @Test
    void testSubtract() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result, "Subtraction result should be 2");
    }

    @Test
    void testMultiply() {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result, "Multiplication result should be 6");
    }

    @Test
    void testDivide() {
        int result = calculator.divide(6, 3);
        assertEquals(2, result, "Division result should be 2");
    }

    // 2. Assert True / False
    @Test
    void testIsPositive() {
        assertTrue(calculator.add(5, 3) > 0, "Sum should be positive");
        assertFalse(calculator.subtract(3, 5) > 0, "Difference should not be positive");
    }

    // 3. Assert Null / Not Null
    @Test
    void testNotNull() {
        Integer result = calculator.add(5, 3);
        assertNotNull(result, "The result should not be null");
    }

    @Test
    void testNull() {
        Integer result = null;
        assertNull(result, "The result should be null");
    }

    // 4. Assert Equals with floating point precision
    @Test
    void testDivideWithPrecision() {
        double result = 10.0 / 3.0;
        assertEquals(3.333, result, 0.001, "The result should be 3.333 within tolerance of 0.001");
    }

    // 5. Assert Exception
    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage(), "Exception message should match");
    }

    // 6. Assert All
    @Test
    void testAddAndMultiply() {
        int addResult = calculator.add(5, 3);
        int multiplyResult = calculator.multiply(2, 3);
        assertAll("Calculator tests",
                () -> assertEquals(8, addResult, "Addition result should be 8"),
                () -> assertEquals(6, multiplyResult, "Multiplication result should be 6")
        );
    }

    // 7. Assert Array
    @Test
    void testArrayEquality() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    // 8. Assert Iterable
    @Test
    void testIterableEquality() {
        Iterable<Integer> expected = List.of(1, 2, 3);
        Iterable<Integer> actual = List.of(1, 2, 3);
        assertIterableEquals(expected, actual, "Iterables should be equal");
    }

    // 9. Assert Lines (used for checking text lines)
    @Test
    void testLinesEquality() {
        assertLinesMatch(List.of("Line1", "Line2"), List.of("Line1", "Line2"), "Lines should match in order");
    }

    // 10. Assert Timeout
    @Test
    void testTimeOut() {
        assertTimeout(java.time.Duration.ofMillis(100), () -> {
            // Simulate a method that should complete in less than 100 ms
            calculator.add(1, 2);
        });
    }

    // 11. Assert Timeout Preemptively
    @Test
    void testTimeoutPreemptively() {
        assertTimeoutPreemptively(java.time.Duration.ofMillis(100), () -> {
            // Simulate a method that should complete in less than 100 ms
            calculator.add(1, 2);
        });
    }
}
