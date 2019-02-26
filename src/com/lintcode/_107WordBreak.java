package com.lintcode;

import java.util.Set;

public class _107WordBreak {

    public boolean wordBrake(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i < s.length(); ++i) {
            for (int lastWordLength = 1;
                 lastWordLength <= maxLength && lastWordLength <= i;
                 lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return false;
    }


    private int getMaxLength(Set<String> set) {
        int maxLength = 0;
        for (String word : set) {
            maxLength = Math.max(word.length(), maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        boolean[] arr = new boolean[3];

        for (boolean item : arr) {
            System.out.print(item);
        }
    }
}
