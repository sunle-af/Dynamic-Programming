import java.util.*;
public class eight {
    static String solve(String x, String y, int m, int n){
        int t[][] = new int [m+1][n+1];
        for(int row[] : t) {
            Arrays.fill(row, 0);
        }
        for(int i =1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1+ t[i-1][j-1];
                }
                else {
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        int i=m;
        int j=n;
        String ans = "";
        while(i>0 && j>0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                ans = x.charAt(i-1) + ans;
                i--;
                j--; 
            }
            else if(t[i-1][j] > t[i][j-1]){
                ans = x.charAt(i-1) + ans;
                i--;
            }
            else {
                ans = y.charAt(j-1) + ans;
                j--;
            }
        }
        while(i>0){
            ans = ans +  x.charAt(i-1);
            i--;
        }
        
        while(j>0){
            ans = ans +  y.charAt(j-1);
            j--;
        }
        return ans;
    }
    public static void main(String[] args){
        String x = "acbcf";
        String y = "abcdaf";
        int m =x.length();
        int n = y.length();
        System.out.print(solve(x, y, m, n));
    }
}
