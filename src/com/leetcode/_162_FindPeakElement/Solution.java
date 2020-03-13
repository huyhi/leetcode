package com.leetcode._162_FindPeakElement;

public class Solution {

    // 如果写出 O(N) 时间复杂的的解法比较简单，题目要求 O(LogN), 考虑二分算法
    // 如果 nums[i] > nums[i + 1] 那么峰值在 nums[i]及其左侧
    // 如果 nums[i] < nums[i + 1] 那么峰值在 nums[i + 1]及其右侧
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        int mid = (left + right) >> 1;

        while (left < right) {
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

    }
}
