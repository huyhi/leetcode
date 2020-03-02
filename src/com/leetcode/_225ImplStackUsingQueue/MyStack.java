package com.leetcode._225ImplStackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {
        Queue<Integer> p = q1.isEmpty() ? q2 : q1;
        p.add(x);
    }

    public int pop() {
        Queue<Integer> full = q1.isEmpty() ? q2 : q1;
        Queue<Integer> empty = q1.isEmpty() ? q1 : q2;

        while (full.size() > 1) {
            empty.add(full.poll());
        }

        return full.poll();
    }

    public int top() {
        Queue<Integer> full = q1.isEmpty() ? q2 : q1;
        Queue<Integer> empty = q1.isEmpty() ? q1 : q2;

        while (full.size() > 1) {
            empty.add(full.poll());
        }

        int res = full.peek();
        empty.add(full.poll());

        return res;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
