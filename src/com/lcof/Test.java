package com.lcof;

import com.Util.ListNode;

public class Test {

    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(-1);

        while (head != null) {
            ListNode next = p.next;
            p.next = head;
            head = head.next;
            p.next.next = next;
        }

        return p.next;
    }
}