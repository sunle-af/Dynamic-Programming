import java.util.*;
public class two {
    static int solve(String x, String y, int m, int n){
        int t[][] = new int[m+1][n+1];
        for(int row[]:t){
            Arrays.fill(row, 0);
        }
        int result = Integer.MIN_VALUE;
        for(int i=1; i<m+1; i++){
            for(int j =1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] =  1+t[i-1][j-1];
                }else t[i][j] = 0;
            result = Math.max(result, t[i][j]);
            }
        }return result;
    }
    public static void main(String[] args){
        String x = "zxabcdezy" ;
        String  y = "yzabcdezx" ;
        int m = x.length();
        int n = y.length();
        System.out.print(solve(x,y,m, n));

    }
}
