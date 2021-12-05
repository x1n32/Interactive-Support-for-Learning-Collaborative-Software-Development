package x1n32;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Calculator2Test {

    private Calculator2 calculator2;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    void initEach() {
        calculator2 = new Calculator2();
        System.out.println("Now running tests");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Nested
    class AddTest {

        @Test
        public void squareNumberCheck() {
            System.out.println("Doing Square number checks. Should return the input value multiplied by itself. e.g. 2 * 2 = 4");
            assertAll(
                    () -> assertEquals(1, calculator2.squareOfB(1)),
                    () -> assertEquals(1, calculator2.squareOfB(-1)),
                    () -> assertEquals(4, calculator2.squareOfB(2)),
                    () -> assertEquals(25, calculator2.squareOfB(5)),
                    () -> assertEquals(10000, calculator2.squareOfB(100)),
                    () -> assertEquals(0, calculator2.squareOfB(0)),
                    () -> assertEquals(100, calculator2.squareOfB(-10)),
                    () -> assertEquals(225, calculator2.squareOfB(-15)),
                    () -> assertEquals(0.25, calculator2.squareOfB(0.5f))
            );
        }

        @Test
        public void fouracCheck() {
            System.out.println("Doing 4 *a *c");
            assertAll(
                    () -> assertEquals(4, calculator2.fourAC(1, 1), " 4 * 1 * 1 = 4"),
                    () -> assertEquals(0, calculator2.fourAC(1, 0), " 4 * 1 * 0 = 0"),
                    () -> assertEquals(0, calculator2.fourAC(0, 1), " 4 * 0 * 1 = 0"),
                    () -> assertEquals(400, calculator2.fourAC(10, 10), " 4 * 10 * 10 = 400"),
                    () -> assertEquals(-4, calculator2.fourAC(1, -1), " -4 * 1 * -1 = -4"),
                    () -> assertEquals(64, calculator2.fourAC(4, 4), " 4 * 4 * 4 = 64"),
                    () -> assertEquals(-4, calculator2.fourAC(-1, 1), "4 * -1 * 1")
            );
        }

        @Test
        public void sqrtTest() {
            System.out.println("Testing Square roots. Where a gets taken away by b, then sqrt the answer");
            assertAll(
                    () -> assertEquals(4, calculator2.squareRootAnswer(20, 4), "sqrt 16 = 4"),
                    () -> assertEquals(8, calculator2.squareRootAnswer(63, -1), "sqrt 64 = 8"),
                    () -> assertEquals(10, calculator2.squareRootAnswer(110, -10), "sqrt 100 = 10")
            );
        }

        @Test
        public void OverallQuadraticFormulaCheck() {
            float a = 2;
            float b = -5;
            float c = -6;
            calculator2.quadraticFormula(a, b, c);
            assertEquals((b * b), calculator2.squareOfB(b), "This should return the value of b * b. e.g. 5 * 5 which equals 25");
            assertEquals((4 * a * c), calculator2.fourAC(a, c), "This should return the result of 4 * a * c. If a = 2 and c = -6: 4*2*-6 = -48");
            assertEquals(8.54400374531753, calculator2.squareRootAnswer(calculator2.squareOfB(b), calculator2.fourAC(a, c)), "This should return the square root of b^2 - 4ac. Can use Math.sqrt to square root the answer.");
            assertEquals(3.3860009363293826, calculator2.positiveAnswer(a, b, c),
                    "Using the answer form the square root function, it should ADD to -b, then divide it by 2a");
            assertEquals(-0.8860009363293826, calculator2.negativeAnswer(a, b, c),
                    "Using the answer form the square root function, it should SUBTRACT from -b, then divide it by 2a");

        }

    }

    /**
     * Test of squareOfB method, of class Calculator2.
     */
    @org.junit.Test
    public void testSquareOfB() {
        System.out.println("squareOfB");
        float b = 0.0F;
        Calculator2 instance = new Calculator2();
        float expResult = 0.0F;
        float result = instance.squareOfB(b);
        System.out.println("Doing Square number checks. Should return the input value multiplied by itself. e.g. 2 * 2 = 4");
        assertAll(
                () -> assertEquals(1, calculator2.squareOfB(1)),
                () -> assertEquals(1, calculator2.squareOfB(-1)),
                () -> assertEquals(4, calculator2.squareOfB(2)),
                () -> assertEquals(25, calculator2.squareOfB(5)),
                () -> assertEquals(10000, calculator2.squareOfB(100)),
                () -> assertEquals(0, calculator2.squareOfB(0)),
                () -> assertEquals(100, calculator2.squareOfB(-10)),
                () -> assertEquals(225, calculator2.squareOfB(-15)),
                () -> assertEquals(expResult, calculator2.squareOfB(b), "Expected " + result + " received " + expResult + " instead. for b squared"),
                () -> assertEquals(0.25, calculator2.squareOfB(0.5f))
        );
    }

    /**
     * Test of fourAC method, of class Calculator2.
     */
    @org.junit.Test
    public void testFourAC() {
        System.out.println("fourAC");
        float a = 0.0F;
        float c = 0.0F;
        Calculator2 instance = new Calculator2();
        float expResult = 0.0F;
        float result = instance.fourAC(a, c);
        assertEquals(expResult, result, 0.0);
        System.out.println("Doing 4 *a *c");
        assertAll(
                () -> assertEquals(4, calculator2.fourAC(1, 1), " 4 * 1 * 1 = 4"),
                () -> assertEquals(0, calculator2.fourAC(1, 0), " 4 * 1 * 0 = 0"),
                () -> assertEquals(0, calculator2.fourAC(0, 1), " 4 * 0 * 1 = 0"),
                () -> assertEquals(400, calculator2.fourAC(10, 10), " 4 * 10 * 10 = 400"),
                () -> assertEquals(-4, calculator2.fourAC(1, -1), " -4 * 1 * -1 = -4"),
                () -> assertEquals(64, calculator2.fourAC(4, 4), " 4 * 4 * 4 = 64"),
                () -> assertEquals(expResult, calculator2.fourAC(a, c), "Expected " + result + " received " + expResult + " instead. for b squared"),
                () -> assertEquals(-4, calculator2.fourAC(-1, 1), "4 * -1 * 1")
        );
    }

    /**
     * Test of squareRootAnswer method, of class Calculator2.
     */
    @org.junit.Test
    public void testSquareRootAnswer() {
        System.out.println("squareRootAnswer");
        float squareOfB = 0.0F;
        float fourAC = 0.0F;
        Calculator2 instance = new Calculator2();
        double expResult = 0.0;
        double result = instance.squareRootAnswer(squareOfB, fourAC);
        System.out.println("Testing Square roots. Where a gets taken away by b, then sqrt the answer");
        assertAll(
                () -> assertEquals(4, calculator2.squareRootAnswer(20, 4), "sqrt 16 = 4"),
                () -> assertEquals(8, calculator2.squareRootAnswer(63, -1), "sqrt 64 = 8"),
                () -> assertEquals(expResult, calculator2.squareRootAnswer(squareOfB, fourAC), "Expected " + result + " received " + expResult + " instead. for b squared"),
                () -> assertEquals(10, calculator2.squareRootAnswer(110, -10), "sqrt 100 = 10")
        );
    }

    /**
     * Test of positiveAnswer method, of class Calculator2.
     */
    @org.junit.Test
    public void testPositiveAnswer() {
        System.out.println("positiveAnswer");
        float a = 0.0F;
        float b = 0.0F;
        float c = 0.0F;
        Calculator2 instance = new Calculator2();
        double expResult = 0.0;
        double result = instance.positiveAnswer(a, b, c);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of negativeAnswer method, of class Calculator2.
     */
    @org.junit.Test
    public void testNegativeAnswer() {
        System.out.println("negativeAnswer");
        float a = 0.0F;
        float b = 0.0F;
        float c = 0.0F;
        Calculator2 instance = new Calculator2();
        double expResult = 0.0;
        double result = instance.negativeAnswer(a, b, c);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of quadraticFormula method, of class Calculator2.
     */
    @org.junit.Test
    public void testQuadraticFormula() {
        System.out.println("quadraticFormula");
        float a = 0.0F;
        float b = 0.0F;
        float c = 0.0F;
        Calculator2 instance = new Calculator2();
        instance.quadraticFormula(a, b, c);

        assertAll(
                () -> assertEquals((4 * a * c), calculator2.fourAC(a, c), "This should return the result of 4 * a * c. If a = 2 and c = -6: 4*2*-6 = -48"),
                () -> assertEquals(8.54400374531753, calculator2.squareRootAnswer(calculator2.squareOfB(b), calculator2.fourAC(a, c)),
                        "This should return the square root of b^2 - 4ac. Can use Math.sqrt to square root the answer."),
                () -> assertEquals(3.3860009363293826, calculator2.positiveAnswer(a, b, c),
                        "Using the answer form the square root function, it should ADD to -b, then divide it by 2a"),
                () -> assertEquals(-0.8860009363293826, calculator2.negativeAnswer(a, b, c),
                        "Using the answer form the square root function, it should SUBTRACT from -b, then divide it by 2a")
        );

    }


/**
 * Test of main method, of class Calculator2.
 */
@org.junit.Test
public void testMain() {
        System.out.println("main");
        String[] args = null;
        Calculator2.main(args);

    }
}
