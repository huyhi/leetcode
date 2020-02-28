package com.lcof._62JosephProblem;

public class Solution {
    public int lastRemaining(int n, int m){
        if(n < 1 || m < 1)
            return -1;
        if(n == 1)
            return 0;
        return (lastRemaining(n-1, m) + m) % n;
    }
}
