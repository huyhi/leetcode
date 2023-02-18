package cn.leetcode.medium;

public class _221_max_square {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxLen = 0;

        int[][] dp = new int[row][col];
        // init dp array
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                maxLen = 1;
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == '1') {
                maxLen = 1;
                dp[0][i] = 1;
            }
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (matrix[r][c] == '0') {
                    dp[r][c] = 0;
                    continue;
                }

                dp[r][c] = 1 + Math.min(dp[r - 1][c - 1], Math.min(dp[r][c - 1], dp[r - 1][c]));
                maxLen = Math.max(dp[r][c], maxLen);
            }
        }

        return maxLen * maxLen;
    }
}
