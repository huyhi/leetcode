package com.weeklyContest._183._5377;

public class Solution {
    public int numSteps(String s) {
        int times = 0;
        while (!s.equals("1")) {
            if (isOdd(s)) {
                s = addOne(s);
            } else {
                s = except2(s);
            }
            times++;
        }

        return times;
    }

    // 判断是不是奇数
    public boolean isOdd(String s) {
        return s.charAt(s.length() - 1) == '1';
    }

    public String addOne(String s) {
        char[] charArr = s.toCharArray();

        int i = s.length() - 1;
        while (i >= 0) {
            if (charArr[i] == '1') {
                charArr[i--] = '0';
            } else {
                charArr[i] = '1';
                break;
            }
        }

        String res = new String(charArr);
        return i == -1 ? "1" + res : res;
    }

    public String except2(String s) {
        return s.substring(0, s.length() - 1);
    }

    public static void main(String[] args) {
        String input = "1101";
        System.out.println(new Solution().numSteps(input));

    }
}
