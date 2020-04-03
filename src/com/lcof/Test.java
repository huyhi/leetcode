package com.lcof;

import com.Util.TreeNode;

public class Test {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val &&
                helper(left.left, right.right) && helper(left.right, right.left);
    }
}