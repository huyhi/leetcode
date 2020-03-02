package com.leetcode._206ReverseLinkedList;

import com.Util.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode tmp = null,
                res = null;

        while (head != null) {
            res = new ListNode(head.val);
            res.next = tmp;
            tmp = res;

            head = head.next;
        }

        return res;
    }


    public ListNode reverseListO1(ListNode head) {
        ListNode res = null,
                tmp = null;

        while (head != null) {
            tmp = head;
            head = head.next;
            tmp.next = res;
            res = tmp;
        }

        return res;
    }

    public ListNode reverseList02(ListNode head) {
        ListNode p = new ListNode(-1);

        while (head != null) {
            ListNode next = p.next;
            p.next = head;
            head = head.next;
            p.next.next = next;
        }

        return p.next;
    }

    // 递归做法
    public ListNode reverseList03(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverseList03(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }
}
