package cn.leetcode.medium;

import cn.leetcode.DebugTool;

public class _31_next_permutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return;
        }

        // from right to left, find the first descending item
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        // all item ascending case, just return the reverse of the array
        if (i == -1) {
            reverse(nums);
            return;
        }

        // find the min value greater than the nums[i]
        int idxForSwap = i + 1;
        int k = idxForSwap + 1;
        while (k < len) {
            if (nums[k] > nums[i] && nums[k] < nums[idxForSwap]) {
                idxForSwap = k;
            }
            k++;
        }

        swap(nums, idxForSwap, i);

        // sort nums[] from index: i to the end
        sort(nums, i + 1);
    }

    public void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < nums.length / 2) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public void swap(int[] nums, int a, int b) {
        int swap = nums[a];
        nums[a] = nums[b];
        nums[b] = swap;
    }


    public void sort(int[] nums, int fromIdx) {
        for (int i = fromIdx; i < nums.length; i++) {
            int minIdx = i;
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] < nums[minIdx]) {
                    minIdx = k;
                }
            }
            swap(nums, i, minIdx);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        new _31_next_permutation().nextPermutation(arr);

        DebugTool.printArr(arr);
    }
}
