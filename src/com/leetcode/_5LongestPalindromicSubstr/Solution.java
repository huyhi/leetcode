package com.leetcode._5LongestPalindromicSubstr;

// 动态规划
public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // dp[i][j] 代表 s[i, j] 是否为回文
        // 状态转移方程 dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
        boolean[][] dp = new boolean[len][len];
        // 初始化dp dp[i][i] 只有一个字母，一定是回文
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }

        int subStrLen = 1, start = 0;
        for (int j = 1; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {   // s[i], s[j] 中间只有一个或零个元素，这时一定是回文
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > subStrLen) {
                        subStrLen = curLen;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + subStrLen);
    }
}
