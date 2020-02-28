package com.lcof._15hanmingWeight;


public class Soultion {

    // 注意区分java >> >>> 无符号和有符号位移
    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1)== 1) {
                res++;
            }
            n >>= 1;
        }

        return res;
    }
}
