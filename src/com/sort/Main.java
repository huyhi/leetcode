package com.sort;

public class Main {
    public void mergeSort(int[] a, int p, int r) {
        if (p == r) {
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
            end = p;
        }

        while (start <= end) {
            tmp[i++] = a[start++];
        }

        for (int k = 0; k < tmp.length; ++k) {
            a[p + k] = tmp[k];
        }
    }
}
