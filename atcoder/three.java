import java.util.*;
public class three {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int arr[][] = new int[n][3];
        
        for(int i =0; i<n; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int t[][] = new int[n+1][3];

        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    if(j==k){
                        continue;
                    }else{
                        t[i+1][k]  = Math.max( t[i+1][k], t[i][j] + arr[i][k] );
                    }
                }
            }
        }
        int result =0;
        for(int i=0; i<3; i++){
            result = Math.max(result, t[n][i]);
        }
        System.out.print(result);
    }
}
