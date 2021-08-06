import java.util.*;
public class three {
    static String solve(String x, String y, int m, int n){
        int t[][] = new int [m+1][n+1];
        for(int row[]: t){
            Arrays.fill(row, 0);
        }
        for(int i =1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j]= 1+t[i-1][j-1];
                }else {
                    t[i][j]  = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        int i =m;
        int j = n;
        String str ="";
        while(i >0 && j> 0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                str = x.charAt(i-1)+str ; 
                i--;
                j--;
            }else if(t[i-1][j] > t[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
       return str;
    }
    public static void main(String[] args){
        String x = "heap";
        String y = "pea";
        int m  = x.length();
        int n = y.length();
        System.out.print(solve(x,y,m,n));

    }
}
