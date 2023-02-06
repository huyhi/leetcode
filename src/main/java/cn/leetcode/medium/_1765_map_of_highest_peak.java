package cn.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class _1765_map_of_highest_peak {

    public int[][] highestPeak(int[][] isWater) {
        int rows = isWater.length;
        int cols = isWater[0].length;

        // init res array
        int[][] res = new int[rows][cols];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isWater[r][c] == 1) {
                    res[r][c] = 0;
                    queue.add(new int[]{r, c});
                } else {
                    res[r][c] = -1;
                }
            }
        }
        // bfs
        int level = 1;
        while (!queue.isEmpty()) {
            List<int[]> tmpList = new ArrayList<>(queue);
            queue.clear();

            for (int[] i : tmpList) {
                int r = i[0], c = i[1];
                if (r + 1 < rows && res[r + 1][c] == -1) {
                    res[r + 1][c] = level;
                    queue.add(new int[]{r + 1, c});
                }
                if (c + 1 < cols && res[r][c + 1] == -1) {
                    res[r][c + 1] = level;
                    queue.add(new int[]{r, c + 1});
                }
                if (r - 1 >= 0 && res[r - 1][c] == -1) {
                    res[r - 1][c] = level;
                    queue.add(new int[]{r - 1, c});
                }
                if (c - 1 >= 0 && res[r][c - 1] == -1) {
                    res[r][c - 1] = level;
                    queue.add(new int[]{r, c - 1});
                }
            }
            level++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] isWater = new int[][]{{0, 1}, {0, 0}};
        new _1765_map_of_highest_peak().highestPeak(isWater);
    }
}
