package com.leetcode._14.LongestCommonPrefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; true; ++i) {
            if (i + 1 > strs[0].length()) {
                return sb.toString();
            }

            char currentChar = strs[0].charAt(i);
            for (int n = 1; n < strs.length; ++n) {
                if (i + 1 > strs[n].length() || !(currentChar == strs[n].charAt(i))) {
                    return sb.toString();
                }
            }
            sb.append(currentChar);
        }
    }
}
