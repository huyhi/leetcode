package com.lintcode;

public class _45MaximumSubarray {

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

    public static void main(String[] args) {

        int[] arr = {1, 2, -3, 1};

        System.out.println(new _45MaximumSubarray().minSubArray(arr));
    }
}
