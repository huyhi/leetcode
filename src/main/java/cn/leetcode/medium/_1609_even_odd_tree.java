package cn.leetcode.medium;

import cn.leetcode.dsdefine.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _1609_even_odd_tree {

    // 层次遍历
    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            List<TreeNode> levelList = new ArrayList<>(queue);
            queue.clear();

            boolean depthIsEven = depth % 2 == 0;
            // check item is even or odd
            for (TreeNode item : levelList) {
                boolean valIsEven = item.val % 2 == 0;
                if (depthIsEven) {
                    if (valIsEven) {
                        return false;
                    }
                } else {
                    if (!valIsEven) {
                        return false;
                    }
                }
            }
            // check level asc or desc
            for (int i = 0; i <= levelList.size() - 2; ++i) {
                if (depthIsEven) {
                    if (levelList.get(i).val >= levelList.get(i + 1).val) {
                        return false;
                    }
                } else {
                    if (levelList.get(i).val <= levelList.get(i + 1).val) {
                        return false;
                    }
                }
            }
            // add to queue
            for (TreeNode item : levelList) {
                if (item.left != null) {
                    queue.add(item.left);
                }
                if (item.right != null) {
                    queue.add(item.right);
                }
            }

            depth++;
        }

        return true;
    }
}
