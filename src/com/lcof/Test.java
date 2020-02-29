package com.lcof;

import com.Util.ListNode;
import com.Util.TreeNode;
import com.leetcode._2AddTwoNumbers.Solution;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();

        dfs(nums, used, len, 0, path, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, int len, int depth,
                    List<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                dfs(nums, used, len, depth + 1, path, res);
                path.remove(depth);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = new Test().permute(nums);

        System.out.println(res);
    }
}
