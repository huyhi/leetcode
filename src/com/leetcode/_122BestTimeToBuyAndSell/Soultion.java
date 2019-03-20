package com.leetcode._122BestTimeToBuyAndSell;

public class Soultion {

    /**
     * 贪心，找规律
     */
    public int maxProfit(int[] prices) {
        int res = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }

        return res;
    }
}
