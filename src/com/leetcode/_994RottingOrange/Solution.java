package com.leetcode._994RottingOrange;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (rows == 0 || cols == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0, res = 0;
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == 1) {
                    freshCount++;
                }
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        while (freshCount != 0) {
            int queueSize = queue.size();
            int freshCountPre = freshCount;
            while (queueSize-- > 0) {
                int[] polled = queue.poll();
                int r = polled[0], c = polled[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.add(new int[]{r - 1, c});
                    freshCount--;
                }
                if (r + 1 < rows && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                    freshCount--;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                    freshCount--;
                }
                if (c + 1 < cols && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    queue.add(new int[]{r, c + 1});
                    freshCount--;
                }
            }
            if (freshCount == freshCountPre) {
                return -1;
            } else {
                res++;
            }
        }

        return res;
    }
}
