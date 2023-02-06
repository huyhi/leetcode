package cn.leetcode.medium;

import cn.leetcode.dsdefine.ListNode;

public class _82_remove_duplicates_from_sorted_list_ii {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead, p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                ListNode windowRight = p.next;
                while (windowRight.next != null && windowRight.next.val == p.val) {
                    windowRight = windowRight.next;
                }
                pre.next = windowRight.next;
                p = pre.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }

        return dummyHead.next;
    }
}
