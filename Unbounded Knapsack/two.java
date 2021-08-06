public class two {
    static int solve (int coin[], int sum){
        //size is m
        // sum is n
       int size = coin.length;
       int t[][] = new int[size+1][sum+1];
       if(sum==0) return 0; 
       //for a case when we are given coins[] ={2} and sum 3
       // and its not possible
      else if(size == 1 &&  coin[0] <sum) return -1;
       //initiliastion
       for(int i=0;i<size+1;i++){
           for(int j=0; j<sum+1;j++){
               if(i==0)  t[i][j] = 0;
               if(j==0)  t[i][j] = 1;
           }
       }
    for(int i=1; i<size+1; i++){
        for(int j=1; j<sum+1; j++){
            if(coin[i-1]<= j  ){
                t[i][j] = t[i][j-coin[i-1]] + t[i-1][j];
            }else if(coin[i-1]> j){
                t[i][j] = t[i-1][j];
            }
        }
    }
    return t[size][sum];
    }
    public static void main(String [] args){
        int coins[] = {1,2,3};
        int sum = 4;
        System.out.println(solve(coins,sum));
    }
}
