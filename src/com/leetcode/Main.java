package com.leetcode;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int point = partition(nums, left, right);
        quickSort(nums, left, point + 1);
        quickSort(nums, point + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int k = right;

        for (int i = left; i < right; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, k);
                k++;
            }
        }

        swap(nums, k, right);

        return k;
    }

    public static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
