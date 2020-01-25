package com.sort;

public class QuickSort {

    public static void quickSort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
    }

    public static int partition(int[] a, int p, int r) {
        // 分区点，默认选择最右侧这个元素作为分区点，吧数组分为 比分区点小 分区点 大于分区点三部分
        int pivot = a[r];
        int i = p;

        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);

        return i;
    }

    public static void swap(int a[], int p, int q) {
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 8, 2, 4, 6, 3, 2, 1, 213, 5, 567};
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
