
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

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int generateMatrix()
    {
        int len1 = seq1.length();
        int len2 = seq2.length();
        
        if (len1 == len2)
        {
            int[][] myArray = new int[len1 + 1][len2 + 1];
            System.out.println(len1);
        }
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