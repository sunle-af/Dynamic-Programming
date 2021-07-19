public class subsetsum {
    static boolean solution (int[] arr, int sum, int n){
        boolean [][]t = new boolean [n+1][sum+1];
        //base condition
        for(int i =0; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(i==0) t[i][j]= false ;
                if(j==0) t[i][j]= true;
            }
        }
        for(int i=1; i<n+1; i++){
            for(int j=1; j<sum+1; j++){
                if(  arr[i-1]<= j  ){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else if(arr[i-1]> j){
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
    public static void main(String [] args){
        int arr[] ={2,3,7,8,10};
        int sum = 11;
        //length 
        int n = arr.length;
        System.out.print(solution(arr,sum,n));
    }
}
