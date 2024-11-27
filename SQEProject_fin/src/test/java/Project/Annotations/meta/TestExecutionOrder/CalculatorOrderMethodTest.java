package Project.Annotations.meta.TestExecutionOrder;

import Project.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;



// Specify test method order

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Calculator_MethodOrderTest {

    Calculator calculator;

    // Setup before each test
    @BeforeEach
    void setup() {
        System.out.println("Setting up the Calculator instance for the test.");
        calculator = new Calculator();
    }

    // Cleanup after each test
    @AfterEach
    void tearDown() {
        System.out.println("Test completed. Cleaning up resources.");
        calculator = null;
    }

    @Test
    @Order(1) // Ordered numerically
    void testAddition() {
        System.out.println("Executing testAddition");
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @Order(2) // Ordered numerically
    void testSubtraction() {
        System.out.println("Executing testSubtraction");
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    @Order(3) // Ordered numerically
    void testMultiplication() {
        System.out.println("Executing testMultiplication");
        assertEquals(10, calculator.multiply(2, 5));
    }

    @Test
    @Order(4) // Ordered numerically
    void testDivision() {
        System.out.println("Executing testDivision");
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    @Order(5) // Handling exceptional case
    void testDivisionByZero() {
        System.out.println("Executing testDivisionByZero");
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CalculatorAlphabeticalOrderTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        System.out.println("Setting up the Calculator instance for Alphabetical tests.");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after Alphabetical tests.");
        calculator = null;
    }

    @Test
    void A_testAddition() {
        System.out.println("Executing A_testAddition");
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    void B_testSubtraction() {
        System.out.println("Executing B_testSubtraction");
        assertEquals(1, calculator.subtract(5, 4));
    }

    @Test
    void C_testMultiplication() {
        System.out.println("Executing C_testMultiplication");
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void D_testDivision() {
        System.out.println("Executing D_testDivision");
        assertEquals(4, calculator.divide(20, 5));
    }

    @Test
    void E_testDivisionByZero() {
        System.out.println("Executing E_testDivisionByZero");
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
