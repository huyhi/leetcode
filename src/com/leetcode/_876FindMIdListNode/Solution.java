package com.leetcode._876FindMIdListNode;

import com.Util.ListNode;

public class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (true) {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return slow;
            }
        }
    }
}
