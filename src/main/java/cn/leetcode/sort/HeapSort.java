package cn.leetcode.sort;

public class HeapSort {

    public void heapSort(int[] a, int n) {
        int i, tmp;

        // build a max heap
        for (i = n / 2 - 1; i >= 0; i--) {
            maxHeapDown(a, i, n - 1);
        }

        for (i = n - 1; i > 0; i--) {
            tmp = a[0];     // a[0] max value of the heap
            a[0] = a[i];
            a[i] = tmp;

            maxHeapDown(a, 0, i - 1);
        }
    }

    // max heapify
    public void maxHeapDown(int[] a, int start, int end) {
        int c = start;
        int left = 2 * c + 1;
        int temp = a[c];

        for (; left <= end; c = left, left = 2 * left + 1) {
            // left -> left child, left + 1 -> right child
            if (left < end && a[left] < a[left + 1]) {
                // find the greater value (right node)
                left++;
            }
            if (temp >= a[left]) {
                break;
            } else {
                a[c] = a[left];
                a[left] = temp;
            }
        }
    }
}
