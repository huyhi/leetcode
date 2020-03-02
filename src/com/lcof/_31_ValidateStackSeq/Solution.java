package com.lcof._31_ValidateStackSeq;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0, k = 0;

        while (i < pushed.length) {
            if (!stack.isEmpty() && popped[k] == stack.peek()) {
                stack.pop();
                k++;
            } else {
                stack.push(pushed[i++]);
            }
        }



        while (!stack.isEmpty()) {
            if (stack.pop() != popped[k++]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};

        new Solution().validateStackSequences(pushed, popped);
    }
}
