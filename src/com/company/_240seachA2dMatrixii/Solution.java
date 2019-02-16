package com.company._240seachA2dMatrixii;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

//        return search(matrix, target, row, col);
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    public boolean search(int[][] matrix, int target, int row, int col) {
        if (row == matrix.length || col == -1) {
            return false;
        }
        if (matrix[row][col] == target) {
            return true;
        }

        if (matrix[row][col] > target) {
            return search(matrix, target, row, col - 1);
        } else {
            return search(matrix, target, row + 1, col);
        }
    }

}
