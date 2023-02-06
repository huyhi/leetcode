package cn.leetcode.easy;

import cn.leetcode.dsdefine.ListNode;

public class _83_remove_duplicates_from_sorted_list {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p = head, pNext = p.next;

        while (pNext != null) {
            if (pNext.val == p.val) {
                p.next = pNext.next;
                pNext = p.next;
            } else {
                p = p.next;
                pNext = pNext.next;
            }
        }
        return head;
    }
}
