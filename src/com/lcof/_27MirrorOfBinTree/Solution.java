package com.lcof._27MirrorOfBinTree;

import com.leetcode.Util.TreeNode;

public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = tmp;

        return root;
    }
}
