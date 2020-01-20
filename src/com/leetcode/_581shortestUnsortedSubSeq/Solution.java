package com.leetcode._581shortestUnsortedSubSeq;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 6, 6, 4, 8, 10, 9, 9, 15};
//        int[] nums = new int[]{1, 2, 4, 5, 3};
        int res = findUnsortedSubarray(nums);

        System.out.println(res);
    }

    // leetcode 官方最优解法
    //
    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int left, right;
        for (left = 0; left < nums.length; ++left) {
            if (nums[left] > min) {
                break;
            }
        }
        for (right = nums.length - 1; right >= 0; --right) {
            if (nums[right] < max) {
                break;
            }
        }

        System.out.println(left);
        System.out.println(right);

        return left > right ? 0 : right - left + 1;
    }
}
