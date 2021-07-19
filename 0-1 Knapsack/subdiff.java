public class subdiff {
    static int countsubsetsum(int arr[], int sum , int n){
        int t[][] = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }if(arr[i-1] >j) {
                    t[i][j] = t[i-1][j];
                }
            }
        }return t[n][sum];
    }
    static int solution(int arr[], int diff, int n){
       int sum=0;
        for(int i =0; i<n; i++){
            sum = sum+arr[i];
        }
        int s1 = (diff+sum) / 2;
        return countsubsetsum(arr, s1, n);
    }
    public static void main(String[] args){
        int []arr={1,1,2,3};
        int n = arr.length;
        int diff=1;
        System.out.print(solution(arr, diff, n));
    }
}
