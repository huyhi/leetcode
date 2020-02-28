package com.leetcode._92ReverseLinkedListii;

import com.Util.ListNode;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode res = head;
        ListNode midTop = null,
                midBottom = null,
                left = head,
                right = null,
                tmp = null;

        while (index <= n) {
            if (index == m - 1) {
                left = head;
            } else if (index == m) {
                midBottom = new ListNode(head.val);
                midTop = midBottom;
            } else if (index > m) {
                tmp = midTop;
                midTop = new ListNode(head.val);
                midTop.next = tmp;
            }

            if (index == n) {
                right = head.next;
            }

            head = head.next;
            index++;
        }

        left.next = midTop;
        midBottom.next = head;

        return res;
    }
}
