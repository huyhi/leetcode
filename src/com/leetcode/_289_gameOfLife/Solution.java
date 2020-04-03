package com.leetcode._289_gameOfLife;

public class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length, cols = board[0].length;
        int[][] newBoard = new int[rows][cols];

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int aliveCells = countAround(board, row, col);
                if (board[row][col] == 1) {
                    if (aliveCells == 2 || aliveCells == 3) {
                        newBoard[row][col] = 1;
                    }
                }
                if (board[row][col] == 0 && aliveCells == 3) {
                    newBoard[row][col] = 1;
                }
            }
        }
        // copy to board
        for (int row = 0; row < rows; ++row) {
            System.arraycopy(newBoard[row], 0, board[row], 0, cols);
        }
    }

    public int countAround(int[][] board, int row, int col) {
        int res = 0;
        int rows = board.length;
        int cols = board[0].length;
        if (row + 1 < rows) {
            res += board[row + 1][col] == 1 ? 1 : 0;
            res += col - 1 >= 0 && board[row + 1][col - 1] == 1 ? 1 : 0;
            res += col + 1 < cols && board[row + 1][col + 1] == 1 ? 1 : 0;
        }
        if (row - 1 >= 0) {
            res += board[row - 1][col] == 1 ? 1 : 0;
            res += col - 1 >= 0 && board[row - 1][col - 1] == 1 ? 1 : 0;
            res += col + 1 < cols && board[row - 1][col + 1] == 1 ? 1 : 0;
        }
        res += col - 1 >= 0 && board[row][col - 1] == 1 ? 1 : 0;
        res += col + 1 < cols && board[row][col + 1] == 1 ? 1 : 0;

        return res;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        Solution s = new Solution();
        s.gameOfLife(board);
    }
}
