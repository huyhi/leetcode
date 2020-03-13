package com.leetcode._703_KthLargest;

import static com.Util.Tools.printArray;

public class KthLargest {
    int size = 0, capacity;
    int[] heap;

    public KthLargest(int k, int[] nums) {
        this.capacity= k;
        this.heap = new int[k + 1];
        for (int item : nums) {
            printArray(heap);
            add(item);
        }
    }

    public void heapilyToTop(int start) {
        while (start > 1) {
            int parent = start / 2;
            if (heap[start] < heap[parent]) {
                swap(start, parent);
            }
            start = parent;
        }
    }

    public void heapilyToBottom(int start) {
        while (start <= capacity / 2) {
            int minIndex;
            if (start * 2 == capacity) {
                minIndex = start * 2;
            } else {
                minIndex = heap[start * 2 + 1] > heap[start * 2] ? start * 2 : start * 2 + 1;
            }
            if (heap[start] > heap[minIndex]) {
                swap(start, minIndex);
            }
            start = minIndex;
        }
    }

    public int add(int val) {
        if (size < capacity) {
            heap[++size] = val;
            heapilyToTop(size);
        } else {
            if (val > heap[1]) {
                heap[1] = val;
                heapilyToBottom(1);
            }
        }

        return heap[1];
    }

    public void swap(int idx1, int idx2) {
        int tmp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = tmp;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);

        printArray(kthLargest.heap);

        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
    }
}
