package com.sort;

public class MergeSort {

    private void mergeSort(int[] a, int p, int r) {
        if (r == p) {
            return;
        }

        int q = p + (r - p) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    private void merge(int[] a, int p, int q, int r) {
        int[] tmp = new int[r - p + 1];
        int i = 0;
        int m = p, n = q + 1;
        while (m <= q && n <= r) {
            tmp[i++] = a[m] < a[n] ? a[m++] : a[n++];
        }

        int start, end;
        if (m > q) {
            start = n;
            end = r;
        } else {
            start = m;
            end = q;
        }

        //将剩余的元素copy到tmp中
        while (start <= end) {
            tmp[i++] = a[start++];
        }

        //将tmp[] copy到原数组中
        for (i = 0; i < tmp.length; ++i) {
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 2, 6, 9, 1, 0, 6, 1, 8, 2, 9};

        new MergeSort().mergeSort(arr, 0, arr.length - 1);

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
