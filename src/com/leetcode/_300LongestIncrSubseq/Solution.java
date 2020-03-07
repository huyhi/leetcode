package com.leetcode._300LongestIncrSubseq;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;

        for (int i = 1; i < nums.length; ++i) {
            int incr = 0;
            for (int k = 0; k < i; ++k) {
                if (nums[i] > nums[k]) {
                    incr = Math.max(incr, dp[k]);
                }
            }
            dp[i] = incr + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
