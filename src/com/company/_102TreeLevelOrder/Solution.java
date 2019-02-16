package com.company._102TreeLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            TreeNode curr;
            int count = queue.size();

            while (count-- > 0) {
                curr = queue.remove();
                tmp.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    //LeerCode 上面看到的神仙递归解法
    public List<List<Integer>> revLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        addLevel(res, 0, root);
        return res;
    }

    public void addLevel(List<List<Integer>> res, int level, TreeNode node) {
        if (node == null) {
            return;
        }

        if (res.size() - 1 < level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        addLevel(res, level + 1, node.left);
        addLevel(res, level + 1, node.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
