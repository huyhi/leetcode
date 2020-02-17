package com.leetcode._695MaxAreaOfIsland;


// 递归形式的 DFS
public class Solution {
    private int rows, cols;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        this.rows = grid.length;
        this.cols = grid[0].length;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == 1) {
                    res = Math.max(res, dfs(grid, row, col));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        return 1 +
                dfs(grid, row - 1, col) +
                dfs(grid, row + 1, col) +
                dfs(grid, row, col + 1) +
                dfs(grid, row, col - 1);
    }
}
