package com.lcof._25MergeSortedLinkedList;

import com.Util.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), p = res;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }

        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }

        return res.next;
    }
}
