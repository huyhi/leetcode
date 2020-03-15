package com.leetcode._718_MaxLenOfRepeatedSubArr;

public class Solution {

    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length, res = 0;
        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        // dp[i][j] 指的是 A[0:i] B[0:j] 最长子数组
        int[][] dp = new int[lenA][lenB];
        for (int i = 0; i < lenB; ++i) {
            if (A[0] == B[i]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < lenA; ++i) {
            if (B[0] == A[i]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < lenA; ++i) {
            for (int j = 1; j < lenB; ++j) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res;
    }
}

