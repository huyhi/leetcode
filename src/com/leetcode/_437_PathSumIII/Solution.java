package com.leetcode._437_PathSumIII;

import com.Util.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return dfs(root, sum) +
                pathSum(root.left, sum) +
                pathSum(root.right, sum);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int c = dfs(root.left, sum - root.val) +
                dfs(root.right, sum - root.val);

        return root.val == sum ? c + 1 : c;
    }
}
