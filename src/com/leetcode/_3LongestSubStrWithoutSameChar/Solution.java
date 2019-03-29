package com.leetcode._3LongestSubStrWithoutSameChar;

import java.util.HashSet;
import java.util.Set;

/**
 * 头条二面的面试题目
 */
public class Solution {

    // leetcode上看到的官方解答，滑动窗口的方法很巧妙
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = s.length();
        int res = 0, i = 0, j = 0;

        while (i < l && j < l) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return res;
    }
}
