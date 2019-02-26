package com.leetcode._21mergeTwoSortedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Soulution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode p = null;
        if (l1.val > l2.val) {
            p = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            p = new ListNode(l1.val);
            l1 = l1.next;
        }

        ListNode res = p;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}