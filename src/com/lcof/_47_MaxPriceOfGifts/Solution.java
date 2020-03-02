package com.lcof._47_MaxPriceOfGifts;


public class Solution {
    public int maxValue(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length, cols = grid[0].length;

        for (int row = 1; row < rows; ++row) {
            grid[row][0] += grid[row - 1][0];
        }
        for (int col = 1; col < cols; ++col) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int row = 1; row < rows; ++row) {
            for (int col = 1; col < cols; ++col) {
                grid[row][col] += Math.max(grid[row - 1][col], grid[row][col - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
