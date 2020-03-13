package com.Util;

import java.util.Arrays;

public class Tools {
    public static void printArray(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    public static void printTwoFoldArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public static void printArray(char[] a) {
        System.out.println(Arrays.toString(a));
    }
}
