package Project.Annotations.Composed;

import Project.Calculator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Demonstrates repeated testing in JUnit 5 for the Calculator class.
 */
class CalculatorRepeatedTest {

    private final Calculator calculator = new Calculator();

    /**
     * Repeated test for addition to validate consistency.
     * Runs the test 5 times with the same input and verifies the output.
     */
    @RepeatedTest(5) // Runs the test 5 times
    void testAdditionRepeatedly() {
        assertEquals(5, calculator.add(2, 3));
        System.out.println("Executing testAdditionRepeatedly");
    }

    /**
     * Repeated test for subtraction, displaying the repetition info.
     * Repeats the test 3 times and prints the current iteration.
     */
    @RepeatedTest(3) // Runs the test 3 times
    void testSubtractionRepeatedly(RepetitionInfo repetitionInfo) {
        assertEquals(1, calculator.subtract(3, 2));
        System.out.printf("Repetition %d of %d for testSubtractionRepeatedly%n",
                repetitionInfo.getCurrentRepetition(),
                repetitionInfo.getTotalRepetitions());
    }

    /**
     * Repeated test for multiplication using dynamic inputs based on repetition index.
     * Varies the input with each repetition to verify behavior for different values.
     */
    @RepeatedTest(4) // Runs the test 4 times
    void testMultiplicationRepeatedly(RepetitionInfo repetitionInfo) {
        int base = repetitionInfo.getCurrentRepetition();
        int result = calculator.multiply(base, 2);
        assertEquals(base * 2, result);
        System.out.printf("Repetition %d: %d * 2 = %d%n", base, base, result);
    }

    /**
     * Repeated test for division, skipping invalid scenarios dynamically.
     * Simulates dynamic skipping by throwing exceptions for invalid repetitions.
     */
    @RepeatedTest(3) // Runs the test 3 times
    void testDivisionRepeatedly(RepetitionInfo repetitionInfo) {
        int denominator = repetitionInfo.getCurrentRepetition() - 1; // Denominator becomes 0 for the first iteration
        if (denominator == 0) {
            System.out.println("Skipping repetition due to division by zero.");
            return; // Skip invalid cases dynamically
        }
        assertEquals(6 / denominator, calculator.divide(6, denominator));
        System.out.printf("Repetition %d: 6 / %d%n", repetitionInfo.getCurrentRepetition(), denominator);
    }

    /**
     * Stress test for addition using repeated tests to simulate heavy computation.
     * Verifies that the addition method produces correct results over multiple iterations.
     */
    @RepeatedTest(100) // Stress test with 100 repetitions
    void stressTestAddition() {
        assertEquals(7, calculator.add(4, 3));
    }
}
