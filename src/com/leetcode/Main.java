package com.leetcode;

import com.leetcode.Util.TreeNode;
import java.util.*;


public class Main {

    public static int multStr(String num1, String num2) {
        return 1;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
