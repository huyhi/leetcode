package cn.leetcode.medium;

import cn.leetcode.dsdefine.ListNode;

public class _92_reverse_linked_list_2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // assign leftNode & rightNode
        int i = 1;
        ListNode leftNode = head, rightNode = head;
        while (i <= right) {
            if (left == i) {
                leftNode = rightNode;
            }
            if (right == i) {
                break;
            }
            rightNode = rightNode.next;
            i++;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode leftNodePre = dummyHead;
        while (leftNodePre.next != leftNode) {
            leftNodePre = leftNodePre.next;
        }

        ListNode iNode = leftNode, iNodeNext;
        while (iNode != rightNode) {
            iNodeNext = iNode.next;
            iNode.next = rightNode.next;
            rightNode.next = iNode;
            iNode = iNodeNext;
        }
        leftNodePre.next = rightNode;

        return dummyHead.next;
    }
}
