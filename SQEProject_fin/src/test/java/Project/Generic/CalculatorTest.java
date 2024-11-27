package Project.Generic;

import Project.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // @TestInstance Example
@TestMethodOrder(MethodOrderer.class)        // @TestMethodOrder Example
@DisplayName("Calculator Tests with JUnit Annotations") // @DisplayName Example
class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    void setupAll() {
        System.out.println("@BeforeAll: Initialize resources before all tests.");
        calculator = new Calculator();
    }

    @BeforeEach
    void setupEach() {
        System.out.println("@BeforeEach: Preparing for a test.");
    }

    @Test
    @Order(1)
    @Tag("Arithmetic") // @Tag Example
    @DisplayName("Addition Test") // @DisplayName Example
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "Addition should return correct sum");
    }

    @Test
    @Order(2)
    @Tag("Arithmetic")
    @DisplayName("Subtraction Test")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "Subtraction should return correct difference");
    }

    @Test
    @Order(3)
    @Disabled("Disabled for demo purposes") // @Disabled Example
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "Multiplication should return correct product");
    }

    @Test
    @Order(4)
    @Timeout(1) // @Timeout Example
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Division by zero should throw exception");
    }


    @Order(5)
    @ParameterizedTest // @ParameterizedTest Example
    @ValueSource(ints = {0, 1, -1, 100})
    void testAdditionWithZero(int value) {
        assertEquals(value, calculator.add(value, 0), "Adding zero should return the same value");
    }


    @Order(6)
    @RepeatedTest(value=3,name = "Running repetition {currentRepetition} of {totalRepetitions}") // @RepeatedTest Example
    void testRepeatedAddition() {
        assertEquals(4, calculator.add(2, 2), "Adding 2 + 2 should always return 4");
    }

    @TestFactory // @TestFactory Example
    @Order(7)
    Stream<DynamicTest> dynamicTestsWithGeneratedData() {
        return IntStream.range(1, 5) // Generate a range of numbers
                .mapToObj(i -> DynamicTest.dynamicTest(
                        "Test addition with input " + i,
                        () -> assertEquals(i + i, calculator.add(i, i))
                ));
    }


//    @TestTemplate // @TestTemplate Example
//    @ExtendWith(CalculatorTemplateProvider.class)
//    void testTemplate(String operation, int result) {
//        if (operation.equals("add")) {
//            assertEquals(result, calculator.add(1, 1));
//        } else if (operation.equals("multiply")) {
//            assertEquals(result, calculator.multiply(2, 2));
//        }
//    }

    @Test
    @Order(8)
    void testTempDir(@TempDir Path tempDir) throws IOException { // @TempDir Example
        Path testFile = tempDir.resolve("testFile.txt");
        Files.writeString(testFile, "JUnit 5 TempDir Example");
        assertTrue(Files.exists(testFile));
    }

    @AfterEach
    void teardownEach() {
        System.out.println("@AfterEach: Cleaning up after a test.");
    }

    @AfterAll
    void teardownAll() {
        System.out.println("@AfterAll: Releasing resources after all tests.");
    }

    //@Nested Example
    @Nested
    @DisplayName("Nested Test Class")
    class NestedTests {
        @Test
        void testNestedAddition() {
            assertEquals(7, calculator.add(3, 4));
        }
    }
}
