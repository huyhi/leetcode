package cn.leetcode.jzoffer;

import cn.leetcode.dsdefine.ListNode;

public class _18 {


    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode, p = head;

        while (p != null) {
            if (p.val != val) {
                p = p.next;
                prev = prev.next;
            } else {
                prev.next = p.next;
                p.next = null;
                break;
            }
        }
        return dummyNode.next;
    }
}
