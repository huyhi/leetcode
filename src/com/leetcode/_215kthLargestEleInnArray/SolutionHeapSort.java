package com.leetcode._215kthLargestEleInnArray;



public class SolutionHeapSort {

    private int[] heap;
    private int heapSize;

    public int findKthLargest(int[] nums, int k) {
        this.heap = new int[k + 1];
        this.heapSize = k;
        buildHeap(nums);
        for (int i = k; i < nums.length; ++i) {
            if (this.heap[1] < nums[i]) {
                this.heap[1] = nums[i];
                heapily();
            }
        }

        return this.heap[1];
    }

    private void buildHeap(int[] nums) {
        for (int i = 1; i <= this.heapSize; ++i) {
            this.heap[i] = nums[i - 1];
        }
        heapily();
    }

    private void heapily() {
        for (int i = this.heapSize / 2; i >= 1; --i) {
            int minIndex;
            if (i * 2 + 1 > this.heapSize) {
                minIndex = i * 2;
            } else {
                minIndex = this.heap[i * 2] < this.heap[i * 2 + 1] ? i * 2 : i * 2 + 1;
            }
            // 如果根比子节点大，swap，构建小顶堆
            if (this.heap[i] > this.heap[minIndex]) {
                swap(i, minIndex);
            }
        }
    }

    private void swap(int a, int b) {
        int tmp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(new SolutionHeapSort().findKthLargest(a, 2));
    }
}


