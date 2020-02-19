package com.leetcode._63UniquePathII;


public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        boolean flag = false;

        // 这里可以不用申请额外的 dp 数组，直接用 obstacleGrid
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1 && !flag) {
                flag = true;
            }
            dp[i][0] = flag ? 0 : 1;
        }
        flag = true;
        for (int i = 0; i < n; ++i) {
            if (obstacleGrid[0][i] == 1  && !flag) {
                flag = true;
            }
            dp[0][i] = flag ? 0 : 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int k = 1; k < n; ++k) {
                if (obstacleGrid[i][k] == 0) {
                    dp[i][k] = dp[i - 1][k] + dp[i][k - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
