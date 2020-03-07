package com.leetcode._16_3SumClosest;

import java.util.Arrays;

public class Solution {

    // leetcode 推荐解法
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; ++i) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    return sum;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().threeSumClosest(new int[]{1, 1, -1}, 1);
    }
}
