package com.leetcode._43multiplyStrings;

public class Solution {
    public static String multiply(String num1, String num2) {
        if (num1 == "0" || num2 == "0") {
            return "0";
        }
        int[] arr1 = getIntArray(num1);
        int[] arr2 = getIntArray(num2);
        int[] res = new int[arr1.length + arr2.length + 2];

        for (int i = 0; i < arr1.length; ++i) {
            for (int k = 0; k < arr2.length; ++k) {
                res[i + k] += (arr1[i] * arr2[k]);
            }
        }

        for (int i = 0; i < res.length; ++i) {
            if (res[i] == 0) {
                break;
            }
            res[i + 1] += res[i] / 10;
            res[i] = res[i] % 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i >= 0; --i) {
            if (res[i] == 0) {
                continue;
            } else {
                for (int k = i; k >= 0; --k) {
                    sb.append(res[k]);
                }
                break;
            }
        }

        return sb.toString();
    }

    public static int[] getIntArray(String s) {
        char[] c = new StringBuilder(s).reverse().toString().toCharArray();
        int[] res = new int[c.length];
        for (int i = 0; i < c.length; ++i) {
            res[i] = c[i] - '0';
        }

        return res;
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "0";

        System.out.println(multiply(a, b));
    }
}
