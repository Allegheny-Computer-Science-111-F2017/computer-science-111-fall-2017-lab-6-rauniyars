package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/** This class has a method that hides a word by replacing characters and hereby
 *  creating a complex text-based output.
 *
 */

public class ManipulateDna {

  /** The main entry point for  ManipulateDna.
   *  The source code inside of this method will be executed when the program i
   *  run in the command line. The output of this program will appear in the
   *  terminal window. The println statements make the program display the
   *  output.
   *
   **/

  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Sweta Rauniyar " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dna = scanner.nextLine();
    System.out.println("Okay I am going to manipulate the DNA string: " + dna);
    System.out.println();

    // Step Two: Compute the complement of the DNA String
    String dnaup = dna.toUpperCase();
    String c1 = dnaup.replace('A','T');
    String c2 = c1.replace('C', 'G');
    String c3 = c2.replace('T','A');
    String c4 = c3.replace('G', 'C');

    System.out.println("Complement of ACTG is " + c4);
    
    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    Random generator = new Random();
    int num1 = generator.nextInt(4);
    char insertion = "ACTG".charAt(num1);

    String outputA = insertion + c4.toUpperCase();
    System.out.println("Inserting " + insertion + " at position 0 gives " + outputA);
 
        
    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    int num2 = generator.nextInt(4);
    String insertion2 = dna.substring(0, num2);
    String deletion = dna.substring(num2 + 1);
        
    String outputB = (insertion2 + deletion).toUpperCase();
    System.out.println("Deleting from position " + num2 + " gives " + outputB);

    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    int num3 = generator.nextInt(4);
    int num4 = generator.nextInt(4);
    char addletter = "ACTG".charAt(num3);

    String s1 = dna.substring(0, num4) + addletter + dna.substring(num4 + 1);

    String outputC = s1.toUpperCase();
    System.out.println("Changing position " + num4 + " gives " + outputC); 
    

    // Step Six: Display a final thankyou message
    System.out.println("Thanks for using the ManipulateDna program. \nHave an awesome day.");
  }
}
