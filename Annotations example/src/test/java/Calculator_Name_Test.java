import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@Tag("CalculatorTests") // Tag the entire test class
class Calculator_Name_Test
{

    Calculator calculator;

    @BeforeEach
    void setup() {
        System.out.println("Setting up the Calculator instance for the test.");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up resources after the test.");
        calculator = null;
    }

    @Test
    @DisplayName("Addition Test 1: Adding 2 + 3 should return 5")
    @Tag("Addition") // Specific tag for addition tests
    void testAddition() {
        System.out.println("Executing testAddition");
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Addition Test 2")
    @Tag("Addition") // Specific tag for addition tests
    void testAddition2() {
        System.out.println("Executing testAddition");
        assertEquals(5, calculator.add(3, 3));
    }

    @Test
    @DisplayName("Subtraction Test: Subtracting 5 - 3 should return 2")
    @Tag("Subtraction") // Specific tag for subtraction tests
    void testSubtraction() {
        System.out.println("Executing testSubtraction");
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    @DisplayName("Multiplication Test: Multiplying 2 * 5 should return 10")
    @Tag("Multiplication") // Specific tag for multiplication tests
    void testMultiplication() {
        System.out.println("Executing testMultiplication");
        assertEquals(10, calculator.multiply(2, 5));
    }

    @Test
    @DisplayName("Division Test: Dividing 10 / 5 should return 2")
    @Tag("Division") // Specific tag for division tests
    void testDivision() {
        System.out.println("Executing testDivision");
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    @DisplayName("Division by Zero Test: Should throw ArithmeticException")
    @Disabled("This test is currently disabled as it is not yet implemented")
    @Tag("ExceptionHandling") // Tag for exception-related tests
    void testDivisionByZero() {
        System.out.println("Executing testDivisionByZero");
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
