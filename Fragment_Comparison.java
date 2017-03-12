
/**
 * Write a description of class Fragment_Comparison here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fragment_Comparison
{
    int len1 = 5;
    int len2 = 5;
    public void main()
    {
        int [][] table = new int [len1][len2];
        int col = 1;
        int row = 1;
        int a;
        int b;
        int c;
        while (col < len2) {
            for (int i = 1; i < len2; i++) {
                if(table[0][i] == table[col][0]) {
                    table[col][i] = 1;
                } else {
                    table[col][i] = -1;
                }
            }
            col++;
        }
        while(row < len2){
            for (int colm = 1; colm < len1; colm++) {
                if (row == 1) {
                    if (colm != 4){
                        table[row][colm + 1] += table[row][colm];
                    }
                } else {
                    if (colm == 1) {
                        table[row][colm] += table[row - 1][colm];
                    } else {
                        if (table[0][colm] == table[row][0]) {
                            a = table[row][colm] + table[row - 1][colm];
                            b = table[row][colm] + table[row - 1][colm - 1];
                            c = table[row][colm] + table[row][colm - 1];
                            if (a > b && a > c){
                                table[row][colm] += table[row - 1][colm];
                            } else if (b > a && b > c) {
                                table[row][colm] += table[row - 1][colm - 1];
                            } else {
                                table[row][colm] += table[row][colm - 1];
                            }
                        } else {
                            a = table[row][colm] + table[row - 1][colm];
                            
                            b = table[row][colm] + table[row][colm - 1];
                            if (a > b){
                                table[row][colm] += table[row - 1][colm];
                            } else {
                                table[row][colm] += table[row][colm - 1];
                            }
                        }
                    }
                }
            }
            row++;
            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    System.out.println(table[i][j]);
                }
            }
        }
    }
}
