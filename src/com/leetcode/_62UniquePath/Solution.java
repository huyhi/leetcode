package com.leetcode._62UniquePath;


// 动态规划
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        // 初始化
        dp[0][0] = 0;
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int k = 1; k < n; ++k) {
                dp[i][k] = dp[i - 1][k] + dp[i][k - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
