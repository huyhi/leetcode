package com.leetcode._322_CoinChange;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE, count;
        for (int item : coins) {
            count = coinChange(coins, amount - item);
            if (count == -1) {
                continue;
            }
            res = Math.min(res, count + 1);
        }

        if (res != Integer.MAX_VALUE) {
            memo.put(amount, res);
        } else {
            memo.put(amount, -1);
        }

        return memo.get(amount);
    }
}
