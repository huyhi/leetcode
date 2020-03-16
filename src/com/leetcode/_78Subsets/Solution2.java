package com.leetcode._78Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {
    // 递归树
    /*
        []
        /\
      []  [1]
      /\    / \
    [] [2] [1] [1,2]
    ...
    ...
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        dfs(new ArrayDeque<>(), nums, 0, len);
        return res;
    }

    public void dfs(Deque<Integer> path, int[] nums, int depth, int len) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(path, nums, depth + 1, len);

        path.add(nums[depth]);
        dfs(path, nums, depth + 1, len);
        path.removeLast();
    }
}
