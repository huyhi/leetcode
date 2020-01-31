package com.leetcode._53MaximumSubarray;


public class Solution {

    public static int maxSubArray(int[] nums) {
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

    public static void main(String[] args) {
        int[] a = new int[]{-1, -2, -3};
        System.out.println(maxSubArray(a));
    }
}
