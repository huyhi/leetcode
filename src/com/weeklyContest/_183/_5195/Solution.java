package com.weeklyContest._183._5195;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// TODO
public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Letter> queue = new PriorityQueue<>((o1, o2) -> o1.nums - o2.nums);
        int counter = 0;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            Letter head = queue.poll();
            if (head.nums > 0 && counter < 2) {
                sb.append(head.c);
                head.nums -= 1;
                queue.offer(head);
                if (head.c == sb.charAt(sb.length() - 1)) {
                    counter++;
                } else {
                    counter = 1;
                }
            } else {
                continue;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

    }

}

class Letter {
    char c;
    int nums;

    public Letter(char c, int nums) {
        this.c = c;
        this.nums = nums;
    }
}