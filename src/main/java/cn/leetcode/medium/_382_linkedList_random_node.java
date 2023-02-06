package cn.leetcode.medium;

import cn.leetcode.dsdefine.ListNode;

public class _382_linkedList_random_node {
}

class Solution {

    private ListNode listNode;

    public Solution(ListNode head) {
        listNode = head;
    }

    public int getRandom() {
        int res = listNode.val;

        ListNode cur = listNode;
        int i = 1;

        while (cur != null) {
            if ((int) (Math.random() * i) == i - 1) {
                res = cur.val;
            }
            cur = cur.next;
            i++;
        }

        return res;
    }
}