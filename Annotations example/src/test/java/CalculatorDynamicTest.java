import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CalculatorDynamicTest {

    private final Calculator calculator = new Calculator();

    @TestFactory
    Stream<DynamicTest> dynamicAdditionTestsRuntime() {
        Random random = new Random();
        return IntStream.range(0, 5).mapToObj(i -> {
            int a = random.nextInt(100); // Random number between 0 and 99
            int b = random.nextInt(100);
            int expected = a + b;

            return DynamicTest.dynamicTest(
                    "Adding " + a + " + " + b + " = " + expected,
                    () -> assertEquals(expected, calculator.add(a, b))
            );
        });
    }

    @TestFactory
    Stream<DynamicTest> dynamicSubtractionTestsRuntime() {
        Random random = new Random();
        return IntStream.range(0, 5).mapToObj(i -> {
            int a = random.nextInt(100); // Random number between 0 and 99
            int b = random.nextInt(100);
            int expected = a - b;

            return DynamicTest.dynamicTest(
                    "Subtracting " + b + " from " + a + " = " + expected,
                    () -> assertEquals(expected, calculator.subtract(a, b))
            );
        });
    }

    @TestFactory
    Stream<DynamicTest> dynamicMultiplicationTestsRuntime() {
        Random random = new Random();
        return IntStream.range(0, 5).mapToObj(i -> {
            int a = random.nextInt(20); // Smaller range for multiplication
            int b = random.nextInt(20);
            int expected = a * b;

            return DynamicTest.dynamicTest(
                    "Multiplying " + a + " x " + b + " = " + expected,
                    () -> assertEquals(expected, calculator.multiply(a, b))
            );
        });
    }

    @TestFactory
    Stream<DynamicTest> dynamicDivisionTestsRuntime() {
        Random random = new Random();
        return IntStream.range(0, 5).mapToObj(i -> {
            int a = random.nextInt(100) + 1; // Avoid 0 to prevent divide-by-zero
            int b = random.nextInt(99) + 1; // Avoid 0
            int expected = a / b;

            return DynamicTest.dynamicTest(
                    "Dividing " + a + " by " + b + " = " + expected,
                    () -> assertEquals(expected, calculator.divide(a, b))
            );
        });
    }

    @TestFactory
    Stream<DynamicTest> dynamicDivisionByZeroTestsRuntime() {
        return IntStream.range(0, 5).mapToObj(i -> {
            int a = new Random().nextInt(100); // Random numerator
            return DynamicTest.dynamicTest(
                    "Dividing " + a + " by 0 should throw ArithmeticException",
                    () -> assertThrows(ArithmeticException.class, () -> calculator.divide(a, 0))
            );
        });
    }
}
