package com.leetcode._41_FirstMissingPositive;

import java.util.Arrays;

public class Solution {

    // 2020 春招字节跳动面试算法
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0) {
                i++;
            } else {
                break;
            }
        }
        if (i == nums.length) {
            return 1;
        }

        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1] || nums[i] + 1 == nums[i + 1]) {
                i++;
            } else {
                return nums[i] + 1;
            }
        }

        return nums[i] + 1;
    }
}
