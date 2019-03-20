package com.leetcode._300LongestIncrSubseq;

public class Solution {

    /**
     *  Solution1: 动态规划
     *  dp[i] 指以nums[i]结尾的最长子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {   //内层循环循环dp[]
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i] + 1);
        }

        return max;
    }
}
