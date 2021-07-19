import java.util.*;
public class minSubdiff{
    static Vector<Integer> subsetsum(int arr[], int sum){
        Vector<Integer> vec = new Vector<Integer>();
        int n = arr.length;
        boolean t[][] = new boolean [n+1][sum+1];
        for(int i =0; i<n+1; i++){
            for(int j =0; j<sum+1; j++){
               if(i==0) 
                t[i][j] = false; 
                if(j==0) t[i][j] = true; 
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j];

                }else if(arr[i-1] >j) {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        for(int i =0; i<n+1; i++){
            for(int j=0; j<=sum/2; j++){
                if(t[i][j] == true){
                    vec.add(j);
                }
            }
        }
        return vec;
    }
    static int minDiff(int arr[],int n){
       int sum =0;
       for(int i=0;i<n; i++){
           sum= arr[i]+ sum;
       }
       Vector<Integer> vec = new Vector<Integer>();
        vec=subsetsum(arr, sum);
        int min =Integer.MAX_VALUE ;

        for(int i =0; i<vec.size(); i++){
            min = Math.min(min, sum- (2* vec.get(i)) ) ;
        }
        return min;
    }
    public static void main(String[] args){
        int  arr[] = {1, 6, 11, 5};
        int n = arr.length;
        System.out.print(minDiff(arr, n));
    }
}