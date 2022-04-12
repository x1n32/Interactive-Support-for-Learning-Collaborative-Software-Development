package github.x1n32;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;

import github.x1n32.Task3DesignPatterns.CharacterImp;
import github.x1n32.Task3DesignPatterns.KnightWithAShield;
import github.x1n32.Task3DesignPatterns.WizardDecorator;
import github.x1n32.Task3DesignPatterns.fireWizard;

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



public class Task3Test {

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

			FileWriter Writer = new FileWriter("decorator.md", false);
			Writer.write(fileReport);

			System.out.println("Test passed: " + testPassed + " total = " + totalTests);
			double percentageCleared = ((float) testPassed / totalTests);
			percentageCleared = percentageCleared * 100;
			// percentageCleared = 0;

			// Feedback
			Writer.write("\n <br>\nFor Design Pattern tasks, You have passed " + testPassed + " out of " + totalTests + ". ");
			if (percentageCleared == 0) {
				Writer.write("\nHave a try!. ");
				String imageUrl = "https://images.squarespace-cdn.com/content/571b6a94746fb91673b8ab13/1496046345902-SVMQKP9OGGNDP2SMA6W2/Give+it+a+go.png?content-type=image%2Fpng";
				String destinationFile = "Images/decoratorStatus.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared == 100) {
				Writer.write("ALL CORRECT! CONGRATULATIONS!");
				String imageUrl = "https://www.rubberstampking.co.uk/assets/images/fullmarks.png";
				String destinationFile = "Images/decorator.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared > 50) {
				Writer.write("Well done.");
				String imageUrl = "https://cdn3.vectorstock.com/i/1000x1000/94/02/well-done-stamp-vector-1469402.jpg";
				String destinationFile = "Images/decorator.jpg";
				saveImage(imageUrl, destinationFile);

			} else if (percentageCleared <= 50 && percentageCleared > 0) {
				Writer.write("\nHave another go." + percentageCleared);
				String imageUrl = "http://comealivein365.com/wp-content/uploads/2013/08/keep-calm-try-again.jpg";
				String destinationFile = "Images/decorator.jpg";
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

  @Test
  void knightWithShieldJobDescriptionTest() {
	  try {
		  totalTests += 1;

		//  CharacterImp StarterCharacter = new CharacterImp();
		  KnightWithAShield shieldKnight = new KnightWithAShield(new CharacterImp());
  
		  System.out.println(shieldKnight.job());

		  String actual = shieldKnight.job();
		  String expected = "Job: Human Knight + shield ";

		  assertEquals(expected, actual);

		  fileReport += " - Shield Knights description WORKS! \n"; // Positive comment
		  testPassed += 1;

	  } catch (Throwable e) {
		  fileReport += "- Error in description for Shield Knight. \nShould return Job: Human Knight + shield. Make sure you typed it correctly! \n";
		  fileReport += e + "\n";
		  System.out.println(fileReport + "\n");
	  }

  }


  @Test
  void knightWithShieldStatTest() {
	  try {
		  totalTests += 1;
		  KnightWithAShield shieldKnight = new KnightWithAShield(new CharacterImp());

		  int actual = shieldKnight.def();
		  int expected = 20;

		  assertEquals(expected, actual);

		  fileReport += " - Shield Knights defence stat buff WORKS! \n"; // Positive comment
		  testPassed += 1;

	  } catch (Throwable e) {
		  fileReport += "- Error found in knight with a shield. The defence stat isn't correct. Should increase defence by 10, so total defence should be 20. \n";
		  fileReport += e + "\n";
		  System.out.println(fileReport + "\n");
	  }

  }

  @Test
  void wizardCreationTest() {
	  try {
		  totalTests += 1;

		  String name = "Merlin";
		  WizardDecorator basicWizard = new WizardDecorator(new CharacterImp(),name);
		  String actual = basicWizard.getName();
		  String expected = name;

		  assertEquals(expected, actual);

		  fileReport += " - Wizard's name Works! \n"; // Positive comment
		  testPassed += 1;

	  } catch (Throwable e) {
		  fileReport += "- Error found in Wizard Decorator. The name feature is not working. Make sure the parameter takes String name and set that as the name for the object.\n";
		  fileReport += e + "\n";
		  System.out.println(fileReport + "\n");
	  }
  }

  @Test
  void wizardMagTest() {
	  try {
		  totalTests += 1;

		  String name = "Merlin";
		  WizardDecorator basicWizard = new WizardDecorator(new CharacterImp(),name);
		  int actual = basicWizard.mag();
		  int expected = 20;

		  assertEquals(expected, actual);

		  fileReport += " - Wizard's magic set to 20 Works! \n"; // Positive comment
		  testPassed += 1;

	  } catch (Throwable e) {
		  fileReport += "- Error found in Wizard Decorator. Set the base magic to 20. Return 20; \n";
		  fileReport += e + "\n";
		  System.out.println(fileReport + "\n");
	  }

  }


  @Test
  void wizardCastingTest() {
	  try {
		  totalTests += 1;

		  String name = "Merlin";
		  WizardDecorator basicWizard = new WizardDecorator(new CharacterImp(),name);
		  String expected = "Casting: ";
		  String actual = basicWizard.magicSpell();
		
		  assertEquals(expected, actual);

		  fileReport += " - Wizard's magicSpell() Works! \n"; // Positive comment
		  testPassed += 1;

	  } catch (Throwable e) {
		  fileReport += "- Error found in Wizard Decorator. The method magicSpell() should return Casting: with a space after it. \n";
		  fileReport += e + "\n";
		  System.out.println(fileReport + "\n");
	  }

  }
  @Test
  void wizardCastingFireballTest() {
	  try {
		  totalTests += 1;

		  String name = "Merlin";
		  fireWizard myFireWizard = new fireWizard(new CharacterImp(), name);
		  String expected = "Casting: Fireball!";
		  String actual = myFireWizard.magicSpell();
		
		  assertEquals(expected, actual);

		  fileReport += " - Fire Wizard's magicSpell() that includes Fireball Works! \n"; // Positive comment
		  testPassed += 1;

	  } catch (Throwable e) {
		  fileReport += "- Error found in fireWizard. The method magicSpell() should return Casting: Fireball! Be careful with spelling and spacing. The method needs an override. Use \'super\' to call the decorators Casting: part. \n";
		  fileReport += e + "\n";
		  System.out.println(fileReport + "\n");
	  }
  }

}
