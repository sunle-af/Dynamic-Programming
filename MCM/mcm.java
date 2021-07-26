import java.util.*;
public class mcm{
    static int solve(int arr[], int i, int j){
        int[][] t = new int[1001][1001];
        // Fill each row with -1
        for (int[] row: t)
            Arrays.fill(row, -1);
        if(i == j) return 0;
        if( t[i][j] != -1 ){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k=i; k<= j-1; k++){
           int temp =  solve(arr, i, k) + solve(arr, k+1, j) + arr[i-1] * arr[k] *arr[j] ;   
            min = Math.min(min, temp);
            t[i][j] = min;
        }
        return t[i][j];
    }
    public static void main(String [] args){
        int arr[] = { 1, 2, 3, 4 };
        //expected answer is 18
        int i = 1;
        int j= arr.length-1;
        System.out.print(solve(arr, i, j));
    }
}