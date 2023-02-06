package cn.leetcode.medium;

public class _8_atoi {

    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int result = 0;
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int charsLength = chars.length;
        char firstChar = chars[0];
        // check valid
        if (firstChar < '0' || firstChar > '9') {
            if (firstChar != '-' && firstChar != '+') {
                return 0;
            }
        }

        int i = 0;
        // 跳过第一个符号
        if (firstChar == '-' || firstChar == '+') {
            i++;
        }
        int isPositiveFlag = firstChar == '-' ? -1 : 1;

        for (; i < charsLength; i++) {
            char currentChar = chars[i];
            if (currentChar < '0' || currentChar > '9') {
                break;
            }

            if (isPositiveFlag > 0) {
                if ((max - char2Int(currentChar)) / 10 < result) {
                    return max;
                }
            } else {
                if ((min + char2Int(currentChar)) / 10 > result) {
                    return min;
                }
            }
            result = result * 10 + isPositiveFlag * char2Int(currentChar);
        }

        return result;
    }


    protected int char2Int(char c) {
        return c - '0';
    }
}
