package com.leetcode._41_FirstMissingPositive;

public class Solution2 {

    // leetcode 上的解法，哈希函数法， HashFun: hash(nums[i]) = nums[i] - 1
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; ++i) {
            while (nums[i] >= 1 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return len + 1;
    }

    public void swap(int[] a, int idx1, int idx2) {
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
}