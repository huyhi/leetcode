package com.lcof._34_pathSumii;

import com.Util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        dfs(root, sum, new LinkedList<>());
        return res;
    }

    public void dfs(TreeNode root, int sum, LinkedList<Integer> level) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                // 回溯
                level.add(root.val);
                res.add(new ArrayList<>(level));
                level.removeLast();
            }
            return;
        }

        // 回溯，进去再出来
        level.add(root.val);
        if (root.left != null) {
            dfs(root.left, sum - root.val, level);
        }
        if (root.right != null) {
            dfs(root.right, sum - root.val, level);
        }
        level.removeLast();
    }
}
