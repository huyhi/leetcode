package com.leetcode._108SortedArrToBST;

import com.leetcode.Util.TreeNode;


public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return nums.length == 0 ? null :buildNode(nums, 0, nums.length - 1);
    }

    public TreeNode buildNode(int[] nums, int l, int r) {
        TreeNode res;
        if (r - l == 1) {
            res = new TreeNode(nums[r]);
            res.left = new TreeNode(nums[l]);
            return res;
        }
        if (r == l) {
            return new TreeNode(nums[r]);
        }
        int center = l + (r - l) / 2;
        res = new TreeNode(nums[center]);
        res.left = buildNode(nums, l, center - 1);
        res.right = buildNode(nums, center + 1, r);

        return res;
    }
}
