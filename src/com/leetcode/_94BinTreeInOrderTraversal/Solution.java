package com.leetcode._94BinTreeInOrderTraversal;

import com.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            res.add(p.val);
            p = p.right;
        }

        return res;
    }
}
