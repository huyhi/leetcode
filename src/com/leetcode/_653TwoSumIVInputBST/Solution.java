package com.leetcode._653TwoSumIVInputBST;

import com.Util.TreeNode;

import java.util.*;


public class Solution {

    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int l = 0, r = this.list.size() - 1;
        while (l < r) {
            if (this.list.get(l) + this.list.get(r) == k) {
                return true;
            } else if (this.list.get(l) + this.list.get(r) < k) {
                l++;
            } else {
                r--;
            }
        }

        return false;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        this.list.add(root.val);
        inOrder(root.right);
    }
}
