package com.leetcode._821ShortestDisToAChr;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        List<Integer> idxOfC = new LinkedList<>();
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == C) {
                idxOfC.add(i);
            }
        }
        idxOfC.add(Integer.MAX_VALUE);

        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < S.length(); ++i) {
            for (int idx : idxOfC) {
                int cur = Math.abs(i - idx);
                if (cur > distance) {
                    res[i] = distance;
                    break;
                } else {
                    distance = cur;
                }
            }
            distance = Integer.MAX_VALUE;
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';

        int[] res = new Solution().shortestToChar(S, C);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
