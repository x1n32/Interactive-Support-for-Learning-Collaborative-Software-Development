package github.x1n32;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import github.x1n32.Task1Calculator.Calculator;

import org.junit.Before;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Testing Math Utils class
 * Testing is not debugging. We take a single object, and test it, by invoking
 * it and
 * making sure we get the correct result.
 * Testing should be repeatable, self-verifying, runs simultaneouslt, and return
 * the same results.
 * 
 */
class CalculatorTest {

	// --File format--------------------------------------------------------
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	static LocalDateTime now = LocalDateTime.now();
	static String fileReport = "<br> \n==================\n<br>\n" + "### " + dtf.format(now) + " \n <br>\n";
	static int beforeFileLength = fileReport.length();

	static int totalTests = 0;
	static int testPassed = 0;

	private Calculator calculator;

	// Saves an image function
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

	@BeforeEach
	void initEach() throws IOException {
		calculator = new Calculator();

	}

	@Before
	public static void fileCreation() {

		try {
			File myObj = new File("calculator1Report.md");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@AfterAll
	public static void file() {

		try {

			FileWriter Writer = new FileWriter("calculator1Report.md", false);
			// Setting header and links
			String titleText = "# Calculator Report: \n <br/>";
			titleText += "[See Home Page ](/README.md)\n <br/>";
			titleText += "[See Task 1 Page ](/Task1.md)\n <br/>";
			titleText += "[See Task 2 Page ](/Task2.md)\n <br/>";
			titleText += "[See Task 3 Page ](/Task3.md)\n <br/>";
			titleText += "[See Information Page ](/Info.md)\n <br/>";
			Writer.write(titleText);

			// Appendng report

			Writer.write(fileReport);

			System.out.println("Test passed: " + testPassed + " total = " + totalTests);
			double percentageCleared = ((float) testPassed / totalTests);
			percentageCleared = percentageCleared * 100;
			// percentageCleared = 0;

			// Feedback
			Writer.write("\n <br>\nFor Calculator 1, You have passed " + testPassed + " out of " + totalTests
					+ " tests. \n <br>\n");
			if (percentageCleared == 0) {
				Writer.write("\nHave a try!. ");
				String imageUrl = "https://images.squarespace-cdn.com/content/571b6a94746fb91673b8ab13/1496046345902-SVMQKP9OGGNDP2SMA6W2/Give+it+a+go.png?content-type=image%2Fpng";
				String destinationFile = "Images/calculator1Status.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared == 100) {
				Writer.write("ALL CORRECT! CONGRATULATIONS!");
				String imageUrl = "https://www.rubberstampking.co.uk/assets/images/fullmarks.png";
				String destinationFile = "Images/calculator1Status.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared > 50) {
				Writer.write("Well done.");
				String imageUrl = "https://cdn3.vectorstock.com/i/1000x1000/94/02/well-done-stamp-vector-1469402.jpg";
				String destinationFile = "Images/calculator1Status.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared <= 50 && percentageCleared > 0) {
				Writer.write("\nHave another go." + percentageCleared);
				String imageUrl = "http://comealivein365.com/wp-content/uploads/2013/08/keep-calm-try-again.jpg";
				String destinationFile = "Images/calculator1Status.jpg";
				saveImage(imageUrl, destinationFile);

			}
			Writer.write("\n <br>");
			Writer.close();
			System.out.println("Successfully written.");
			System.out.println("You have passed " + testPassed + " out of " + totalTests + " tests. ");
			// System.out.println(fileReport.length());

		} catch (IOException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}

	}

	// -------------------------------------------TESTS:---------------------------------------
	@Nested
	class calcTest {

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
			try {
				totalTests += 1;
				float actual = calculator.add(1, 1);
				float expected = 2;
				assertEquals(expected, actual,
						"Add method should return the sum of two numbers");
				fileReport += " - Adding two positive numbers WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += "Error found in the Add Method;  should return the sum of two numbers \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		@DisplayName("Adding 2 negative numbers")
		void testAddingTwoNegatives() {
			try {
				totalTests += 1;
				float actual = calculator.add(-1, -1);
				float expected = -2;
				assertEquals(expected, actual,
						"Add method should return the sum of two numbers. Tested with 2 negative numbers failed.");
				fileReport += " - Adding two negative numbers WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += " - Error found in the Add Method;  should return the sum of two numbers. Failed with both negative numbers\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		void testAddingAPositiveAndANegative() {
			try {
				totalTests += 1;
				float actual = calculator.add(-1, 1);
				float expected = 0;
				assertEquals(expected, actual,
						"Add method should return the sum of two numbers. Tested with 1 positive and 1 negative numbers failed.");
				testPassed += 1;
				fileReport += " - Adding a positive number and a negative number WORKS! \n"; // Positive comment

			} catch (Throwable e) {
				fileReport += "Error found in the Add Method;  should return the sum of two numbers. Failed with one positive and one negative numbers\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}

		@Test
		void testMultiply() {

			try {
				totalTests += 1;

				assertAll(
						() -> assertEquals(0, calculator.multiply(1, 0),
								"1*0 = 0. Numbers must have been changed if there's an error."),
						() -> assertEquals(1, calculator.multiply(1, 1), "1*1 = 1"),
						() -> assertEquals(6, calculator.multiply(2, 3), "2*3 = 6"));
				fileReport += " - Multiplying two numbers WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += "Error found in the multiply Method;  should return the product of two numbers. \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		public void testFiftyTimesTwo_ReturnsOneHundred() {

			try {
				totalTests += 1;
				float actual = calculator.multiply(50, 2);
				float expected = 100;
				assertEquals(actual, expected, "Should return 100. 50 x 2 = 100");
				fileReport += " - 50 x 2 WORKS! \n"; // Posotive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += "Error found in the multiply Method;  should return the product of two numbers. Failed with one positive and one negative numbers\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		void computeCircleArea() {
			try {
				totalTests += 1;
				double actual = calculator.computeCircleArea(10);
				double expected = 314.1592653589793;
				assertEquals(expected, actual,
						"Should return area of circle, pi x radius x radius.");
				fileReport += " - Calculating area of a circle WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += "Error found in the computeCircleArea Method; Should return area of circle, pi x radius x radius.\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		void testDivide() {
			try {
				totalTests += 1;

				assertAll(
						() -> assertEquals(10, calculator.divide(100, 10)),
						() -> assertEquals(100, calculator.divide(150, 1.5f)),
						() -> assertEquals(0.5, calculator.divide(50, 100)));
				fileReport += " - Adding Two numbers WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += "Error found in the divide Method; Should return the value of num1 divided by num 2 \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}

		@Test
		void testDivideArgumentException() {
			assertThrows(IllegalArgumentException.class, () -> calculator.divide(4, 0),
					"Divide should throw ArithmeticException when denominator is zero");
		}
	}
}