import java.util.*;
public class four {
    static long solve(int []wt,int val[], int W, int n){
        long t[][] = new long[n+1][W+1];
        for(long row[]: t){
            Arrays.fill(row, -1);
        }
        if(t[n][W] != -1) return t[n][W];
        for(int i=0; i<n+1; i++ ){
            for(int j=0; j<W+1; j++){
                if(i==0|| j==0) {
                    t[i][j] = 0;
                }
            }
        }
        for(int i=1; i<n+1; i++ ){
            for(int j=1; j<W+1; j++){
               if(wt[i-1] <= j){
                t[i][j] = Math.max(val[i-1] +  t[i-1][j-wt[i-1]], t[i-1][j]);
               }else 
               {
                   t[i][j] = t[i-1][j];
               }
            }
        }
        return t[n][W];
    }
    public static void main (String args[] ){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int W = sc.nextInt();
       int wt[] = new int [n];
       int val[] = new int [n];
       for(int i =0; i<n; i++){
           wt[i] = sc.nextInt();
           val[i] = sc.nextInt();
       }
       System.out.println(solve(wt, val, W, n));
    sc.close();
    }
}
