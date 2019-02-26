package com.leetcode._88MergeSortedArray;

public class MergeSort {

    public void mergeSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = p + (r - p) / 2;

        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);

        merge(A, p, q, r);
    }

    public void merge(int[] A, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int k = p, j = q + 1;
        int i = 0;

        while (k <= q && j <= r) {
            if (A[k] < A[j]) {
                tmp[i++] = A[k++];
            } else {
                tmp[i++] = A[j++];
            }
        }

        int start, end;
        if (k <= q) {
            start = k;
            end = q;
        } else {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[i++] = A[start++];
        }

        i = 0;
        for (int d = p; d <= r; ++d, ++i) {
            A[d] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {-1, 6, 7, 4, 9, 12, -3, -7, 7};

        MergeSort mc = new MergeSort();
        mc.mergeSort(arr, 0, arr.length - 1);

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
