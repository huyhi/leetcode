package com.sort;


/**
 * Heap 完全二叉树表示，子元素小(大)于等于父元素。
 * 完全二叉树的特性适合用一个数组来存储，
 * 左子元素index=2n，右子元素index=2n+1，父节点
 */
public class HeapSort {

}


class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];  //index为0的元素不存东西
        n = capacity;
        count = 0;
    }

    public void buildHeap() {
        //从第一个非叶子节点开始堆自下而上堆化
        for (int i = n / 2; i >= 1; --i) {
            heapify(n, i);
        }
    }

    public void sort() {
        /**
         * 堆排序步骤
         * 1.建堆，可以自上而下或自下而上, 这里选择自下而上
         * 2.排序，把堆顶移到尾部，对剩下的元素堆化，不断执行这个步骤
         */
        buildHeap();
        int k = n;
        while (k > 1) {
            swap(1, k);
            --k;
            heapify(k, 1);
        }
    }

    // 自下而上堆化
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        a[++count] = data;
        int i = count;

        //自下向上堆化
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }

        a[1] = a[count--];
        heapify(count, 1);
    }

    // 自上而下堆化 TODO 改进具体的逻辑
    private void heapify(int n, int i) {
        while (true) {
            int maxPos = i;

            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == n) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }

    private void swap(int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}