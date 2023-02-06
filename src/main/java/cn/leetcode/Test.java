package cn.leetcode;

public class Test {

    public int totalMoney(int n) {
        int res = 0;

        int weekNum = n / 7;
        int remains = n - 7 * weekNum;

        for (int week = 1; week <= weekNum; week++) {
            res += (week + (week + 6)) * 7 / 2;
        }
        for (int i = 0; i < remains; i++) {
            res += weekNum + i + 1;
        }
        return res;
    }
}
