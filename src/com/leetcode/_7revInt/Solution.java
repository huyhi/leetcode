package com.leetcode._7revInt;

public class Solution {

    // Integer.MAX_VALUE % 10 = 7
    // Integer.MIN_VALUE % 10 = 8
    public static int reverseInteger(int nums) {
        int res = 0, pop;

        while (nums != 0) {
            pop = nums % 10;
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && pop > 7)) {
                return -1;
            }
            if (Integer.MIN_VALUE / 10 > res || (Integer.MIN_VALUE / 10 == res && pop > 8)) {
                return -1;
            }
            res = res * 10 + pop;
            nums = nums / 10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-123));
    }
}
