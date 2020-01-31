package com.leetcode._101SymmetricTree;

import com.leetcode.Util.TreeNode;


public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return l.val == r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }
}
