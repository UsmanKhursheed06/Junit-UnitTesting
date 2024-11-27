package Project.Annotations.Composed;

import static org.junit.jupiter.api.Assertions.*;

import Project.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorExceptionHandlingTest {

    // Create an instance of the Calculator class to test
    private final Calculator calculator = new Calculator();

    // Test case for uncaught exception (ArithmeticException)
    @Test
    void failsDueToUncaughtException() {
        // This test checks that the divide method throws an ArithmeticException
        // when dividing by zero. The exception is not caught inside the test
        // method, so JUnit will mark the test as failed if the exception occurs.
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
    }

    // Test case for failed assertion (AssertionError)
    @Test
    void failsDueToUncaughtAssertionError() {
        // In this test, we're intentionally asserting that 1 + 1 equals 99,
        // which is incorrect. This will cause the test to fail because the
        // actual result (2) does not match the expected (99).
        assertEquals(99, calculator.add(1, 1)); // This will fail
    }

    // Test case for asserting that a specific exception is thrown (using assertThrows)
    @Test
    void testExpectedExceptionIsThrown() {
        // We use assertThrows to check that an ArithmeticException is thrown
        // when attempting to divide by zero. The exception message is also verified.
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);  // Attempt to divide by zero
        });

        // Verify that the exception message is exactly what we expect.
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // Test case for asserting that a specific exception is thrown (using assertThrowsExact)
    @Test
    void testExpectedExceptionIsThrownExact() {
        // Here, we use assertThrowsExactly to check that the exact exception
//        // type (ArithmeticException) is thrown, not any of its subclasses.
//        Here, we use assertThrowsExactly() to check that the exception thrown is exactly of type ArithmeticException, not any subclass. We also verify the exception message.
//        The second assertion intentionally expects a RuntimeException, which will fail since ArithmeticException is expected.
        ArithmeticException exception = assertThrowsExactly(ArithmeticException.class, () -> {
            calculator.divide(1, 0);  // Attempt to divide by zero
        });

        // Verify that the exception message is correct.
        assertEquals("Cannot divide by zero", exception.getMessage());

        // The next line is intentionally incorrect because we are expecting an
        // ArithmeticException, not a subclass of it. This will fail.
        assertThrowsExactly(RuntimeException.class, () -> {
            calculator.divide(1, 0);  // Attempt to divide by zero
        });
    }

    // Test case to assert no exception is thrown (assertDoesNotThrow)
    @Test
    void testExceptionIsNotThrown() {
        // assertDoesNotThrow checks that no exception occurs when performing
        // these valid operations.
        assertDoesNotThrow(() -> {
            // Test valid operations that should not throw exceptions
            calculator.add(1, 1);      // Addition
            calculator.subtract(2, 1); // Subtraction
            calculator.multiply(2, 3); // Multiplication
        });
    }

    // Test case for valid addition operation
    @Test
    void testAdd() {
        // Verify that adding 2 and 3 gives the correct result (5)
        assertEquals(5, calculator.add(2, 3));
    }

    // Test case for valid subtraction operation
    @Test
    void testSubtract() {
        // Verify that subtracting 2 from 3 gives the correct result (1)
        assertEquals(1, calculator.subtract(3, 2));
    }

    // Test case for valid multiplication operation
    @Test
    void testMultiply() {
        // Verify that multiplying 2 and 3 gives the correct result (6)
        assertEquals(6, calculator.multiply(2, 3));
    }

    // Test case for valid division operation
    @Test
    void testDivide() {
        // Verify that dividing 6 by 3 gives the correct result (2)
        assertEquals(2, calculator.divide(6, 3));
    }

    // Test case for invalid division by zero (ArithmeticException)
    @Test
    void testDivideByZero() {
        // This test checks that an ArithmeticException is thrown when dividing
        // by zero. We also check that the exception message matches our expectation.
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);  // Division by zero
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // Test case for invalid division by zero (assertThrowsExactly)
    @Test
    void testDivideByZeroExactly() {
        // This test uses assertThrowsExactly to ensure the exact exception type
        // (ArithmeticException) is thrown when dividing by zero.
        ArithmeticException exception = assertThrowsExactly(ArithmeticException.class, () -> {
            calculator.divide(1, 0);  // Division by zero
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
