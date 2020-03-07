package com.leetcode._784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        dfs(S.toCharArray(), 0);
        return res;
    }

    public void dfs(char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (!Character.isLetter(chars[index])) {
            dfs(chars, index + 1);
        } else {
            char[] copied = Arrays.copyOfRange(chars, 0, chars.length);
            copied[index] = change(copied[index]);
            dfs(chars, index + 1);
            dfs(copied, index + 1);
        }
    }

    public char change(char a) {
        return Character.isUpperCase(a) ? Character.toLowerCase(a) : Character.toUpperCase(a);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("123"));
    }
}