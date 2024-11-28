import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class CalculatorDependencyTest {

    private Calculator calculator;

    // Setup method
    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void testAdd(TestInfo testInfo, TestReporter testReporter) {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
        testReporter.publishEntry(testInfo.getDisplayName() + " executed");
    }

    @Test
    void testSubtract(TestInfo testInfo, TestReporter testReporter) {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
        testReporter.publishEntry(testInfo.getDisplayName() + " executed");
    }

    @Test
    void testMultiply(TestInfo testInfo, TestReporter testReporter) {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
        testReporter.publishEntry(testInfo.getDisplayName() + " executed");
    }

    @Test
    void testDivide(TestInfo testInfo, TestReporter testReporter) {
        int result = calculator.divide(6, 3);
        assertEquals(2, result);
        testReporter.publishEntry(testInfo.getDisplayName() + " executed");
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
