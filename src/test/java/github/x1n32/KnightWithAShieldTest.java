package github.x1n32;

//import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;



public class KnightWithAShieldTest {

	HashMap<String, String> ItemDescriptions = new HashMap<>();
	static int totalTests = 0;
	static int testPassed = 0;

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	static LocalDateTime now = LocalDateTime.now();
	static String fileReport = "<br> \n==================\n<br>\n" + "### " + dtf.format(now) + " \n <br>\n";
	static int beforeFileLength = fileReport.length();

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

	// ErrorCollector error = new ErrorCollector();

	@Before
	public static void fileCreation() {

		try {
			File myObj = new File("decorator.md");
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

			FileWriter Writer = new FileWriter("decorator.md", true);
			Writer.write(fileReport);

			System.out.println("Test passed: " + testPassed + " total = " + totalTests);
			double percentageCleared = ((float) testPassed / totalTests);
			percentageCleared = percentageCleared * 100;
			// percentageCleared = 0;

			// Feedback
			Writer.write("\n <br>\nFor Hash Map Exercise, You have passed " + testPassed + " out of " + totalTests + ". ");
			if (percentageCleared == 0) {
				Writer.write("\nHave a try!. ");
				String imageUrl = "https://images.squarespace-cdn.com/content/571b6a94746fb91673b8ab13/1496046345902-SVMQKP9OGGNDP2SMA6W2/Give+it+a+go.png?content-type=image%2Fpng";
				String destinationFile = "decoratorStatus.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared == 100) {
				Writer.write("ALL CORRECT! CONGRATULATIONS!");
				String imageUrl = "https://www.rubberstampking.co.uk/assets/images/fullmarks.png";
				String destinationFile = "decorator.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared > 50) {
				Writer.write("Well done.");
				String imageUrl = "https://cdn3.vectorstock.com/i/1000x1000/94/02/well-done-stamp-vector-1469402.jpg";
				String destinationFile = "decorator.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared <= 50 && percentageCleared > 0) {
				Writer.write("\nHave another go." + percentageCleared);
				String imageUrl = "http://comealivein365.com/wp-content/uploads/2013/08/keep-calm-try-again.jpg";
				String destinationFile = "decorator.jpg";
				saveImage(imageUrl, destinationFile);

			}
			Writer.write("\n <br>");
			Writer.close();
			System.out.println("Successfully written.");
			System.out.println(fileReport.length());

		} catch (IOException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}

	}

  // ============================TEST==============================
}
