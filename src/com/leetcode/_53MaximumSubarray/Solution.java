package com.leetcode._53MaximumSubarray;


public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maximum = nums[0];
        int sum = 0;

        for (int item : nums) {
            sum = Math.max(item, item + sum);
            maximum = Math.max(maximum, sum);
        }

        return maximum;
    }


    public int minSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int minimum = nums[0];
        int sum = 0;

        for (int item : nums) {
            sum = Math.min(item + sum, item);
            minimum = Math.min(minimum, sum);
        }

        return minimum;
    }
}
