package com.company._445AddTwoNumbersII;

import com.company.Util.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> resStack = new LinkedList<>();

        addToStack(stack1, l1);
        addToStack(stack2, l2);

        int nextDec = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = stack1.isEmpty() ? 0 : stack1.removeLast();
            int y = stack2.isEmpty() ? 0 : stack2.removeLast();
            int sum = x + y + nextDec;
            resStack.addFirst(sum % 10);
            nextDec = sum / 10;
        }

        if (nextDec != 0) {
            resStack.addFirst(nextDec);
        }

        ListNode res = new ListNode(-1);
        ListNode p = res;
        while (!resStack.isEmpty()) {
            p.next = new ListNode(resStack.removeFirst());
            p = p.next;
        }

        return res.next;
    }

    public void addToStack(List<Integer> stack, ListNode l) {
        while (l != null) {
            stack.add(l.val);
            l = l.next;
        }
    }
}
