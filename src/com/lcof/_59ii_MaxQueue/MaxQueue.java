package com.lcof._59ii_MaxQueue;

import java.util.LinkedList;

public class MaxQueue {
    ListNode head, tail;
    LinkedList<Integer> minQueue = new LinkedList<>();
    int count = 0;

    public MaxQueue() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.pre = head;
    }

    public int max_value() {
        return minQueue.isEmpty() ? -1 : minQueue.peekFirst();
    }

    public void push_back(int value) {
        ListNode pre = tail.pre,
                insert = new ListNode(value);

        this.count++;
        pre.next = insert;
        insert.pre = pre;
        insert.next = tail;
        tail.pre = insert;

        while (!minQueue.isEmpty()) {
            if (value > minQueue.peekLast()) {
                minQueue.pollLast();
            } else {
                break;
            }
        }
        minQueue.addLast(value);
    }

    public int pop_front() {
        if (this.isEmpty()) {
            return -1;
        }

        ListNode popped = head.next,
                next = popped.next;

        this.count--;
        int poppedVal = popped.val;
        head.next = next;
        next.pre = head;

        if (poppedVal == minQueue.peekFirst()) {
            minQueue.pollFirst();
        }

        return poppedVal;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}

class ListNode {
    int val;
    ListNode next, pre;
    public ListNode(int val) {
        this.val = val;
    }
}