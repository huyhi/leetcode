package com.lcof._24RevLinkList;

import com.Util.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(-1),
                resNext;

        while (head != null) {
            resNext = res.next;
            res.next = head;
            head = head.next;
            res.next.next = resNext;
        }

        return res;
    }
}
