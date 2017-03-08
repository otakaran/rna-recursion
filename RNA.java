
/**
 * Write a description of class RNA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RNA
{
    // instance variables - replace the example below with your own
    static String seq1 = "ABC";
    static String seq2 = "BCA";

    /**
     * Constructor for objects of class RNA
     */
    public RNA()
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
        
        /**
        if (len1 == len2)
        {
            int[][] table = new int[len1 + 1][len2 + 1];
        }
        else if (len1 < len2)
        {
            int[][] table = new int[len2 + 1][len2 + 1];
        }
        else if (len2 < len1)
        {
            int[][] table = new int[len1 + 1][len1 + 1];
        }
        else
        {
            System.out.print("ERROR 1 - ");
            System.out.print(len1);
            System.out.print(len2);
        }
        */
        
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
        
        // Generate remainder based on rules
        return 1;
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main()
    {
        generateMatrix();
    }
}