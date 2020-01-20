package com.leetcode._350intersectionOfTwoArrsII;

import java.util.*;

public class Solution {

    // 解法1 HashMap法
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for (int item : nums1) {
            if (m.containsKey(item)) {
                m.put(item, m.get(item) + 1);
            } else {
                m.put(item, 1);
            }
        }

        for (int item : nums2) {
            if (m.containsKey(item)) {
                int value = m.get(item);
                if (value >= 1) {
                    resList.add(item);
                }
                m.put(item, value - 1);
            }
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = resList.get(i);
        }

        return res;
    }

    // 方法二 排序法 将两个数组排序，就转变成了求两个有序数组交集
    public static int[] intersect_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> resList = new ArrayList<>();

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                resList.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resArr.length; ++i) {
            resArr[i] = resList.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {

    }
}
