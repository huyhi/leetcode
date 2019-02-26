package com.leetcode._121BestTimeToBuyAndSell;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int maximum = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            maximum = Math.max(maximum, prices[i] - min);
        }

        return maximum;
    }

    public static void main(String[] args) {

    }
}
