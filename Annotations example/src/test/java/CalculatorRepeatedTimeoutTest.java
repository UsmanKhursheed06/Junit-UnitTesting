import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class CalculatorRepeatedTimeoutTest {

    private final Calculator calculator = new Calculator();

    // Test addition with @RepeatedTest
    @RepeatedTest(5)
    void testAdditionRepeated() {
        int result = calculator.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    // Test subtraction with @Timeout (failing if it takes more than 1 second)
    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testSubtractionWithinTimeout() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result, "10 - 5 should equal 5");
    }

    // Test multiplication with @RepeatedTest and @Timeout together
    @RepeatedTest(3)
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // Timeout per iteration
    void testMultiplicationRepeatedWithTimeout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testDivisionWithinTimeout() {
        int result = calculator.divide(100, 5);
        assertEquals(20, result, "100 / 5 should equal 20");
    }

    // Test division by zero with @RepeatedTest
    @RepeatedTest(3)
    void testDivisionByZeroRepeated() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage(),
                "Dividing by zero should throw an ArithmeticException");
    }
}
