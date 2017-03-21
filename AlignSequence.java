// Import statements
import java.lang.Math;
import java.util.Arrays;

/**
 * Aligns a sequence and returns the value
 * 
 * @author Otakar Andrysek and Vikas A.
 * @date 3/21/2017
 * @version 12.0
 */

/**
* Constructor for objects of class RNA
*/
public class AlignSequence
{
    // Test Strings
    static String seq1 = "ABC";     // Top string
    static String seq2 = "BCA";     // Left string
    static int len1 = seq1.length();
    static int len2 = seq2.length();
    
    static int[][] table = new int[len1 + 1][len2 + 1];

    /**
     * This method prints the matrix to the console
     */
    public static void printMatrix(int[][] board)
    {
        System.out.println("\n\n\n");
        System.out.println("                                 +---------+");
        for (int i = 0; i < board.length; i++) {
            System.out.print("                                 | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("                                 +--------+\n\n");
    }
    
    /**
     * This method prints the matrix to the console
     */
    public static void printStrings(int[][] board)
    {
        // TODO
    }
    
    /**
     * This method prints the final alignment value to the console
     */
    public static void printValue(int[][] board)
    {
        int value = table[len1][len2];
        System.out.println(value);
    }
    
    /**
     * This method generates the table matrix using the two strings
     */
    public static int[][] generateMatrix()
    {
        // Create the table based on strings
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
        //printMatrix(table);
        return table;
    }

    /**
     * This function detects the best path in the table matrix
     */
    public static String[] FindPath(int i, int j) 
    {
        String alignedseq1 = "";
        String alignedseq2 = "";
        
        if (i == 0) 
        {
            for (int k = 0; k < j; k++) 
            {
                alignedseq1 = "-" + alignedseq1;
                alignedseq2 = seq2.charAt(j-k) + alignedseq2;
            }

            return new String[] {alignedseq1, alignedseq2};
        } 
        
        else if (j == 0) 
        {
            for (int k = 0; k < i; k++) 
            {
                alignedseq1 = seq1.charAt(i-k) + alignedseq1;
                alignedseq2 = "-" + alignedseq2;
            }
            return new String[] {alignedseq1, alignedseq2};
        }

        boolean match = true;
        int matchValue;
        
        if (seq1.charAt(i-1) != seq2.charAt(j-1)) 
        {
            match = false;
        }
 
        if (seq1.charAt(i-1) == seq2.charAt(j-1)) 
        {
            matchValue = 1;
        }
        else 
        {
            matchValue = -1;
        }

        if (table[i-1][j-1] == table[i][j] - matchValue && match) 
        {
            alignedseq1 = "" + seq1.charAt(i-1);
            alignedseq2 = "" + seq2.charAt(j-1);
            i -= 1;
            j -= 1;
        } 
        else if (table[i][j-1] == table[i][j] - 1) 
        {
            alignedseq1 = "-";
            alignedseq2 = "" + seq2.charAt(j-1);
            j -= 1;
        } 
        else 
        {
            alignedseq1 = "" + seq1.charAt(i-1);
            alignedseq2 = "-";
            i -= 1;
        }

        // Recursion!
        String[] alignedStrands = FindPath(i, j);
        alignedseq1 = alignedStrands[0] + alignedseq1;
        alignedseq2 = alignedStrands[1] + alignedseq2;

        System.out.println(alignedseq1);
        System.out.println(alignedseq2);
        return new String[] {alignedseq1, alignedseq2};
    }
    
    /**
     * Main function that calls other functions
     */
    public static void main()
    {
        int[][] table = new int[len1 + 1][len2 + 1];
        table = generateMatrix();
        FindPath(len1,len2);
        printMatrix(table);
        //printStrings();
        printValue(table);
    }
}