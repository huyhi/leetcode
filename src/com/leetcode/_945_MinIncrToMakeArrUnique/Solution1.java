package com.leetcode._945_MinIncrToMakeArrUnique;

import java.util.Arrays;

public class Solution1 {

    // 排序法
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);
        int taken = 0, res = 0;
        int prev = A[0], t;

        for (int i = 1; i < A.length; ++i) {
            if (A[i] == prev) {
                taken++;
                res -= A[i];
            } else if (taken > 0 && A[i] - prev > 0) {
                int counter = A[i] - prev - 1;
                t = 1;
                while (counter > 0 && taken > 0) {
                    counter--;
                    taken--;
                    res += prev + t++;
                }
            }
            prev = A[i];
        }

        t = 1;
        while (taken > 0) {
            res += prev + t++;
            taken--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 0, 2};
        int res = new Solution1().minIncrementForUnique(A);
        System.out.println(res);
    }
}
