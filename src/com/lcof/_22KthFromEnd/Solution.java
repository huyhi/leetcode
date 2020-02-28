package com.lcof._22KthFromEnd;

import com.Util.ListNode;

public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
