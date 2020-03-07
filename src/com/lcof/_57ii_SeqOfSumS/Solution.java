package com.lcof._57ii_SeqOfSumS;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        int low = 1, high = 2, sum = low + high;
        List<int[]> res = new ArrayList<>();

        while (low < high && high < target) {
            if (sum < target) {
                high++;
                sum += high;
            } else if (sum > target) {
                sum -= low;
                low++;
            } else {
                int[] level = new int[high - low + 1];
                for (int i = 0; i < level.length; ++i) {
                    level[i] = low + i;
                }
                res.add(level);
                sum -= low;
                low++;
            }
        }

        int[][] resArr = new int[res.size()][];
        return res.toArray(resArr);
    }
}
