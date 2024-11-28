import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorAssertionsTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        // AssertEquals: Check if two values are equal
        assertEquals(5, calculator.add(2, 3), "Addition result should be 5");

        // AssertNotEquals: Check if two values are not equal
        assertNotEquals(6, calculator.add(2, 3), "Addition result should not be 6");
    }

    @Test
    void testSubtract() {
        // AssertTrue: Check if a condition is true
        assertTrue(calculator.subtract(5, 3) == 2, "Subtraction result should be 2");

        // AssertFalse: Check if a condition is false
        assertFalse(calculator.subtract(5, 3) == 0, "Subtraction result should not be 0");
    }

    @Test
    void testMultiply() {
        // AssertEquals with a message: Check if multiplication result is as expected
        assertEquals(12, calculator.multiply(3, 4), "Multiplication result should be 12");

        // AssertNotNull: Check if the result is not null (valid for methods returning non-primitive objects)
        // Note: Here multiplication always returns a primitive, so this is just for demonstration.
        Integer result = calculator.multiply(3, 4);
        assertNotNull(result, "Result should not be null");
    }

    @Test
    void testDivide() {
        // AssertThrows: Check if an exception is thrown for invalid input
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Division by zero should throw ArithmeticException");

        // AssertDoesNotThrow: Ensure no exception is thrown for valid input
        assertDoesNotThrow(() -> calculator.divide(10, 2), "Division with valid input should not throw an exception");

        // AssertEquals: Check the division result
        assertEquals(5, calculator.divide(10, 2), "Division result should be 5");
    }

    @Test
    void testAdditionalAssertions() {
        // AssertAll: Group multiple assertions together
        assertAll(
                "Grouped Assertions for Add and Multiply",
                () -> assertEquals(7, calculator.add(3, 4), "Addition should be correct"),
                () -> assertEquals(12, calculator.multiply(3, 4), "Multiplication should be correct")
        );

        // AssertSame: Check if two objects refer to the same instance
        Integer a = 10;
        Integer b = a; // Same reference
        assertSame(a, b, "Both references should point to the same object");

        // AssertNotSame: Check if two objects do not refer to the same instance
        Integer c = new Integer(10); // Different object with the same value
        assertNotSame(a, c, "References should not point to the same object");

        // AssertArrayEquals: Compare arrays for equality
        int[] expectedArray = {2, 4, 6};
        int[] actualArray = {2, 4, 6};
        assertArrayEquals(expectedArray, actualArray, "Arrays should match");
    }
}
