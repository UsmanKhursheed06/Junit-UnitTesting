package Project.Annotations.meta.TestExecutionOrder;

import Project.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

// Top-level test class
@TestClassOrder(ClassOrderer.OrderAnnotation.class) // Specify ordering for nested test classes
class Calculator_OrderByClassTest {

    // Shared Calculator instance
    Calculator calculator;

    // Setup before each test
    @BeforeEach
    void setup() {
        System.out.println("Setting up the Calculator instance for the test.");
        calculator = new Calculator();
    }

    // Cleanup after each te25st
    @AfterEach
    void tearDown() {
        System.out.println("Test completed. Cleaning up resources.");
        calculator = null;
    }

    // Nested class to test arithmetic operations
    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Use numeric order for these tests
    @Order(1) // This nested class runs first
    class ArithmeticTests {

        @Test
        @Order(1) // First arithmetic test
        void testAddition() {
            System.out.println("Executing ArithmeticTests -> testAddition");
            assertEquals(5, calculator.add(2, 3));
        }

        @Test
        @Order(2) // Second arithmetic test
        void testSubtraction() {
            System.out.println("Executing ArithmeticTests -> testSubtraction");
            assertEquals(2, calculator.subtract(5, 3));
        }

        @Test
        @Order(3) // Third arithmetic test
        void testMultiplication() {
            System.out.println("Executing ArithmeticTests -> testMultiplication");
            assertEquals(10, calculator.multiply(2, 5));
        }

        @Test
        @Order(4) // Fourth arithmetic test
        void testDivision() {
            System.out.println("Executing ArithmeticTests -> testDivision");
            assertEquals(2, calculator.divide(10, 5));
        }
    }

    // Nested class to test exceptional scenarios
    @Nested
    @TestMethodOrder(MethodOrderer.Alphanumeric.class) // Use alphabetical order for these tests
    @Order(2) // This nested class runs after ArithmeticTests
    class ExceptionalTests {

        @Test
        void A_testDivisionByZero() {
            System.out.println("Executing ExceptionalTests -> A_testDivisionByZero");
            assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        }

        @Test
        void B_testAdditionWithNegativeNumbers() {
            System.out.println("Executing ExceptionalTests -> B_testAdditionWithNegativeNumbers");
            assertEquals(-1, calculator.add(2, -3));
        }
    }
}
