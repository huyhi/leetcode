package com.leetcode._123BestTimeToBuyAndSell_3;


public class Solution {

    int times = 2;
    // dp[天数][最大交易次数][是否持有]     0 不持有，1 持有
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length][times + 1][2];

        for (int d = 0; d < prices.length; ++d) {
            for (int t = 1; t < times + 1; ++t) {
                if (d == 0) {
                    dp[d][t][0] = 0;
                    dp[d][t][1] = -prices[d];
                } else {
                    dp[d][t][0] = Math.max(dp[d - 1][t][0], dp[d - 1][t][1] + prices[d]);
                    dp[d][t][1] = Math.max(dp[d - 1][t][1], dp[d - 1][t - 1][0] - prices[d]);
                }
            }
        }

        return dp[prices.length - 1][times][0];
    }
}
