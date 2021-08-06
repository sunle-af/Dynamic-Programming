    import java.util.*;
    public class one {
        static int solve(int arr[],int n){
            int t[] = new int[n];
            Arrays.fill(t, Integer.MAX_VALUE);
            t[0] = 0;
            for(int i =0;i<n; i++){
                for(int j=i+1; j<=i+2; j++){
                    if(j<n){
                    t[j] = Math.min(t[j] , t[i] + Math.abs(arr[i] - arr[j]));
                    }
                }
            }
            return t[n-1];
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i =0; i<n; i++){
                arr[i] = sc.nextInt();    
            }
            System.out.print(solve(arr, n));
            sc.close();
        }    
    
        
    }
