import java.util.*;
public class two {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();    
        }
        int t[] = new int[n];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[0] = 0;
        for(int i =0;i<n; i++){
            for(int j=i+1; j<=i+k; j++){
                if(j<n){
                t[j] = Math.min(t[j] , t[i] + Math.abs(arr[i] - arr[j]));
                }
            }
        }
        System.out.print(t[n-1]);
        sc.close();
    }   
}
