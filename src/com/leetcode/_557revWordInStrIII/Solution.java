package com.leetcode._557revWordInStrIII;

public class Solution {

    public static String reverseWords(String s) {
        char[] sArr = s.toCharArray();
        boolean startFlag = true;
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (sArr[i] != ' ' && startFlag) {
                startFlag = false;
                start = i;
            }
            if (sArr[i] == ' ') {
                end = i - 1;
                startFlag = true;
                rev(sArr, start, end);
            }
        }
        rev(sArr, start, s.length() - 1);

        return new String(sArr);
    }

    public static void main(String[] args) {
        String s = "hello world i love you";
        System.out.println(reverseWords(s));
    }

    public static void rev(char[] a, int l, int h) {
        while (l < h) {
            char tmp = a[l];
            a[l++] = a[h];
            a[h--] = tmp;
        }
    }
}
