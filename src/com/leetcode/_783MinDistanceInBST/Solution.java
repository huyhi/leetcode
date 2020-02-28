package com.leetcode._783MinDistanceInBST;

import com.Util.TreeNode;

public class Solution {
    Integer pre = null;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode p) {
        if (p == null) {
            return;
        }
        dfs(p.left);
        if (pre != null) {
            min = Math.min(min, p.val - pre);
        }
        pre = p.val;
        dfs(p.right);
    }
}
