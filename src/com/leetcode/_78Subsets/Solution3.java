package com.leetcode._78Subsets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3 {
    List<List<Integer>> res = new ArrayList<>();

    // 递归树
    /*
         []
        /|\
      [1] [2] [3]
     / \
   [1,2][1, 3]
    /
  [1,2,3]
    ...
    ...
     */
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        dfs(new ArrayDeque<>(), nums, 0, len);
        return res;
    }

    public void dfs(Deque<Integer> path, int[] nums, int begin, int len) {
        res.add(new ArrayList<>(path));

        for (int i = begin; i < len; ++i) {
            path.addLast(nums[i]);
            dfs(path, nums,  i + 1, len);
            path.removeLast();
        }
    }
}
