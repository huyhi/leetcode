package com.leetcode._234PalindromeLinkedList;

import com.leetcode.Util.ListNode;

public class Solution {

    /**
     * 快慢指针找到链表中点
     * 反转后面的链表
     * 对比两部分是否相等
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head,
                fast = head,
                tmp = null,
                mid = null;

        //注意这个条件的顺序，大坑，必须先fast != null 然后 fast.next != null，逻辑短路的大坑
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow作为后半部分的头结点
        while (slow != null) {
            tmp = slow;
            slow = slow.next;
            tmp.next = mid;
            mid = tmp;
        }

        while (mid != null) {
            if (mid.val != head.val) {
                return false;
            } else {
                mid = mid.next;
                head = head.next;
            }
        }

        return true;
    }
}
