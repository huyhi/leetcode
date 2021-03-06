//package com.leetcode._34FirstAndLastPInSortedArr;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CQueue {
//
//    public static int[] searchRange(int[] arr, int target) {
//        int len = arr.length,
//                high = len - 1,
//                low = 0,
//                mid = 0;
//
//        int left = 0,
//                right = 0;
//
//        //先随便找一个target
//        while (low <= high) {
//            mid = (low + high) / 2;
//            if (arr[mid] < target) {
//                low = mid + 1;
//            } else if (arr[mid] > target) {
//                high = mid - 1;
//            } else {
//                break;
//            }
//        }
//
//        if (target != arr[mid]) {
//            return new int[0];
//        }

//        //find left
//        low = 0;
//        high = mid;
//
//        while (low <= high) {
//            int newMid = (low + high) / 2;
//            if (arr[newMid] == target) {
//                high = newMid - 1;
//            } else {
//                low = newMid + 1;
//            }
//        }
//        left = low;

//        //find right
//        low = mid;
//        high = arr.length - 1;
//
//        while (low <= high) {
//            int newMid = (low + high) / 2;
//            if (arr[newMid] == target) {
//                low = newMid + 1;
//            } else {
//                high = newMid - 1;
//            }
//        }
//        right = high;
//
//        int[] res = new int[right - left + 1];
//        for (int i = 0; i < res.length; ++i) {
//            res[i] = left++;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 4, 4, 4, 7};
//
//        int[] res = searchRange(arr, 4);
//
//        for (int i : res) {
//            System.out.println(i);
//        }
//    }
//}
