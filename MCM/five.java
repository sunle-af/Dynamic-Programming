 
import java.util.*;
public class five {
    static int solve(int e, int f){
        int t[][] = new int [1001][1001];
        for (int[] row: t)
            Arrays.fill(row, -1);
            if (f == 0 || f == 1 || e == 1)
            return f;
        if (t[e][f] != -1)
            return t[e][f];
    
        int ans = Integer.MAX_VALUE, temp, l = 1, h = f;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            int left = solve(e - 1, mid - 1);
            int right = solve(e, f - mid) ;
            temp = 1 + Math.max(left, right);
            if (left < right) {
    
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
            ans = Math.min(ans, temp);
        }
        return t[e][f] = ans;
     }
    public static void main(String[] args){
        int e = 2;
        int f = 36;
        System.out.println(solve(e, f));
    }
}
