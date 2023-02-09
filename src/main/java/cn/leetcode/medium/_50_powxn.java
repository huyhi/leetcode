package cn.leetcode.medium;

public class _50_powxn {

    // exponentiation by squaring
    public double myPow(double x, long n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, (n - 1) / 2);
    }


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


    public static void main(String[] args) {
        int cornerCase = -2147483648;

        System.out.println(cornerCase);
        System.out.println(-cornerCase);
    }
}
