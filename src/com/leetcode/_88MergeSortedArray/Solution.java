package com.leetcode._88MergeSortedArray;

public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1;
        int i = m + n - 1;

        while (p >= 0 && q >= 0) {
            if (nums1[p] < nums2[q]) {
                nums1[i--] = nums2[q--];
            } else {
                nums1[i--] = nums1[p--];
            }
        }

        while (q >= 0) {
            nums1[q] = nums2[q--];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {2, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;

        merge(nums1, m, nums2, n);

        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
