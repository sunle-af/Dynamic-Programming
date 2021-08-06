import java.util.*;
public class four {
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
                str = x.charAt(i-1) + str ; 
                i--;
                j--;
            }else if(t[i-1][j] > t[i][j-1]){
                str = x.charAt(i-1) + str;
                i--;
            }else {
                str = y.charAt(j-1) + str;
                j--;
            }
        }
        while(i>0){
            str = x.charAt(i-1) + str;
            i--;
        }
        while(j>0) {
            str = y.charAt(j-1) + str;
            j--;
        }
    
     return str;
    }
    public static void main(String[] args){
        String x = "AGGTAB";
        String y = "GXTXAYB";
        int m  = x.length();
        int n = y.length();
        System.out.print(solve(x,y,m,n));


    }
}
