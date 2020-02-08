package com.leetcode._148SortLinkedList;

// 排序一个单链表，使用归并排序的思想。
import com.leetcode.Util.ListNode;

import java.util.LinkedList;


public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        return merge(mergeSort(head), mergeSort(next));
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode res = new ListNode(-1), p = res;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }

        if (h1 != null) {
            p.next = h1;
        } else {
            p.next = h2;
        }

        return res.next;
    }

    // 快慢指针法找到链表中点
    public ListNode findMid(ListNode h) {
        ListNode slow = h, fast = h;

        while (fast != null) {
            if (fast.next == null || fast.next.next == null) {
                return slow;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }

        return null;
    }
}
