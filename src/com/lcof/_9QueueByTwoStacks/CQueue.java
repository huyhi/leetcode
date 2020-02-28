package com.lcof._9QueueByTwoStacks;


import java.util.Stack;

// 两个栈实现队列
public class CQueue {
    Stack<Integer> s1, s2;

    public CQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        if (s2.isEmpty()) {
            return -1;
        } else {
            return s2.pop();
        }
    }
}
