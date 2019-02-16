package com.company._215kthLargestEleInnArray;

public class QuickSort {
    public void quickSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(A, p, r);
        quickSort(A, p, q - 1);
        quickSort(A, q + 1, r);
    }

    public int partition(int[] A, int p, int r) {
        int i = p, j;
        int pivot = A[r];

        for (j = p; j <= r - 1; ++j) {
            if (A[j] < pivot) {
                swap(A, i, j);
                i++;
            }
        }

        swap(A, i, j);

        return i;
    }

    public void swap(int[] A, int a, int b) {
        if (a == b) {
            return;
        }

        int tmp = A[b];
        A[b] = A[a];
        A[a] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {-1, 6, 7, 4, 9, 12, -3, -7, 7};

        QuickSort qc = new QuickSort();
        qc.quickSort(arr, 0, arr.length - 1);

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
