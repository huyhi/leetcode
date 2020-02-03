package com.leetcode._128LongestConsecutiveSeq;


import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for (int item : nums) {
            s.add(item);
        }

        for (int item : nums) {
            int tmp = item, curLength = 1;
            item = tmp + 1;
            while (s.contains(item)) {
                curLength++;
                s.remove(item++);
            }
            item = tmp - 1;
            while (s.contains(item)) {
                curLength++;
                s.remove(item--);
            }

            res = Math.max(curLength, res);
        }

        return res;
    }
}
