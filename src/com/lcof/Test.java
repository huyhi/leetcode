package com.lcof;

import com.Util.TreeNode;

public class Test {

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currentNodeResult = 0;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                currentNodeResult += root.left.left == null ? 0 : root.left.left.val;
                currentNodeResult += root.left.right == null ? 0 : root.left.right.val;
            }
            if (root.right != null) {
                currentNodeResult += root.right.left == null ? 0 : root.right.left.val;
                currentNodeResult += root.right.right == null ? 0 : root.right.right.val;
            }
        }
        return currentNodeResult +
                sumEvenGrandparent(root.left) +
                sumEvenGrandparent(root.right);
    }
}