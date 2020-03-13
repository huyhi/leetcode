package com.leetcode._1013_CanThreePartsEqualSum;

public class Solution {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int item : A) {
            sum += item;
        }
        if (sum % 3 != 0) {
            return false;
        }

        int len = A.length, target = sum / 3, i = 0, cur = 0;

        while (i < len) {
            cur += A[i++];
            if (cur == target) {
                break;
            }
        }
        if (cur != target) {
            return false;
        }

        int j = i;
        while (j + 1 < len) {
            cur += A[j++];
            if (cur == target * 2) {
                return true;
            }
        }

        return false;
    }
}
