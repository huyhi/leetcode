package com.leetcode._1143_LCS;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();

        for (int i = 0; i < len1; ++i) {
            for (int k = 0; k < len2; ++k) {
                if (c1[i] == c2[k]) {
                    dp[i + 1][k + 1] = dp[i][k] + 1;
                } else {
                    dp[i + 1][k + 1] = Math.max(dp[i + 1][k], dp[i][k + 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        new Solution().longestCommonSubsequence("jmjkbkjkv", "bsbininm");
    }
}
