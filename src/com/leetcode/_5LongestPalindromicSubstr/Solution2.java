package com.leetcode._5LongestPalindromicSubstr;


// 中心拓展
public class Solution2 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] sArr = s.toCharArray();
        String res = "";
        for (double i = 0; i < sArr.length; i += 0.5) {
            String tmp = find(s, i);
            res = res.length() > tmp.length() ? res : tmp;
        }

        return res;
    }

    public String find(String s, double start) {
        int left, right;
        if (start % 1 == 0) {   // 如果是整数
            left = (int) start - 1;
            right = (int) start + 1;
        } else {
            left = (int) start;
            right = left + 1;
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }

        return s.substring(left + 1, right);
    }
}
