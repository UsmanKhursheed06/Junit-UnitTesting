package Project.Annotations.Composed;


import Project.Calculator;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class CalculatorDynamicTests {

    private final Calculator calculator = new Calculator();

    @TestFactory
    Stream<DynamicTest> dynamicTestsForAddition() {
        return Stream.of(
                DynamicTest.dynamicTest("Add 1 + 1", () -> assertEquals(2, calculator.add(1, 1))),
                DynamicTest.dynamicTest("Add 2 + 3", () -> assertEquals(5, calculator.add(2, 3))),
                DynamicTest.dynamicTest("Add 7 + 10", () -> assertEquals(17, calculator.add(7, 10)))
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsForSubtraction() {
        return Stream.of(
                DynamicTest.dynamicTest("Subtract 3 - 2", () -> assertEquals(1, calculator.subtract(3, 2))),
                DynamicTest.dynamicTest("Subtract 10 - 5", () -> assertEquals(5, calculator.subtract(10, 5))),
                DynamicTest.dynamicTest("Subtract 9 - 4", () -> assertEquals(5, calculator.subtract(9, 4)))
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsForMultiplication() {
        return Stream.of(
                DynamicTest.dynamicTest("Multiply 2 * 3", () -> assertEquals(6, calculator.multiply(2, 3))),
                DynamicTest.dynamicTest("Multiply 5 * 4", () -> assertEquals(20, calculator.multiply(5, 4))),
                DynamicTest.dynamicTest("Multiply 7 * 8", () -> assertEquals(56, calculator.multiply(7, 8)))
        );
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsForDivision() {
        return Stream.of(
                DynamicTest.dynamicTest("Divide 6 / 2", () -> assertEquals(3, calculator.divide(6, 2))),
                DynamicTest.dynamicTest("Divide 10 / 5", () -> assertEquals(2, calculator.divide(10, 5))),
                DynamicTest.dynamicTest("Divide 15 / 3", () -> assertEquals(5, calculator.divide(15, 3)))
        );
    }
}
