public class one {
    static int solve(int price[], int n) {
        int size = n;
        int length[] = new int[n];
        for (int i = 0; i < n; i++) length[i] = i + 1;

        int t[][] = new int[n + 1][size + 1];
        //both first row and coloum to 0
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int i = 0; i <= size; i++) {
            t[0][i] = 0;
        } 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= size; j++) {
                if (length[i - 1] <= j)
                    t[i][j] = Math.max(price[i - 1] + t[i][j - length[i - 1]], t[i - 1][j]);
                else if (length[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][size];
    }
    public static void main(String[] args) {
        int n = 8;
        int price[] = {3,5, 8,9,10,17,17,20};

        System.out.print(solve(price, n));

    }
}