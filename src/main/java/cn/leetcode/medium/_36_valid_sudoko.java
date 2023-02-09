package cn.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class _36_valid_sudoko {

    public static final int LEN = 9;

    public boolean isValidSudoku(char[][] board) {
        // for each row
        for (int row = 0; row < LEN; row++) {
            if (!valid(board[row])) {
                return false;
            }
        }

        // for each col
        for (int col = 0; col < LEN; col++) {
            char[] colArr = new char[LEN];
            for (int i = 0; i < LEN; i++) {
                colArr[i] = board[i][col];
            }
            if (!valid(colArr)) {
                return false;
            }
        }

        // for each 3 * 3 sub-box
        int[] horizontal = new int[]{0, 3, 6};
        int[] vertical = new int[]{0, 3, 6};

        for (int x : horizontal) {
            for (int y : vertical) {
                char[] arrForCheck = new char[LEN];

                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        arrForCheck[a * 3 + b] = board[x + a][y + b];
                    }
                }

                if (!valid(arrForCheck)) {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean valid(char... arr) {
        Set<Character> set = new HashSet<>();

        for (char i : arr) {
            if (i == '.') {
                continue;
            }

            if (set.contains(i)) {
                return false;
            } else {
                set.add(i);
            }
        }

        return true;
    }
}
