package com.leetcode._746minCostUpstaire;



public class Solution {

    // 从前往后
    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0;
        for (int i = 0; i < cost.length; ++i) {
            int cur = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = cur;
        }

        return Math.min(f0, f1);
    }
}
