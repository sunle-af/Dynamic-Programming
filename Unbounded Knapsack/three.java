public class three {
        static int solve (int coin[], int sum){
            int size = coin.length;
            int[][] t = new int [size+1][sum+1];  //top down matirx
            
            for(int i = 0; i <= sum ; i++){
                t[0][i] = Integer.MAX_VALUE - 1; //if no coin are present then infinte coin are required to settle
            }
            for(int i = 1; i <= size; i++){
                t[i][0] = 0; //if sum is 0 then we require min 0 coin
            }
            for(int i = 1; i <= sum; i++){
                if(i % coin[0] == 0){
                    t[1][i] = i / coin[0]; //if we get sum in multiple of first coin then we simply store the division of the coin
                }else{
                    t[1][i] = Integer.MAX_VALUE - 1; // as their is only one coin and we cant make its sum equal to sum it takes infinte coin to do so
                }   
            }
            for(int i =0; i<size+1;i++){
                for(int j=0; j<sum+1; j++){
                    System.out.print(t[i][j]+" ");
                }System.out.println("");
            }
            for(int i = 1; i<=size; i++) {
                for(int j = 1; j<=sum; j++) {
                    if(coin[i-1] <=j) {
                        t[i][j] = Math.min( 1 + t[i][j - coin[i-1]], t[i-1][j] );
                    }
                    else if(coin[i-1] > j) {
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            //just checking if the value is Max then return -1
            if(t[size][sum]==-1) return -1;
            else return t[size][sum];
            
        }
        public static void main(String [] args){
            int coin[] = {1,2,5};
            int sum = 11 ;
            System.out.println(solve(coin,sum));
        }
}
