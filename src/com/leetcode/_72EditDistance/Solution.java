package com.leetcode._72EditDistance;


public class Solution {

    public int minDistance(String word1, String word2) {

        // dp[i][j]  指 word1[1...i] 和 word2[i...j]
        int word1Length = word1.length(), word2Length = word2.length();
        int[][] dp = new int[word1Length + 1][word2Length + 1];
        for (int i = 0; i <= word1Length; ++i) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2Length; ++j) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1Length; ++i) {
            for (int j = 1; j <= word2Length; ++j) {
                int s1 = dp[i - 1][j] + 1;
                int s2 = dp[i][j - 1] + 1;
                int s3 = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(s1, Math.min(s2, s3));
            }
        }

        return dp[word1Length][word2Length];
    }
}