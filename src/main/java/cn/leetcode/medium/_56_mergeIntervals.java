package cn.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class _56_mergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        

        return null;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 9, 10, 2};
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.printf("%d, ", i);
        }
    }
}
