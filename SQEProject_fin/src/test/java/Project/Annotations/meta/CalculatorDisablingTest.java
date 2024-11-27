package Project.Annotations.meta;

import Project.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

@Disabled("Class disabled for demonstration purposes")
public class CalculatorDisablingTest {

    Calculator calculator = new Calculator();

    // Regular test
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    // Disabled using @Disabled annotation
    @Disabled("Subtraction test temporarily disabled")
    @Test
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    // Disabled based on OS
    @DisabledOnOs(OS.WINDOWS)
    @Test
    void testMultiplyOnNonWindows() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    // Disabled based on JRE
    @DisabledOnJre(JRE.JAVA_8)
    @Test
    void testMultiplyOnNonJava8() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    // Conditionally disabled using a custom condition


    // Disabled using assumptions
    @Test
    void testDivideWithAssumption() {
        assumeTrue(System.getProperty("os.name").contains("Linux"), "Test runs only on Linux");
        assertEquals(2, calculator.divide(4, 2));
    }

    // Programmatically skipped based on an environment variable
    @Test
    void testDivideProgrammatically() {
        if (System.getenv("SKIP_DIVISION_TESTS") != null) {
            return; // Skip the test
        }
        assertEquals(2, calculator.divide(4, 2));
    }
}