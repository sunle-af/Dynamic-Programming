import java.util.*;
public class two {
 
    static int solve(String s, int i, int j) {
        int t[][] = new int[501][501];
        for (int row[]: t)
        Arrays.fill(row, -1);
        if (i >= j)
            return t[i][j] = 0;
        if (t[i][j] != -1)
            return t[i][j];
        if (isPalindrome(s, i, j))
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = 0, right = 0;
            if (t[i][k] != -1)
                left = t[i][k];
            else {
                left = solve(s, i, k);
                t[i][k] = left;
            }
            if (t[k + 1][j] != -1)
                right = t[k + 1][j];
            else {
                right = solve(s, k + 1, j);
                t[k + 1][j] = right;
            }
            int temp = right + left + 1;
            min = Math.min(min, temp);
        }
        return t[i][j] = min;
    }
    static boolean isPalindrome(String s, int i, int j) {
        if (i == j) return true;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "geek";
        //expected answer 2
        int i = 0;
        int j = s.length() - 1;
        System.out.println(solve(s, i, j));
    }
}