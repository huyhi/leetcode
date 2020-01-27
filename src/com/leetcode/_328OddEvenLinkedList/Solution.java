package com.leetcode._328OddEvenLinkedList;

import com.leetcode.Util.ListNode;

import java.util.LinkedList;

public class Solution {

    public ListNode oddEvenListNode (ListNode head) {
        ListNode odd = new ListNode(-1), even = new ListNode(-1),
                oddP =  odd, evenP = even;
        int i = 1;

        while (head != null) {
            if (i % 2 != 0) {   // 如果为奇数
                oddP.next = head;
                oddP = oddP.next;
            } else {
                evenP.next = head;
                evenP = evenP.next;
            }
            head = head.next;
            i++;
        }

        evenP.next = null;  // 这一行别忘了
        oddP.next = even.next;
        return odd.next;
    }
}
