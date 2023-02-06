package cn.leetcode.medium;

public class _91_decode_ways {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            char preChar = s.charAt(i - 1);
            char curChar = s.charAt(i);

            if (preChar == '0') {
                if (curChar == '0') {
                    return 0;
                }
                dp[i] = dp[i - 1];
            } else if (preChar > '2') {
                dp[i] = dp[i - 1];
            } else {
                if (curChar > '6') {
                    dp[i] = dp[i - 1];
                } else if (curChar == '0') {
                    dp[i] = i - 2 < 0 ? 1 : dp[i - 2];
                } else {
                    dp[i] = i - 2 < 0 ? 2 : dp[i - 1] + dp[i - 2];
                }
            }
        }

        return dp[len - 1];
    }


    public static void main(String[] args) {
        String s = "2101";
        System.out.println(new _91_decode_ways().numDecodings(s));
    }
}
