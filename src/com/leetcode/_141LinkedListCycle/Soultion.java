package com.leetcode._141LinkedListCycle;

import com.Util.ListNode;

import java.util.HashSet;

public class Soultion {
    //解法1 快慢指针，优点空间复杂度O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        //注意这个条件的顺序
        while (fast != null && fast.next != null) {
            fast = fast.next;

            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next;
        }
        return false;
    }

    //解法2 hashSet
    public boolean hasCycHashMap(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            } else {
                hashSet.add(head);
            }

            head = head.next;
        }
        return false;
    }
}
