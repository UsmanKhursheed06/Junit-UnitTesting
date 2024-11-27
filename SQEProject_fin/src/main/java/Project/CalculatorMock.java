package Project;

public class CalculatorMock {
    private Logger logger;

    // Constructor injection for Logger
    public CalculatorMock(Logger logger) {
        this.logger = logger;
    }

    public int add(int a, int b) {
        logger.log("Adding " + a + " and " + b); // Log the operation
        return a + b;
    }

    public int subtract(int a, int b) {
        logger.log("Subtracting " + b + " from " + a); // Log the operation
        return a - b;
    }

    public int multiply(int a, int b) {
        logger.log("Multiplying " + a + " and " + b); // Log the operation
        return a * b;
    }

    public int divide(int a, int b) {
        logger.log("Dividing " + a + " by " + b); // Log the operation
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
