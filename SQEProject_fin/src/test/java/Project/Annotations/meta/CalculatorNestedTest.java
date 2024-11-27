package Project.Annotations.meta;

import Project.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Sharing state for lifecycle methods across tests
class CalculatorNestedTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Creating a new Calculator instance before each test.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test complete. Cleaning up.");
    }

    @AfterAll
    void afterAllTests() {
        System.out.println("All tests for Calculator completed.");
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        @Test
        void testAdditionPositiveNumbers() {
            assertEquals(15, calculator.add(10, 5), "Addition of positive numbers failed");
        }

        @Test
        void testAdditionNegativeNumbers() {
            assertEquals(-15, calculator.add(-10, -5), "Addition of negative numbers failed");
        }

        @Test
        void testAdditionWithZero() {
            assertEquals(10, calculator.add(10, 0), "Addition with zero failed");
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        @Test
        void testSubtractionPositiveNumbers() {
            assertEquals(5, calculator.subtract(10, 5), "Subtraction of positive numbers failed");
        }

        @Test
        void testSubtractionNegativeNumbers() {
            assertEquals(-5, calculator.subtract(-10, -5), "Subtraction of negative numbers failed");
        }

        @Test
        void testSubtractionWithZero() {
            assertEquals(10, calculator.subtract(10, 0), "Subtraction with zero failed");
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        @Test
        void testMultiplicationPositiveNumbers() {
            assertEquals(50, calculator.multiply(10, 5), "Multiplication of positive numbers failed");
        }

        @Test
        void testMultiplicationNegativeNumbers() {
            assertEquals(50, calculator.multiply(-10, -5), "Multiplication of negative numbers failed");
        }

        @Test
        void testMultiplicationWithZero() {
            assertEquals(0, calculator.multiply(10, 0), "Multiplication with zero failed");
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {

        @BeforeEach
        void beforeEachTest() {
            System.out.println("Preparing for a division test.");
        }

        @AfterEach
        void afterEachTest() {
            System.out.println("Completed a division test.");
        }

        @Test
        void testDivisionPositiveNumbers() {
            assertEquals(2, calculator.divide(10, 5), "Division of positive numbers failed");
        }

        @Test
        void testDivisionNegativeNumbers() {
            assertEquals(2, calculator.divide(-10, -5), "Division of negative numbers failed");
        }

        @Test
        void testDivisionWithZero() {
            Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
            assertEquals("Cannot divide by zero", exception.getMessage(), "Division by zero did not throw the correct exception");
        }
    }
}
