package com.leetcode._236LowestCommonAncestorOfBinTree;


import com.leetcode.Util.TreeNode;

import java.util.Stack;

public class Solution3 {
    private final int BOTH_DONE = 0, LEFT_DONE = 1, BOTH_PENDING = 2;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, BOTH_PENDING));

        boolean oneNodeFound = false;
        TreeNode LCA = null, childNode = null;

        // 后序遍历入栈
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            TreeNode parentNode = top.node;
            int parentStatus = top.status;

            if (parentStatus != BOTH_DONE) {
                if (parentStatus == BOTH_PENDING) {
                    if (parentNode == p || parentNode == q) {
                        if (oneNodeFound) {
                            return LCA;
                        } else {
                            oneNodeFound = true;
                            LCA = stack.peek().node;
                        }
                    }
                    childNode = parentNode.left;
                } else {
                    childNode = parentNode.right;
                }
                stack.pop();
                stack.push(new Pair(parentNode, parentStatus - 1));

                if (childNode != null) {
                    stack.push(new Pair(childNode, BOTH_PENDING));
                }
            } else {
                if (LCA == stack.pop().node && oneNodeFound) {
                    LCA = stack.peek().node;
                }
            }
        }

        return null;
    }
}

class Pair {
    TreeNode node;
    int status;

    public Pair(TreeNode node, int status) {
        this.node = node;
        this.status = status;
    }
}
