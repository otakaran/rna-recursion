// Import math for :)
import java.lang.Math;
import java.util.Arrays;

public class AlignSequence
{
    // instance variables - replace the example below with your own
    static String seq1 = "ABC";
    static String seq2 = "BCA";

    /**
     * Constructor for objects of class RNA
     */
    public AlignSequence()
    {
        // initialise instance variables
    }

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
    
    public static int generateMatrix()
    {
        int len1 = seq1.length();
        int len2 = seq2.length();
        
        int[][] table = new int[len1 + 1][len2 + 1];
        int value;
        
        // Generate the outline of the matrix
        table[0][0]= 0;
        for (int i = 1; i <= len1; i++) 
        {
            table[0][i] = table[0][i-1] + -1;
        }
        for (int j = 1; j <= len2; j++) 
        {
            table[j][0] = table[j-1][0] + -1;
        }
        
        printMatrix(table);
        
        for (int i = 1; i <= len1; i++) 
        {
            for (int j = 1; j <= len2; j++) 
            {
                if (seq1.charAt(i-1) == seq2.charAt(j-1)) 
                {
                    value = 1;
                }
                else 
                {
                    value = -1;
                }
                
                table[i][j] = java.lang.Math.max((table[i][j-1] - 1), java.lang.Math.max((table[i-1][j] - 1), (table[i-1][j-1] + value)));
            }
        }
        
        printMatrix(table);
        
        // Generate remainder based on rules
        return 1;
    }

    public static void main()
    {
        generateMatrix();
    }
}