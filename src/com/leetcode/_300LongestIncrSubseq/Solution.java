package com.leetcode._300LongestIncrSubseq;

public class Solution {

    // 基于 dp 的方法，时间复杂度 O(N)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 1;
        int[] dp = new int[nums.length];    // dp[i] 指 nums[0:i] 一定包括 nums[i] 的LIS 长度
        dp[0] = 1;

        for (int i = 1; i < nums.length; ++i) {
            int tmp = 1;
            for (int k = 0; k < i; ++k) {
                if (nums[i] > nums[k]) {
                    tmp = Math.max(dp[k] + 1, tmp);
                }
            }
            dp[i] = tmp;
            max = Math.max(max, tmp);
        }

        return max;
    }
}
