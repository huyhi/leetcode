package com.leetcode._557revWordInStrIII;

public class Solution {

    public static void revWordInStr(char[] raw) {
        rev(raw, 0, raw.length - 1);
        int start = 0, end = 0;
        boolean startFlag = true, endFlag = true;

        for (int i = 0; i < raw.length; ++i) {
            if (raw[i] != ' ' && startFlag) {
                start = i;
                startFlag = false;
            }
            if (raw[i] == ' ') {
                end = i;
                endFlag = false;
                rev(raw, start, end - 1);
                startFlag = true;
                endFlag = true;
            }
        }

        if (endFlag) {
            rev(raw, start, raw.length - 1);
        }
    }

    public static void main(String[] args) {
        char[] a = "hello world i love you".toCharArray();
        revWordInStr(a);
        printCharArr(a);
    }

    public static void rev(char[] a, int l, int h) {
        while (l < h) {
            char tmp = a[l];
            a[l++] = a[h];
            a[h--] = tmp;
        }
    }

    public static void printCharArr(char[] a) {
        for (char i : a) {
            System.out.print(i);
        }
        System.out.println();
    }
}
