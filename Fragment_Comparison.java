
/**
 * Write a description of class Fragment_Comparison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fragment_Comparison
{
    int [len1][len2] table = 0;
    int len1 = 0;
    int len2 = 0;
    public static void main(String args[])
    {    
        for(i = 0; i < (len1*len2); i++)
        {
            if (table[len1] != table[len2])
            {
                return -1;
            }
            if (table[len1] == table[len2])
            {
                return 1;
            }
        }
    }
}

