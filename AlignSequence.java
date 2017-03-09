// Import statements
import java.lang.Math;
import java.util.Arrays;

/**
* Constructor for objects of class RNA
*/
public class AlignSequence
{
    // Test Strings
    static String seq1 = "ABC";     // Top string
    static String seq2 = "BCA";     // Left string

    /**
     * Constructor for objects of class RNA
     */
    public AlignSequence()
    {
        // Initialise instance variables
    }

    /**
     * This method prints the matrix to the console
     */
    public static void printMatrix(int[][] board)
    {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("                                 +---------+");
        for (int i = 0; i < board.length; i++) {
            System.out.print("                                 | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("                                 +--------+\n\n\n\n");
    }
    
    /**
     * This method generates the solution matrix using the two strings
     */
    public static int generateMatrix()
    {
        // Find the length of both strings
        int len1 = seq1.length();
        int len2 = seq2.length();
        
        // Create the table based on strings
        int[][] table = new int[len1 + 1][len2 + 1];
        int value;
        
        // Generate the outline of the matrix
        table[0][0]= 0;
        
        // Set first row in decrementing order
        for (int i = 1; i <= len1; i++) 
        {
            table[0][i] = table[0][i-1] + -1;
        }
        
        // Set first column in decrementing order
        for (int j = 1; j <= len2; j++) 
        {
            table[j][0] = table[j-1][0] + -1;
        }
        
        // Fill in remainder of matrix based on rules
        for (int i = 1; i <= len1; i++) 
        {
            for (int j = 1; j <= len2; j++) 
            {
                // Check existing values and decrement or incrememnt based on if values match from the sequences
                if (seq1.charAt(i-1) == seq2.charAt(j-1)) 
                {
                    value = 1;
                }
                else 
                {
                    value = -1;
                }
                // Set the location of the matrix to the highest possible value
                table[i][j] = java.lang.Math.max((table[i][j-1] - 1), java.lang.Math.max((table[i-1][j] - 1), (table[i-1][j-1] + value)));
            }
        }
        
        // Debug print
        printMatrix(table);
        return 0;
    }

    /**
     * Main function that calls other functions
     */
    public static void main()
    {
        generateMatrix();
    }
}