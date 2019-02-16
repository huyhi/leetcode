package com.company._206ReverseLinkedList;

import com.company.Util.ListNode;

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
}
