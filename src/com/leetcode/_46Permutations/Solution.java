package com.leetcode._46Permutations;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public void backtrack(int n, List<Integer> nums, List<List<Integer>> output, int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; ++i) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            // 回溯
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int item : nums) {
            numsList.add(item);
        }
        int n = nums.length;
        backtrack(n, numsList, output, 0);
        return output;
    }
}
