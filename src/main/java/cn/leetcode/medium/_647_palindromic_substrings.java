package cn.leetcode.medium;

public class _647_palindromic_substrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int sLength = s.length();
        int res = 0;
        // dp[i][k] means that if s[i:k] is palindromic
        boolean dp[][] = new boolean[sLength][sLength];
        for (int i = 0; i < sLength; i++) {
            dp[i][i] = true;
        }
        for (int col = 1; col < sLength; col++) {
            for (int row = 0; row <= col; row++) {
                boolean b = s.charAt(row) == s.charAt(col);
                if (row + 1 < col - 1) {
                    dp[row][col] = dp[row + 1][col - 1] && b;
                } else {
                    dp[row][col] = b;
                }
            }
        }
        // count true item
        for (int i = 0; i < sLength; i++) {
            for (int k = i; k < sLength; k++) {
                if (dp[i][k]) {
                    res++;
                }
            }
        }
        return res;
    }
}
