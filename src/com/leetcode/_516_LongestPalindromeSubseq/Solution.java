package com.leetcode._516_LongestPalindromeSubseq;


public class Solution {

    // https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/zi-xu-lie-wen-ti-tong-yong-si-lu-zui-chang-hui-wen/
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        // dp[i][j] 指的是 s[i:j] 最长子序的长度
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; ++i) {
            dp[i][i] = 1;
        }

        // 这个是一层一层遍历
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        // 这个是斜着遍历
//        for (int j = 1; j < len; ++j) {
//            for (int i = 0; i < len - j; ++i) {
//                if (s.charAt(i) == s.charAt(i + j)) {
//                    dp[i][i + j] = dp[i + 1][i + j - 1] + 2;
//                } else {
//                    dp[i][i + j] = Math.max(dp[i + 1][i + j], dp[i][i + j - 1]);
//                }
//            }
//        }

        return dp[0][len - 1];
    }
}
