package cn.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _43_multiply_strings {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        List<String> lineResultList = new ArrayList<>();
        int num2Length = num2.length();

        for (int i = 0; i < num2Length; i++) {
            String lineResult = multiply(num1, char2int(num2.charAt(num2Length - 1 - i)));
            lineResultList.add(leftShit(lineResult, i));
        }

        return addAll(lineResultList);
    }


    public String multiply(String numStr, int val) {
        StringBuilder result = new StringBuilder();
        int numStrLength = numStr.length();

        int opt = 0;
        for (int i = numStrLength - 1; i >= 0; --i) {
            int tmpResult = val * char2int(numStr.charAt(i)) + opt;
            opt = tmpResult / 10;
            result.append(int2char(tmpResult % 10));
        }
        if (opt > 0) {
            result.append(int2char(opt));
        }
        return result.reverse().toString();
    }


    public String leftShit(String numStr, int pos) {
        return numStr + "0".repeat(Math.max(0, pos));
    }


    public int char2int(char c) {
        return c - '0';
    }


    public char int2char(int i) {
        return (char) ('0' + i);
    }


    public String addAll(List<String> nums) {
        StringBuilder result = new StringBuilder();
        int maxLength = 0;
        for (String num : nums) {
            maxLength = Math.max(maxLength, num.length());
        }
        int opt = 0;
        for (int i = 0; i < maxLength; i++) {
            int tmpResult = opt;
            for (String num : nums) {
                if (i < num.length()) {
                    tmpResult += char2int(num.charAt(num.length() - 1 - i));
                }
            }
            opt = tmpResult / 10;
            result.append(int2char(tmpResult % 10));
        }
        if (opt > 0) {
            result.append(int2char(opt));
        }

        return result.reverse().toString();
    }
}
