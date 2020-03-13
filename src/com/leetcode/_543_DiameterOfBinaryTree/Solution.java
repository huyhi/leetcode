package com.leetcode._543_DiameterOfBinaryTree;

import com.Util.TreeNode;

public class Solution {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        len(root);
        return res;
    }

    public int len(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = len(node.left);
        int right = len(node.right);
        res = Math.max(left + right + 1, res);
        return Math.max(left, right) + 1;
    }
}
