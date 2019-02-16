package com.company._2AddTwoNumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pointer = res;
        int nextBit = 0;
        int x, y, curr;
        while (l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;

            curr = x + y;
            pointer.next = new ListNode((curr + nextBit) % 10);
            nextBit = (curr + nextBit) / 10;

            pointer = pointer.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if (nextBit != 0) {
            pointer.next = new ListNode(nextBit);
        }

        return res.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode (int val) {
        this.val = val;
    }
}
