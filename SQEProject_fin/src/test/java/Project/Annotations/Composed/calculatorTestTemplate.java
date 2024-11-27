/*
package Project.Annotations.Composed;

import Project.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTestTemplate {

    private final Calculator calculator = new Calculator();

    @Test
    @MethodSource("additionTestData")
    void testAdditionWithTemplate() {
        assertEquals(expected, calculator.add(a, b));
    }

    static Stream<Arguments> additionTestData() {
        return Stream.of(
                Arguments.of(5, 10, 15),
                Arguments.of(2, 3, 5)
        );
    }
}
*/
