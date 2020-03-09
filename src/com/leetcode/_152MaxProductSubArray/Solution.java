package com.leetcode._152MaxProductSubArray;


public class Solution {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        for (int i = 0; i < len; ++i) {
            int tmp = 1;
            for (int k = i; k < len; ++k) {
                tmp *= nums[k];
                maxProduct = Math.max(maxProduct, tmp);
            }
        }

        return maxProduct;
    }
}
