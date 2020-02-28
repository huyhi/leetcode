package com.lcof;

import com.Util.ListNode;
import com.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode bigNode = p.val > q.val ? p : q,
                smallNode = p.val < q.val ? p : q;

        if (root == null) {
            return root;
        }
        if (root.val <= bigNode.val && root.val >= smallNode.val) {
            return root;
        }
        if (root.val > bigNode.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < smallNode.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }
}
