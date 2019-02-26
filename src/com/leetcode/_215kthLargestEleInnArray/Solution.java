package com.leetcode._215kthLargestEleInnArray;

public class Solution {
    public int findKthLargest(int[] nums, int k) {

        return 1;
    }

    public void quickSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(A, p, r);
        quickSort(A, p, q - 1);
        quickSort(A, q + 1, r);
    }


    public int partition(int[] A, int p, int r) {
        int i = p, j, pivot = A[r];

        for (j = 0; j <= r - 1; ++j) {
            if (A[j] < pivot) {
                swap(A, i++, j);
            }
        }

        swap(A, i, j);

        return i;
    }

    public void swap(int[] A, int a, int b) {
        if (a == b) {
            return;
        }

        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
