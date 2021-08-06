import java.util.*;
public class LCS{
    static int lcs(String x, String y, int m , int n){
        int t[][] = new int [m+1][n+1];
        for(int row[] : t){
            Arrays.fill(row, 0);
        }
        for(int i=1 ; i<m+1 ; i++)
        {
            for(int j=1 ; j<n+1 ; j++)
            {
                if(x.charAt(i-1)==y.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
            }
        }
        return t[m][n];
    }
    public static void main(String [] args){
        String x = "abcde";
        String y = "ace";
        int m = x.length();
        int n = y.length();
        System.out.print(lcs(x, y, m, n));
    }
}