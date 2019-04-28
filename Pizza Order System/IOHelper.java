

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;

// New, Java 7 File I/O API Classes
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOHelper {

    private static Scanner screenInput = new Scanner(System.in);

    public static int getInt(int low, String prompt, int high) {
        int numFromUser = 0;
        String dummy;
        boolean numericEntryOK;
        do {
            System.out.print(prompt);
            numericEntryOK = false;
            try {
                numFromUser = screenInput.nextInt();
				screenInput.nextLine();		//Clear the keyboard buffer
                numericEntryOK = true;
            } catch (InputMismatchException e) {
                dummy = screenInput.nextLine();
                System.out.println(dummy + " is not an integer!");
                numFromUser = low;
            } // end try-catch
            // Indicate to the user why he is being prompted again.
            if (numFromUser < low || numFromUser > high) {
                System.out.println("The number is outside the legal limits.");
            }
        } while (!numericEntryOK || numFromUser < low || numFromUser > high);
        return numFromUser;
    } // end full parameter getInt method

    public static int getInt() {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        String prompt = "Please enter any integer: ";
        return getInt(low, prompt, high);
    } // end no parameter getInt method

    public static int getInt(String prompt) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        return getInt(low, prompt, high);
    } // end one parameter getInt method

    public static int getInt(int low, String prompt) {
        int high = Integer.MAX_VALUE;
        return getInt(low, prompt, high);
    } // end two parameter getInt method

    public static int getInt(String prompt, int high) {
        int low = Integer.MIN_VALUE;
        return getInt(low, prompt, high);
    } // end two parameter getInt method

    public static String getString(String prompt) {
        String userText;
        System.out.print(prompt);
        do {
        userText = screenInput.nextLine();
        }while(userText.equals(""));
        return userText;
    } // end one parameter getString method

    public static int saveText(String filename, String[] text) {
    	int lineCount = 0;
    	Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(filename);
        // Creates file or empties existing file.
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			for (int i = 0; i < text.length; i++) {
				writer.write(text[i] + "\r\n");  // Note addition of line terminator 
				lineCount++;
			}
		} catch (IOException err) {
		    System.err.format("IOException: %s%n", err);
		    System.err.println("Unable to write file: " + filename);
		    return lineCount;
		}
        return lineCount;
    } // end saveText

	public static String[] readText(String filename) {
        ArrayList<String> contents = null;
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(filename);
		if (Files.exists(file, LinkOption.NOFOLLOW_LINKS) && Files.isReadable(file) )
			try {
				contents = (ArrayList<String>)Files.readAllLines(file, charset);
			} catch (IOException err) {
                System.err.format("IOException: %s%n", err);
                System.err.println("Unable to read file: " + filename);
                return null;
			}
		else {
            System.out.println("Unable to open file: " + filename);
            return null;
		}
        return contents.toArray(new String[0]);
    } // end readText
    
} // end IOHelper class

