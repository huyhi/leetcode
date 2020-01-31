package com.leetcode._200DaoYuShuLiang;

import java.util.LinkedList;
import java.util.Queue;

// 解法1 dfs
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int islandCounts = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    islandCounts++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }

        return islandCounts;
    }

    public void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (grid[r][c] == '1') {
            grid[r][c] = '0';
        } else {
            return;
        }

        if (r >= 1) {
            dfs(grid, r - 1, c, rows, cols);
        }
        if (c <= cols - 2) {
            dfs(grid, r, c + 1, rows, cols);
        }
        if (r <= rows - 2) {
            dfs(grid, r + 1, c, rows, cols);
        }
        if (c >= 1) {
            dfs(grid, r, c - 1, rows, cols);
        }
    }
}

// 解法二，借助队列进行bfs
class Solution2 {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rowsNum = grid.length, colsNum = grid[0].length, res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int r = 0; r < rowsNum; ++r) {
            for (int c = 0; c < colsNum; ++c) {
                if (grid[r][c] == '1') {
                    queue.add(r * colsNum + c);
                    res++;
                    while (!queue.isEmpty()) {
                        int tmp = queue.poll();
                        int rowIn = tmp / colsNum;
                        int colIn = tmp % colsNum;
                        if (grid[rowIn][colIn] == '0') {
                            continue;
                        }
                        grid[rowIn][colIn] = '0';
                        if (rowIn >= 1) {
//                            grid[rowIn - 1][colIn] = '0';
                            queue.add((rowIn - 1) * colsNum + colIn);
                        }
                        if (colIn <= colsNum - 2) {
//                            grid[rowIn][colIn + 1] = '0';
                            queue.add((rowIn) * colsNum + colIn + 1);
                        }
                        if (rowIn <= rowsNum - 2) {
//                            grid[rowIn + 1][colIn] = '0';
                            queue.add((rowIn + 1) * colsNum + colIn);
                        }
                        if (colIn >= 1) {
//                            grid[rowIn][colIn - 1] = '0';
                            queue.add(rowIn * colsNum + colIn - 1);
                        }
                    }
                }
            }
        }

        return res;
    }
}