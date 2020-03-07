package com.leetcode._807_IncrKeepCitySkyline;


import static com.Util.Tools.printArray;

public class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length, res = 0;
        if (rows == 0) {
            return res;
        }
        int cols = grid[0].length;
        int[] xAxisSkyline = new int[cols];
        int[] yAxisSkyline = new int[rows];

        for (int row = 0; row < rows; ++row) {
            int max = grid[row][0];
            for (int col = 1; col < cols; ++col) {
                max = Math.max(max, grid[row][col]);
            }
            xAxisSkyline[row] = max;
        }

        for (int col = 0; col < cols; ++col) {
            int max = grid[0][col];
            for (int row = 1; row < rows; ++row) {
                max = Math.max(max, grid[row][col]);
            }
            yAxisSkyline[col] = max;
        }

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                res += Math.min(xAxisSkyline[col], yAxisSkyline[row]) - grid[row][col];
            }
        }

        return res;
    }
}
