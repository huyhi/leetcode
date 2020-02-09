package com.leetcode._105ConstructBinaryTreeFromPreorderAndInorder;


import com.leetcode.Util.TreeNode;

public class Solution {

    public TreeNode buildTree (int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build (int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (inLeft == inRight) {
            return new TreeNode(inOrder[inLeft]);
        }

        TreeNode root = new TreeNode(preOrder[preLeft]);
        int i = inLeft;
        while (inOrder[i] != root.val) {
            i++;
        }
        int pace = i - inLeft;

        if (i == inLeft) {
            root.left = null;
        } else {
            root.left = build(preOrder, preLeft + 1, preLeft + pace, inOrder, inLeft, i - 1);
        }

        if (i == inRight) {
            root.right = null;
        } else {
            root.right = build(preOrder, preLeft + pace + 1, preRight, inOrder, i + 1, inRight);
        }

        return root;
    }
}
