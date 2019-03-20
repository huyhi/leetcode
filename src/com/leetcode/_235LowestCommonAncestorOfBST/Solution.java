package com.leetcode._235LowestCommonAncestorOfBST;

import com.leetcode.Util.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (p.val == root.val || q.val == root.val) {
            return root;
        } else if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {  //两个元素的val都比root.val小，应该去往左边找
            return lowestCommonAncestor(root.left, p, q);
        } else {                                            //最后这种情况是应该往右边找
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
