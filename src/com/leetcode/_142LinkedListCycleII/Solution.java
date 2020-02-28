package com.leetcode._142LinkedListCycleII;

import com.Util.ListNode;

import java.util.HashSet;

public class Solution {

    //解法1 Hash法，空间复杂的O(N)
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (hashSet.contains(head)) {
                return head;
            } else {
                hashSet.add(head);
                head = head.next;
            }
        }

        return null;
    }

    /**
     * 看了好久才看懂的方法。。。给跪了Orz
     * 解法2
     * 1，先判断是否有环
     * 2，如果有环，再判断具体的交点
     */
    public ListNode foo(ListNode head) {
        ListNode slow = head, fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        /**
         * 假设到入环点A长度是a
         * 快慢指针相遇的时候慢指针又从入环点走了长度b, 改点记为B。
         * 所以相交时，慢指针走了a+b，快指针因为速度是二倍就走了2(a+b)
         * 所以相交的时候慢指针再走a+b就还能回到相同的位置，再往回走b会走到A点，所以往前走a也会回到A点。
         */
        if (hasCycle) {
            ListNode q = head;
            while (q != slow) {
                slow = slow.next;
                q = q.next;
            }
            return q;
        } else {
            return null;
        }
    }
}
