package github.x1n32;

import github.x1n32.Task2DataStructures.HashMapExercise;

import static org.junit.jupiter.api.Assertions.*;

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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
//import org.junit.rules.ErrorCollector;

public class HashMapExerciseTest {

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
			File myObj = new File("HashMapReport.md");
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

			FileWriter Writer = new FileWriter("HashMapReport.md", false);

			// Setting header and links
			String titleText = "# Hash Map Exercise Report: \n <br/>";
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
			Writer.write("\n <br>\nFor Hash Map Exercise, You have passed " + testPassed + " out of " + totalTests
					+ " tests. \n <br>\n");
			if (percentageCleared == 0) {
				Writer.write("\nHave a try!. ");
				String imageUrl = "https://images.squarespace-cdn.com/content/571b6a94746fb91673b8ab13/1496046345902-SVMQKP9OGGNDP2SMA6W2/Give+it+a+go.png?content-type=image%2Fpng";
				String destinationFile = "Images/hashMapStatus.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared == 100) {
				Writer.write("ALL CORRECT! CONGRATULATIONS!");
				String imageUrl = "https://www.rubberstampking.co.uk/assets/images/fullmarks.png";
				String destinationFile = "Images/hashMapStatus.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared > 50) {
				Writer.write("Well done.");
				String imageUrl = "https://cdn3.vectorstock.com/i/1000x1000/94/02/well-done-stamp-vector-1469402.jpg";
				String destinationFile = "Images/hashMapStatus.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared <= 50 && percentageCleared > 0) {
				Writer.write("\nHave another go.");
				String imageUrl = "http://comealivein365.com/wp-content/uploads/2013/08/keep-calm-try-again.jpg";
				String destinationFile = "Images/hashMapStatus.jpg";
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

	@BeforeEach
	public void initEach() {
		System.out.println(fileReport.length());
		// System.out.println("Starting Tests");

		ItemDescriptions.put("Rusty Sword", "Weak and Rusty. Perhaps a bit of polish would make it shine");
		ItemDescriptions.put("Rusty Dagger", "Weak and Rusty. Perhaps a bit of polish would make it shine");
		ItemDescriptions.put("Wooden Shield", "Wooden but durable. Can take a few hits. Be careful around fire");
		ItemDescriptions.put("Map", "A map of the street...");
		ItemDescriptions.put("lunch box", "Only an apple is inside...");

	}

	// ============================TEST==============================
	@Nested
	class HashMapTesting {

		@Test
		@DisplayName("Create")
		public void Create() {
			System.out.println("Create list");
			assertFalse(ItemDescriptions.isEmpty());
		}

		@Test
		@DisplayName("checkValue")
		public void checkValue() {

			try {

				System.out.println("checking specific value in list");
				String expected = "A map of the street...";
				assertEquals(expected, ItemDescriptions.get("Map"),
						" - This should match the same text as the value of map.");
				fileReport += " - Getting value from a key (Item Description) WORKS! \n"; // Positive comment

			} catch (Throwable e) {
				fileReport += " - Error getting the correct value from the key: \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		@DisplayName("checkValue2")
		public void checkValue2() {
			try {
	
				System.out.println("checking specific value in list 2");
				String expected = "This new descpription";
				ItemDescriptions.put("Item", "This new descpription");
				assertEquals(expected, ItemDescriptions.get("Item"),
						" - This should match the same text as the value of map.");
				fileReport += " - 2nd Test: Getting value from a key (Item Description) WORKS! \n"; // Positive comment
		
			} catch (Throwable e) {
				fileReport += " - Error getting the correct value from the key: \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		@DisplayName("testChangeinValue")
		public void testChangeinValue() {
			try {
		
				System.out.println("Testing new Description");
				String newDescription = "Testing change in description";
				ItemDescriptions.put("Wooden Shield", newDescription);

				assertEquals(newDescription, ItemDescriptions.get("Wooden Shield"));

				fileReport += " - Changing value/description (new Description) WORKS! \n"; // Positive comment
	

			} catch (Throwable e) {
				fileReport += " - Error changing the value of an existing key: \n    ";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		@DisplayName("testChangeinValue2")
		public void testChangeinValue2() {
			try {
		
				System.out.println("Testing new Description 2");
				ItemDescriptions.put("Item", "This descpription");
				String newDescription = "Chango description";
				ItemDescriptions.put("Item", newDescription);

				assertEquals(newDescription, ItemDescriptions.get("Item"));
				fileReport += " - 2nd Test: Changing value/description (new Description) WORKS! \n"; // Positive comment


			} catch (Throwable e) {
				fileReport += " - Error changing the value of an existing key: \n   ";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		@DisplayName("testFindEmptyValues")
		public void testFindEmptyValues() {
			try {
				totalTests += 1;
				System.out.println("Testing find and replace empty values");
				ItemDescriptions.put("empty", "");
				HashMapExercise.findAndReplaceEmptyValue(ItemDescriptions);
				assertEquals("Unknown Description", ItemDescriptions.get("empty"));
				fileReport += " - Challenge 1: Replacing empty values(find and replace empty value method) WORKS! \n"; // Positive
																														// comment
				testPassed += 1;
			} catch (Throwable e) {
				fileReport += " - Error found in CHALLENGE1: findAndReplaceEmptyValue() when looking for empty values. If you haven't started this task, ignore this message. \n   Otherwise, did you check you recieved the right input? Are you searching values correctly? \n   Look for empty values with no spaces, and null values. Remember to add a new value, you just set it again, like how you add a new key/value. \n   Make sure you set the description to be the same as what the task requires. \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}

		}

		@Test
		@DisplayName("testFindNullValues")
		public void testFindNullValues() {
			try {
				totalTests += 1;
				System.out.println("Testing find and replace null values");
				ItemDescriptions.put("empty2", null);
				HashMapExercise.findAndReplaceEmptyValue(ItemDescriptions);
				assertEquals(" - Unknown Description", ItemDescriptions.get("empty2"));
				fileReport += " - Challenge 1.2: null values replaced (find and replace empty value method) WORKS! \n"; // Positive
																														// comment
				testPassed += 1;
			} catch (Throwable e) {
				fileReport += " - Error found in CHALLENGE1: findAndReplaceEmptyValue() when looking for null values. If you haven't started this task, ignore this message. \n   Otherwise, did you check you recieved the right input? Are you searching values correctly? \n   Look for empty values with no spaces, and null values. Remember to add a new value, you just set it again, like how you add a new key/value. \n   Make sure you set the description to be the same as what the task requires. \n";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}

		@Test
		@DisplayName("testHashMapCreationUnderstanding")
		public void testHashMapCreationUnderstanding() {
			try {
				totalTests += 1;
				System.out.println("Testing if user can create a hashmap in the method");
				System.out.println("testHashMapCreationUnderstanding");
				assertEquals("Abby", HashMapExercise.createNewHashMap());
				fileReport += " - Challenge 2: Creating a new hash map(createNewHashMap) WORKS! \n"; // Positive comment
				testPassed += 1;

			} catch (Throwable e) {
				fileReport += " - Error found in CHALLENGE2: createNewHashMap(). If you haven't started this task, ignore this message. \n   Have you checked you have put two generics? \n   <> should have two data types inside that would suit 0 and Abby. \n   You only need to write one line of code to create a hash map.";
				fileReport += e + "\n";
				System.out.println(fileReport + "\n");
			}
		}
	}

}
