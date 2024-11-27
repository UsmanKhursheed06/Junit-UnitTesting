package Project.Annotations.meta;

import Project.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.*;

        import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates the use of @TestInstance lifecycle modes for testing the Calculator class.
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD) // Default lifecycle: a new instance for each test method
class CalculatorTestInstanceLifeCycle {

    private Calculator calculator;

    /**
     * Initializes the Calculator instance before each test method.
     * In PER_METHOD lifecycle, this method runs for every test method.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("PER_METHOD: A new test instance is created.");
    }

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Single test instance shared across all test methods
class CalculatorTestPerClass {

    private Calculator calculator;

    /**
     * Initializes the Calculator instance once for the test class.
     * In PER_CLASS lifecycle, this method runs only once before all tests.
     */
    @BeforeAll
    void setUp() {
        calculator = new Calculator();
        System.out.println("PER_CLASS: A single test instance is shared across all tests.");
    }

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    void testDivision() {
        assertEquals(2, calculator.divide(4, 2));
    }
}

