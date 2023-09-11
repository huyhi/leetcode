package cn.leetcode;

public class DebugTool {

    public static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d, ", num);
        }
    }

    public static void print2DimArray(boolean[][] arr) {
        int cols = arr[0].length;

        for (boolean[] booleans : arr) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%s,", booleans[col]);
            }
            System.out.println();
        }
    }
}
