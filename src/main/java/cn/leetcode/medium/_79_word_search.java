package cn.leetcode.medium;

public class _79_word_search {

    public boolean exist(char[][] board, String word) {
        int rowsNum = board.length;
        int colsNum = board[0].length;
        boolean[][] visited = new boolean[rowsNum][colsNum];

        for (int row = 0; row < rowsNum; row++) {
            for (int col = 0; col < colsNum; col++) {
                if (dfs(board, visited, word.toCharArray(), 0, row, col, rowsNum, colsNum)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean dfs(
            char[][] board, boolean[][] visited, char[] wordChars, int searchIndex, int row, int col, int rowsNum, int colsNum
    ) {
        if (searchIndex == wordChars.length) {
            return true;
        }
        if (row < 0 || row >= rowsNum) {
            return false;
        }
        if (col < 0 || col >= colsNum) {
            return false;
        }

        if (board[row][col] == wordChars[searchIndex] && !visited[row][col]) {
            visited[row][col] = true;
            boolean searchResult = dfs(board, visited, wordChars, searchIndex + 1, row + 1, col, rowsNum, colsNum) ||
                    dfs(board, visited, wordChars, searchIndex + 1, row, col + 1, rowsNum, colsNum) ||
                    dfs(board, visited, wordChars, searchIndex + 1, row - 1, col, rowsNum, colsNum) ||
                    dfs(board, visited, wordChars, searchIndex + 1, row, col - 1, rowsNum, colsNum);
            if (searchResult) {
                return true;
            }
            visited[row][col] = false;
        }

        return false;
    }
}
