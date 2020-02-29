package com.leetcode._46Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 另一种回溯的思路
public class Solution2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        boolean[] flags = new boolean[nums.length];
        List<Integer> levelList = new ArrayList<>();
        dfs(0, len, levelList, nums, flags);

        return res;
    }

    public void dfs(int level, int len, List<Integer> levelList,
                    int[] nums, boolean[] flags) {
        if (level == len) {
            res.add(new ArrayList<>(levelList));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!flags[i]) {
                flags[i] = true;
                levelList.add(nums[i]);
                dfs(level + 1, len, levelList, nums, flags);
                flags[i] = false;
                levelList.remove(level);
            }
        }
    }
}
