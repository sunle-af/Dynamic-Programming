import java.util.*;
public class eleven {
    static int solve(String x, String y, int m, int n){
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
        int lps = t[m][n];
        //result will be  string length - LPS -
        int result =  m - t[m][n];
        return result;

    }
   
    public static void main(String[] args){
        String x = "aebcbda";
       //we have to reverse the string
       StringBuilder sb = new StringBuilder();
       sb.append(x);
       sb.reverse();
       String y =  sb.toString();
       int m= x.length();
       int n = y.length();
       // also Insertion == deletion so just print deletion
       System.out.print("Number of Insertion and Deletion Required:- "+ solve(x,y,m,n));



        
    }
}
