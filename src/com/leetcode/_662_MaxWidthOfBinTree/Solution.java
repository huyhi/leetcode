package com.leetcode._662_MaxWidthOfBinTree;


import com.Util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (true) {
            while (!queue.isEmpty() && queue.peekLast() == null) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && queue.peekFirst() == null) {
                queue.pollFirst();
            }

            if (queue.size() == 0) {
                return maxWidth;
            } else {
                maxWidth = Math.max(maxWidth, queue.size());
            }

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; ++i) {
                TreeNode polled = queue.pollFirst();
                if (polled == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(polled.left);
                    queue.add(polled.right);
                }
            }
        }
    }
}
