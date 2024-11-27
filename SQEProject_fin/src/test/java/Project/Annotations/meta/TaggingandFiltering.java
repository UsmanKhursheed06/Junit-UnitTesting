package Project.Annotations.meta;

import static org.junit.jupiter.api.Assertions.*;

import Project.Calculator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Test class to demonstrate tagging and filtering in JUnit 5.
 * Tags are used to categorize tests for selective execution.
 */
class Calculator_TaggingAndFilteringTest {

    // Instance of the class to be tested
    private final Calculator taggingAndFiltering = new Calculator();

    /**
     * Test for the addition operation.
     * Tagged as "fast" because it is a quick test that involves basic arithmetic.
     */
    @Test
    @Tag("fast")
    void testAddition() {
        assertEquals(10, taggingAndFiltering.add(7, 3));
    }

    /**
     * Test for the subtraction operation.
     * Tagged as "fast" since it performs a basic arithmetic operation quickly.
     */
    @Test
    @Tag("fast")
    void testSubtraction() {
        assertEquals(4, taggingAndFiltering.subtract(7, 3));
    }

    /**
     * Test for the multiplication operation.
     * Tagged as "slow" to indicate that it might take longer to execute 
     * (e.g., in scenarios with larger input or complex algorithms).
     */
    @Test
    @Tag("slow")
    void testMultiplication() {
        assertEquals(21, taggingAndFiltering.multiply(7, 3));
    }

    /**
     * Test for the division operation.
     * Tagged as "slow" because it might involve more computational effort or validations.
     */
    @Test
    @Tag("slow")
    void testDivision() {
        assertEquals(2, taggingAndFiltering.divide(6, 3));
    }

    /**
     * Test to handle division by zero, which should throw an exception.
     * Tagged as "edge-case" because it tests a boundary condition or an unusual scenario.
     */
    @Test
    @Tag("edge-case")
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class,
                () -> taggingAndFiltering.divide(6, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
