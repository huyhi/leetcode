package com.leetcode._215kthLargestEleInnArray;


class SolutionHeapSort {
    int[] heap;
    int size;

    public int findKthLargest(int[] nums, int k) {
        this.heap = new int[k + 1];
        this.size = k;

        for (int i = 0; i < k; ++i) {
            this.heap[i + 1] = nums[i];
        }
        for (int i = size / 2; i >= 1; --i) {
            heapily(i);
        }
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > heap[1]) {
                heap[1] = nums[i];
                heapily(1);
            }
        }

        return heap[k];
    }

    public void heapily(int start) {
        while (start <= size / 2) {
            int minIndex;
            if (start * 2 == size) {
                minIndex = start * 2;
            } else {
                minIndex = heap[start * 2] < heap[start * 2 + 1] ? start * 2 : start * 2 + 1;
            }
            if (heap[minIndex] > heap[start]) {
                break;
            } else {
                swap(start, minIndex);
                start = minIndex;
            }
        }
    }

    public void swap(int idx1, int idx2) {
        int tmp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = tmp;
    }

    public static void main(String[] args) {
        new SolutionHeapSort().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}
