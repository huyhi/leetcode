package cn.leetcode.medium;

import java.util.*;

public class _347_topK_frequent_elements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }

        Map.Entry<Integer, Integer>[] heap = new Map.Entry[countMap.size() + 1];
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        // 构造大顶堆，先堆化, 使用下沉堆化法
        int heapSize = countMap.size();
        for (int i = 1; i <= heapSize; i++) {
            heap[i] = entryList.get(i - 1);
        }
        for (int i = heapSize / 2; i > 0; i--) {
            if (heap[i].getValue() < heap[i * 2].getValue()) {
                swap(heap, i, i * 2);
            }
            if (i * 2 + 1 <= heapSize && heap[i].getValue() < heap[i * 2 + 1].getValue()) {
                swap(heap, i, i * 2 + 1);
            }
        }
        List<Integer> res = new ArrayList<>(k);
        // 再从堆里面弹出元素
        for (int i = 1; i <= k; i++) {
            res.add(heap[1].getKey());
            heap[1] = heap[heapSize--];
            int p = 1;
            while (p * 2 <= heapSize) {
                if (heap[p].getValue() < heap[p * 2].getValue()) {
                    swap(heap, p, p * 2);
                }
                if (p * 2 + 1 <= heapSize && heap[p].getValue() < heap[p * 2 + 1].getValue()) {
                    swap(heap, p, p * 2 + 1);
                }
                p++;
            }

        }
        return res.stream().mapToInt(i -> i).toArray();
    }


    private void swap(Object[] arr, int a, int b) {
        Object tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
