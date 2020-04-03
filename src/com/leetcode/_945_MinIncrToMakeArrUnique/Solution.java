package com.leetcode._945_MinIncrToMakeArrUnique;

public class Solution {

    // leetcode 官方解法1
    // 题目 0 <= A[i] < 40000, 在最坏情况下，数组 A 中有 40000 个 40000
    // 需要设置 80000 长度的数组
    public int minIncrementForUnique(int[] A) {
        int[] m = new int[80000];
        for (int item : A) {
            m[item]++;
        }
        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (m[x] >= 2) {
                // taken 需要 move 的个数
                taken += m[x] - 1;
                // 提前减
                ans -= x * (m[x] - 1);
            }
            else if (taken > 0 && m[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }
}
