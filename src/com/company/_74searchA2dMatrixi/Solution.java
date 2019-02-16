package com.company._74searchA2dMatrixi;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        for (int[] line : matrix) {
            if (line[col] < target) {
                continue;
            } else {
                return find(line, target);
            }
        }

        return false;
    }

    public boolean find(int[] arr, int target) {
        for (int i = arr.length - 1; i >= 0; --i) {
            if (arr[i] < target) {
                return false;
            } else if (target == arr[i]) {
                return true;
            }
        }

        return false;
    }
}
