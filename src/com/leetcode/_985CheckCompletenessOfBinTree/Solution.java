package com.leetcode._985CheckCompletenessOfBinTree;

import com.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isCompleteTree (TreeNode root) {
        if (root == null) {
            return false;
        }

        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.left != null) {
                if (!flag) {
                    return false;
                }
                queue.add(p.left);
            } else if (flag) {
                flag = false;
            }
            if (p.right != null) {
                if (!flag) {
                    return false;
                }
                queue.add(p.right);
            } else if (flag) {
                flag = false;
            }
        }

        return true;
    }
}
