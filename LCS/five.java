import java.util.Arrays;

public class five {
    static void solve(String x, String y, int m, int n){
        int t[][] = new int[m+1][n+1];
        for(int row[] : t){
            Arrays.fill(row, 0);
        }
        for(int i =1; i<m+1; i++){
            for(int j =1; j<n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1) ){
                    t[i][j] = t[i-1][j-1] +1 ;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        int lcs = t[m][n];
        int delete = m-lcs;  
        int insert = n-lcs;
        System.out.println("Number of Insertion:- "+ insert );
        System.out.println("Number of Deletion:- "+ delete );
    }
    public static void main(String[] args){
        String x = "heap";
        String y = "pea";
        int m  = x.length();
        int n = y.length();
        solve(x,y,m,n);
    }
}
