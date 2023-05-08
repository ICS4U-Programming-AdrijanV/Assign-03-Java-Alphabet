// Importing
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This program will performs the alphabet wrap.
 *
 * @author  Adrijan Vranjkovic
 * @version 1.0
 * @since   2023-05-27
 */
public final class Alphabet {

    /**
     * For the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Alphabet() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This function does the Alphabet wrap.
     *
     * @param currentChar *
     * @param count *
     * @return wrappedChars
     */
    public static List<Character> alphabetWrap(char currentChar, int count) {
        // If list is empty return empty list.
        if (count <= 0) {
            return new ArrayList<>();
        }

        // Add the current char to the list
        final List<Character> wrappedChars = new ArrayList<>();
        wrappedChars.add(currentChar);

        // If the next char is z then wrap the list back to a.
        char nextChar = (char) (currentChar + 1);
        if (nextChar > 'z') {
            nextChar = 'a';
        }

        // Call recursively for the next char and count.
        wrappedChars.addAll(alphabetWrap(nextChar, count - 1));

        // Return the list of wrappedChars
        return wrappedChars;
    }

    /**
     * This is the main function.
     *
     * @param args Unused
     */
    public static void main(String[] args) {

        // Try statement.
        try {

            // Create the input file and read.
            final File inputFile = new File("input.txt");
            final Scanner scanner = new Scanner(inputFile);

            // Create the output file.
            final File outputFile = new File("output.txt");
            final PrintWriter output = new PrintWriter(outputFile);

            // Go through each line in the input
            while (scanner.hasNextLine()) {

                // Get the character and count for each line
                final String[] parts = scanner.nextLine().split(" ");
                if (parts.length == 2) {

                    try {
                        // Take the char from the input line
                        //  and set it to currentChar.
                        final char currentChar = parts[0].charAt(0);
                        // Parse the second element of the input
                        // line to make sure it's an integer
                        final int count = Integer.parseInt(parts[1]);

                        // Call the function and display to output file.
                        final List<Character> result =
                            alphabetWrap(currentChar, count);
                        output.println(result.toString());
                    } catch
                    (NumberFormatException | IndexOutOfBoundsException fnfex) {

                        // Display invalid input
                        output.println("Invalid input.");
                    }

                } else {
                    // Display invalid input
                    output.println("Invalid input!");
                }
            }

            // Close the scanner
            scanner.close();

            // Close the output file
            output.close();

            // Checking to make sure output sent
            System.out.println("Output was sent.");
        } catch (FileNotFoundException fnfex) {
            // Display error.
            System.out.println("Error: " + e.getMessage());
        }
    }
}
