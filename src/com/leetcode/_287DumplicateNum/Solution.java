package com.leetcode._287DumplicateNum;

public class Solution {

    // leetcode 上的二分解法
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;

            for (int item : nums) {
                count += item <= mid ? 1 : 0;
            }

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}