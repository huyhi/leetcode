package cn.leetcode.medium;

import cn.leetcode.dsdefine.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _103_zigzag_level_order {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int height = 1;

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // copy temp
            List<TreeNode> levelCopied = new ArrayList<>(queue);
            queue.clear();
            for (TreeNode iNode : levelCopied) {
                if (iNode.left != null) {
                    queue.add(iNode.left);
                }
                if (iNode.right != null) {
                    queue.add(iNode.right);
                }
            }

            boolean isEven = height % 2 == 0;
            if (isEven) {
                Collections.reverse(levelCopied);
            }
            res.add(levelCopied.stream().map(i -> i.val).collect(Collectors.toList()));
            height++;
        }

        return res;
    }
}
