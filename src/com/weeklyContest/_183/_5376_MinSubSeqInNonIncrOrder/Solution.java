package com.weeklyContest._183._5376_MinSubSeqInNonIncrOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        Arrays.sort(nums);
        res.add(nums[len - 1]);
        int leftSum = 0, rightSum = nums[len - 1];
        int left = 0, right = len - 2;

        while (left <= right) {
            if (leftSum + nums[left] < rightSum) {
                leftSum += nums[left];
                left++;
            } else {
                res.add(nums[right]);
                rightSum += nums[right];
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {7};
        System.out.println(new Solution().minSubsequence(a));
    }
}
