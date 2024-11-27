import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // By default class makes instance for every method

class CalculatorLifecycleTest {

    private static Calculator calculator; // Shared instance for all tests
    private int testResult; // Example variable for storing intermediate results in each test

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("Initializing resources before all tests");
        calculator = new Calculator(); // Initialize shared Calculator instance
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Cleaning up resources after all tests");
        calculator = null; // Release shared resources
    }

    @BeforeEach
    void setUpBeforeEach() {
        System.out.println("Setting up before each test");
        testResult = 0; // Reset test-specific variables to ensure a clean state for each test
        System.out.println("testResult initialized to: " + testResult);
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Cleaning up after each test");
        System.out.println("Final value of testResult in this test: " + testResult);
        testResult = -1; // Simulating cleanup by setting it to an invalid or default value
        System.out.println("testResult reset to: " + testResult);
    }

    @Test
    void testAddition() {
        System.out.println("Running testAddition");
        testResult = calculator.add(2, 3);
        System.out.println("Intermediate result in testAddition: " + testResult);
        assertEquals(5, testResult, "Addition result should be correct");
    }

    @Test
    void testSubtraction() {
        System.out.println("Running testSubtraction");
        testResult = calculator.subtract(5, 3);
        System.out.println("Intermediate result in testSubtraction: " + testResult);
        assertEquals(2, testResult, "Subtraction result should be correct");
    }

    @Test
    void testMultiplication() {
        System.out.println("Running testMultiplication");
        testResult = calculator.multiply(4, 5);
        System.out.println("Intermediate result in testMultiplication: " + testResult);
        assertEquals(20, testResult, "Multiplication result should be correct");
    }

    @Test
    void testDivision() {
        System.out.println("Running testDivision");
        testResult = calculator.divide(10, 2);
        System.out.println("Intermediate result in testDivision: " + testResult);
        assertEquals(5, testResult, "Division result should be correct");
    }

    @Test
    void testDivisionByZero() {
        System.out.println("Running testDivisionByZero");
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Should throw ArithmeticException when dividing by zero");
    }
}
