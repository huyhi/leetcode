package com.leetcode._283MoveZeros;

import java.util.Collections;


public class Solution {
    // 想到了方法自然很简单
    public static void moveZeros(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }

        for (int i = slow; slow <= nums.length - 1; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
