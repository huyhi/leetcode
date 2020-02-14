package com.leetcode._236LowestCommonAncestorOfBinTree;

import com.leetcode.Util.TreeNode;

import java.util.*;

// leetcode 解法2
public class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //
        Deque<TreeNode> stack = new ArrayDeque<>();
        // map 存放祖先节点 (子节点 => 父节点）
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }

        Set<TreeNode> set = new HashSet<>();

        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}