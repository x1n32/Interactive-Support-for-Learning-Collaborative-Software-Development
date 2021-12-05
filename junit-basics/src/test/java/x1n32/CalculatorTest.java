package x1n32;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Testing is not debugging. We take a single object, and test it, by invoking
 * it and making sure we get the correct result. Testing should be repeatable,
 * self-verifying, runs simultaneously, and return the same results.
 *
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    void initEach() {
        calculator = new Calculator();
        System.out.println("Now running tests");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Nested
    class AddTest {

        @Test
        public void shouldAnswerWithTrue() {
            assertTrue(true);
        }

        @Test
        public void shouldAnswerWithFalse() {
            assertFalse(false);
        }

        @Test
        void testAddingTwoPositives() {
            assertEquals(2, calculator.add(1, 1),
                    "Add method should return the sum of two numbers");
        }

        @Test
        void testAddingTwoNegatives() {
            assertEquals(-2, calculator.add(-1, -1),
                    "Add method should return the sum of two numbers");
        }

        @Test
        void testAddingAPositiveAndANegative() {
            assertEquals(0, calculator.add(-1, 1),
                    "Add method should return the sum of two numbers");
        }
    }

    @Test
    void testMultiply() {
        assertAll(
                () -> assertEquals(0, calculator.multiply(1, 0), "1*0 = 0. Numbers must have been changed if there's an error."),
                () -> assertEquals(1, calculator.multiply(1, 1), "1*1 = 1"),
                () -> assertEquals(6, calculator.multiply(2, 3), "2*3 = 6")
        );
    }

    @Test
    public void testFiftyTimesTwo_ReturnsOneHundred() {
        // Arrange      
        final float expected = 100;
        // Act      
        final float actual = calculator.multiply(50, 2);
        // Assert      
        assertEquals(actual, expected, "Should return 100. 50 x 2 = 100");
    }

    @Test
    void computeCircleArea() {
        assertEquals(314.1592653589793, calculator.computeCircleArea(10),
                "Should return right circle area");
    }

    @Test
    void testDivide() {
        assertAll(
                () -> assertEquals(10, calculator.divide(100, 10)),
                () -> assertEquals(100, calculator.divide(150, 1.5f)),
                () -> assertEquals(0.5, calculator.divide(50, 100))
        );
    }

    @Test
    void testDivideArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(4, 0),
                "Divide should throw ArithmeticException when denominator is zero");
    }

    /**
     * Test of add method, of class Calculator.
     */
    @org.junit.Test
    public void testAdd() {
        System.out.println("add");
        float a = 0.0F;
        float b = 0.0F;
        Calculator instance = new Calculator();
        float expResult = 0.0F;
        float result = instance.add(a, b);
        assertEquals(expResult, result, 0.0);

      
    }

    /**
     * Test of subtract method, of class Calculator.
     */
    @org.junit.Test
    public void testSubtract() {
        System.out.println("subtract");
        float a = 0.0F;
        float b = 0.0F;
        Calculator instance = new Calculator();
        float expResult = 0.0F;
        float result = instance.subtract(a, b);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of computeCircleArea method, of class Calculator.
     */
    @org.junit.Test
    public void testComputeCircleArea() {
        System.out.println("computeCircleArea");
        double radius = 0.0;
        Calculator instance = new Calculator();
        double expResult = 0.0;
        double result = instance.computeCircleArea(radius);
        assertEquals(expResult, result, 0.0);
  
    }

    /**
     * Test of main method, of class Calculator.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Calculator.main(args);
  
    }

}
