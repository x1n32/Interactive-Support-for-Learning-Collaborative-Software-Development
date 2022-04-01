package github.x1n32;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import github.x1n32.Task1Calculator.Calculator2;

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

public class Calculator2Test {

	// --File format--------------------------------------------------------
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	static LocalDateTime now = LocalDateTime.now();
	static String fileReport = "<br> \n==================\n<br>\n" + "### " + dtf.format(now) + " \n <br>\n";
	static int beforeFileLength = fileReport.length();

	static int totalTests = 0;
	static int testPassed = 0;

	private Calculator2 calculator2;

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

	@Before
	public static void fileCreation() {

		try {
			File myObj = new File("calculator2Report.md");
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

			FileWriter Writer = new FileWriter("calculator2Report.md", false);

			// Setting header and links
			String titleText = "# Calculator2 Report: \n <br/>";
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
			percentageCleared = 0;

			// Feedback
			Writer.write("\n <br>\nFor Calculator 2, You have passed " + testPassed + " out of " + totalTests
					+ " tests. \n <br>\n");
			if (percentageCleared == 0) {
				Writer.write("\nHave a try!.");
				String imageUrl = "https://images.squarespace-cdn.com/content/571b6a94746fb91673b8ab13/1496046345902-SVMQKP9OGGNDP2SMA6W2/Give+it+a+go.png?content-type=image%2Fpng";
				String destinationFile = "Images/calculator2Status.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared == 100) {
				Writer.write("ALL CORRECT! CONGRATULATIONS!");
				String imageUrl = "https://www.rubberstampking.co.uk/assets/images/fullmarks.png";
				String destinationFile = "Images/calculator2Status.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared > 50) {
				Writer.write("Well done.");
				String imageUrl = "https://cdn3.vectorstock.com/i/1000x1000/94/02/well-done-stamp-vector-1469402.jpg";
				String destinationFile = "Images/calculator2Status.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared <= 50 && percentageCleared > 0) {
				Writer.write("\nHave another go." + percentageCleared);
				String imageUrl = "http://comealivein365.com/wp-content/uploads/2013/08/keep-calm-try-again.jpg";
				String destinationFile = "Images/calculator2Status.jpg";
				saveImage(imageUrl, destinationFile);

			}
			Writer.write("\n <br>");
			Writer.close();
			System.out.println("Successfully written.");
			System.out.println("You have passed " + testPassed + " out of " + totalTests + ". ");
			// System.out.println(fileReport.length());

		} catch (IOException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}

	}

	@BeforeEach
	void initEach() {
		calculator2 = new Calculator2();
		System.out.println("Now running tests");
	}

	@Nested
	class AddTest {
		@Test
		public void squareNumberCheck() {
			try {
				totalTests += 1;

				System.out.println(
						"Doing Square number checks. Should return the input value multiplied by itself. e.g. 2 * 2 = 4");
				assertAll(
						() -> assertEquals(10000, calculator2.squareOfB(100)),
						() -> assertEquals(225, calculator2.squareOfB(-15)),
						() -> assertEquals(0.25, calculator2.squareOfB(0.5f)));

				fileReport += " - Square of B method WORKS! \n"; // Positive comment
				testPassed += 1;
			} catch (Throwable e) {
				fileReport += " - Error found in the squareOfB Method;  should return number * number.\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}

		@Test
		@DisplayName("Testing 4AC")
		public void fouracCheck() {

			try {
				totalTests += 1;
				System.out.println("Doing 4 *a *c");
				assertAll(
						() -> assertEquals(4, calculator2.fourAC(1, 1), " 4 * 1 * 1 = 4"),
						() -> assertEquals(0, calculator2.fourAC(1, 0), " 4 * 1 * 0 = 0"),
						() -> assertEquals(-4, calculator2.fourAC(-1, 1), "4 * -1 * 1"));
				fileReport += " - 4AC method WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += " - Error found in the 4AC Method; Should return the value of 4 x the value of a x the value of c. The * is used to multiply numbers\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}

		@Test
		public void sqrtTest() {
			try {
				totalTests += 1;
				System.out.println("Testing Square roots. Where a gets taken away by b, then sqrt the answer");
				assertAll(
						() -> assertEquals(4, calculator2.squareRootAnswer(20, 4), "sqrt 16 = 4"),
						() -> assertEquals(8, calculator2.squareRootAnswer(63, -1), "sqrt 64 = 8"),
						() -> assertEquals(10, calculator2.squareRootAnswer(90, -10), "sqrt 100 = 10"));
				fileReport += " - Square Root method WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += " - Error found in the squareRootAnswer Method; Square root is the opposite of squaring a number. There is a function in the maths library to square root: Math.sqrt(X).\n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		public void negativeAnswerCheck() {

			try {
				totalTests += 1;
				float a = 2;
				float b = -5;
				float c = -6;
				calculator2.quadraticFormula(a, b, c);
				assertEquals((b * b), calculator2.squareOfB(b),
						" - This should return the value of b * b. e.g. 5 * 5 which equals 25");
				assertEquals((4 * a * c), calculator2.fourAC(a, c),
						" - This should return the result of 4 * a * c. If a = 2 and c = -6: 4*2*-6 = -48");
				assertEquals(8.54400374531753,
						calculator2.squareRootAnswer(calculator2.squareOfB(b), calculator2.fourAC(a, c)),
						" - This should return the square root of b^2 - 4ac. Can use Math.sqrt to square root the answer.");
				assertEquals(-0.8860009363293826, calculator2.negativeAnswer(a, b, c),
						" - Using the answer form the square root function, it should SUBTRACT from -b, then divide it by 2a");

				fileReport += " - Negative answer check... WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += " - Negative answer of the quadraticFormula method: failed. \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}
	}

	@Test
	public void positiveAnswerCheck() {

		try {
			totalTests += 1;
			float a = 2;
			float b = -5;
			float c = -6;
			calculator2.quadraticFormula(a, b, c);
			assertEquals((b * b), calculator2.squareOfB(b),
					" - This should return the value of b * b. e.g. 5 * 5 which equals 25");
			assertEquals((4 * a * c), calculator2.fourAC(a, c),
					" - This should return the result of 4 * a * c. If a = 2 and c = -6: 4*2*-6 = -48");
			assertEquals(8.54400374531753,
					calculator2.squareRootAnswer(calculator2.squareOfB(b), calculator2.fourAC(a, c)),
					" - This should return the square root of b^2 - 4ac. Can use Math.sqrt to square root the answer.");
			assertEquals(3.3860009363293826, calculator2.positiveAnswer(a, b, c),
					" - Using the answer form the square root function, it should ADD to -b, then divide it by 2a");
			fileReport += " - Positive answer check... WORKS! \n"; // Positive comment
			testPassed += 1;

		} catch (Throwable e) {
			fileReport += " - Positive answer of the quadraticFormula method: failed. \n";
			fileReport += e + "\n";
			System.out.println(fileReport + "\n");
		}
	}

	

	@Test
	public void OverallQuadraticFormulaCheck() {

		try {
			totalTests += 1;
			float a = 2;
			float b = -5;
			float c = -6;
			calculator2.quadraticFormula(a, b, c);
			assertEquals((b * b), calculator2.squareOfB(b),
					" - This should return the value of b * b. e.g. 5 * 5 which equals 25");
			assertEquals((4 * a * c), calculator2.fourAC(a, c),
					" - This should return the result of 4 * a * c. If a = 2 and c = -6: 4*2*-6 = -48");
			assertEquals(8.54400374531753,
					calculator2.squareRootAnswer(calculator2.squareOfB(b), calculator2.fourAC(a, c)),
					" - This should return the square root of b^2 - 4ac. Can use Math.sqrt to square root the answer.");
			assertEquals(3.3860009363293826, calculator2.positiveAnswer(a, b, c),
					" - Using the answer form the square root function, it should ADD to -b, then divide it by 2a");
			assertEquals(-0.8860009363293826, calculator2.negativeAnswer(a, b, c),
					" - Using the answer form the square root function, it should SUBTRACT from -b, then divide it by 2a");
			fileReport += " - Final check... Quadratic Formula for both answers.... WORKS! \n"; // Positive comment
			testPassed += 1;

		} catch (Throwable e) {
			fileReport += " - quadraticFormula method: Overall, the final function doesn't give the right answer \n";
			fileReport += e + "\n";
			System.out.println(fileReport + "\n");
		}
	}
}