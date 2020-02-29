package com.leetcode._46Permutations;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// leetcode 官方解法，基于Swap的回溯算法
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        List<Integer> numList = new ArrayList<>();
        for (int item : nums) {
            numList.add(item);
        }

        dfs(0, len, numList);
        return res;
    }

    public void dfs(int level, int len, List<Integer> numList) {
        if (level == len) {
            res.add(new ArrayList<>(numList));
        }

        for (int i = level; i < len; ++i) {
            Collections.swap(numList, i, level);
            dfs(level + 1, len, numList);
            Collections.swap(numList, i, level);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Solution().permute(nums);

        System.out.println(res);
    }
}