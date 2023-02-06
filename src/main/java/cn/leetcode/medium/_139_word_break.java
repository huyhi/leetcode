package cn.leetcode.medium;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.List;

public class _139_word_break {

    // dp
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // dp[i], s中前i个字符可以由 wordDict 组成
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            unknownName(s, i, wordDict, dp);
        }

        return dp[dp.length - 1];
    }


    public void unknownName(String s, int endIndex, List<String> wordDict, boolean[] dp) {
        for (int i = 0; i < endIndex; i++) {
            if (!dp[i]) {
                continue;
            }
            String subString = s.substring(i, endIndex);
            for (String wordItem : wordDict) {
                if (wordItem.equals(subString)) {
                    dp[endIndex] = true;
                    break;
                }
            }
        }
    }
}
