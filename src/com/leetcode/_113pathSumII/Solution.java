package com.leetcode._113pathSumII;


import com.leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public void dfs (TreeNode root, List<Integer> every, int target) {
        if (root == null) {
            return;
        }
        every.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            res.add(new LinkedList<>(every));   // 拷贝一份加入到res
            every.remove(every.size() - 1);     // stack 回溯
            return;
        }

        dfs(root.left, every, target - root.val);
        dfs(root.right, every, target - root.val);
        every.remove(every.size() - 1);         // stack 回溯
    }

    public List<List<Integer>> pathSum (TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, new LinkedList<>(), sum);
        return res;
    }
}
