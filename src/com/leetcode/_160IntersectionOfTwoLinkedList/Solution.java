package com.leetcode._160IntersectionOfTwoLinkedList;

import com.Util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    //解法1 散列表法 缺点：空间复杂度O(N)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }

        return null;
    }

    //解法2 leetcode评论区上看到的解法，很强，想了好久才看懂
    public ListNode foo(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
