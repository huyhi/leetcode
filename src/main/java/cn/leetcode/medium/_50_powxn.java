package cn.leetcode.medium;

public class _50_powxn {

    // 2. 折半法角度
    public double myPow2(double x, int n) {
        double res = 1.0;
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }

        double tmp = x;
        while (N > 0) {
            if (N % 2 == 1) {
                res *= x;
            }
            tmp *= tmp;
            N = N / 2;
        }

        return res;
    }
}
