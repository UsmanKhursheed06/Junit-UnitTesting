import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class CalculatorParametrizedTest {

    private final Calculator calculator = new Calculator();

    // Test for addition using ValueSource
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, 100})
    void testAdditionWithZero(int value) {
        assertEquals(value, calculator.add(value, 0),
                "Adding zero should return the same value");
    }

    // Test for addition using CsvSource
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "0, 5, 5",
            "-3, 3, 0",
            "-2, -3, -5"
    })
    void testAdditionWithCsvSource(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b),
                () -> "Expected " + a + " + " + b + " = " + expected);
    }

    // Test for subtraction using CsvFileSource
    @ParameterizedTest
    @CsvFileSource(resources = "/subtraction-test-data.csv", numLinesToSkip = 0)
    void testSubtractionWithCsvFileSource(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b),
                () -> "Expected " + a + " - " + b + " = " + expected);
    }

    // Test for multiplication using MethodSource
    static Stream<Arguments> provideMultiplicationArguments() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(0, 100, 0),
                Arguments.of(-5, 5, -25),
                Arguments.of(-3, -3, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMultiplicationArguments")
    void testMultiplicationWithMethodSource(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b),
                () -> "Expected " + a + " * " + b + " = " + expected);
    }

    // Test for division using ArgumentsSource
    static class DivisionArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(6, 3, 2),
                    Arguments.of(10, 2, 5),
                    Arguments.of(-9, -3, 3),
                    Arguments.of(-10, 2, -5)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(DivisionArgumentsProvider.class)
    void testDivisionWithArgumentsSource(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b),
                () -> "Expected " + a + " / " + b + " = " + expected);
    }

    // Test for division by zero
    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage(),
                "Dividing by zero should throw an exception");
    }
}
