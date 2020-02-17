package com.leetcode._110IsBalanceBinTree;


import com.leetcode.Util.TreeNode;

public class Solution {

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        dpsDepth(root);
        return res;
    }

    public int dpsDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dpsDepth(root.left) + 1;
        int right = dpsDepth(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            this.res = false;
        }
        return Math.max(left, right);
    }
}
