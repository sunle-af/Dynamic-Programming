import java.util.*;
public class ten {
    static boolean solve(String x, String y, int m, int n){
        int t[][] =new int [m+1][n+1];
        for(int row[] : t){
             Arrays.fill(row, 0);
        }
        for(int i=1; i< m+1; i++){
            for(int j=1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+ t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        boolean ans = t[m][n] ==m;
        return an;
    }
        public static void main(String[] args){
        String x= "cb";
        String y= "?a";
        int m = x.length();
        int n = y.length();

            System.out.print(solve(x,y,m,n));
            
    }
}
