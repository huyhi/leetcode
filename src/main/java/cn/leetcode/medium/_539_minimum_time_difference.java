package cn.leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class _539_minimum_time_difference {

    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int minimumDifference = 720;
        int[] timePointsArr = new int[len];

        for (int i = 0; i < len; i++) {
            timePointsArr[i] = time2Int(timePoints.get(i));
        }

        quickSort(timePointsArr, 0, len - 1);
        for (int i = 0; i < len; i++) {
            int a = timePointsArr[i];
            int b = i + 1 == len ? timePointsArr[0] : timePointsArr[i + 1];
            int difference = Math.abs(a - b);
            difference = difference > 720 ? 1440 - difference : difference;
            minimumDifference = Math.min(difference, minimumDifference);
        }

        return minimumDifference;
    }


    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }


    public int partition(int[] arr, int left, int right) {
        int pNum = arr[right];
        int p = left;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pNum) {
                int tmp = arr[i];
                arr[i] = arr[p];
                arr[p] = tmp;
                p++;
            }
        }
        int tmp = arr[p];
        arr[p] = arr[right];
        arr[right] = tmp;
        return p;
    }


    public int time2Int(String time) {
        String[] splited = time.split(":");
        return Integer.parseInt(splited[1]) + 60 * Integer.parseInt(splited[0]);
    }


    public static void main(String[] args) {
        _539_minimum_time_difference obj = new _539_minimum_time_difference();

        List<String> l = Arrays.asList("17:41","22:06","20:59","17:37","04:14");
        obj.findMinDifference(l);
    }
}
