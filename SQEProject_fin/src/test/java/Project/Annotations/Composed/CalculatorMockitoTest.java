package Project.Annotations.Composed;

import Project.CalculatorMock;
import Project.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // This is necessary for Mockito with JUnit 5
public class CalculatorMockitoTest {

    @Mock
    Logger logger;  // Mock the Logger class

    @InjectMocks
    CalculatorMock calculator;  // Inject the mocked Logger into the Calculator

    @Test
    void testAdd() {
        // Arrange
        int a = 5, b = 3;
        when(logger.log("Adding " + a + " and " + b)).thenReturn("Log message");

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(8, result);  // Verify the result
        verify(logger).log("Adding " + a + " and " + b);  // Verify if log method was called
    }

    @Test
    void testSubtract() {
        // Arrange
        int a = 5, b = 3;
        when(logger.log("Subtracting " + b + " from " + a)).thenReturn("Log message");

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(2, result);
        verify(logger).log("Subtracting " + b + " from " + a); // Verify log behavior
    }

    @Test
    void testMultiply() {
        // Arrange
        int a = 2, b = 3;
        when(logger.log("Multiplying " + a + " and " + b)).thenReturn("Log message");

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(6, result);
        verify(logger).log("Multiplying " + a + " and " + b); // Verify log behavior
    }

    @Test
    void testDivide() {
        // Arrange
        int a = 6, b = 3;
        when(logger.log("Dividing " + a + " by " + b)).thenReturn("Log message");

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(2, result);
        verify(logger).log("Dividing " + a + " by " + b); // Verify log behavior
    }

    @Test
    void testDivideByZero() {
        // Act & Assert
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
