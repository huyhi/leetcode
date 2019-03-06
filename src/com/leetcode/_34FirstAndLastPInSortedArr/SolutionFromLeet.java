package com.leetcode._34FirstAndLastPInSortedArr;

class SolutionFromLeet {
    public static int[] selectRange(int[] arr, int target) {
        int low = 0, high = arr.length, mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                break;
            }
        }

        if (arr[mid] != target) {
            return new int[0];
        }

        //find left
        low = 0;
        high = mid;
        while (low <= high) {
            int newMid = (low + high) / 2;
            if (arr[newMid] == target) {
                high = newMid - 1;
            } else {
                low = newMid + 1;
            }
        }
        int left = low;

        //find right
        low = mid;
        high = arr.length;
        while (low <= high) {
            int newMid = (low + high) / 2;
            if (arr[newMid] == target) {
                low = newMid + 1;
            } else {
                high = newMid - 1;
            }
        }
        int right = high;

        int[] res = new int[right - left + 1];
        for (int i = 0; i < res.length; ++i) {
            res[i] = left++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 4, 4, 4, 7};
        int[] res = selectRange(arr, 4);

        for (int i : res) {
            System.out.println(i);
        }
    }
}

