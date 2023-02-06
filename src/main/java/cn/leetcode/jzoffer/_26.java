package cn.leetcode.jzoffer;

import cn.leetcode.dsdefine.TreeNode;

public class _26 {

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        return compareTree(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }


    public boolean compareTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.val == b.val && compareTree(a.left, b.left) && compareTree(a.right, b.right);
    }
}
