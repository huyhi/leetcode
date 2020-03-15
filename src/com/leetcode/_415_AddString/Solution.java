package com.leetcode._415_AddString;

import static com.Util.Tools.printArray;

class Solution {

    public String addStrings(String num1, String num2) {
        int carry = 0;
        int p1 = num1.length() - 1, p2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (p1 >= 0 || p2 >= 0) {
            int n1 = p1 >= 0 ? num1.charAt(p1--) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2--) - '0' : 0;
            int tmp = n1 + n2 + carry;
            sb.append(tmp % 10);
            carry = tmp / 10;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        new Solution().addStrings("12", "3456");
        System.out.println(2 % 10);

    }
}