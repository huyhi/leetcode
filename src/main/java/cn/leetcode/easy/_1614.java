package cn.leetcode.easy;

public class _1614 {

    public int maxDepth(String s) {
        char[] chars = s.toCharArray();

        int maximum = 0;
        int exceptCount = 0;
        for (char item : chars) {
            if (item == '(') {
                exceptCount++;
                maximum = Math.max(maximum, exceptCount);
            }
            if (item == ')') {
                exceptCount--;
            }
        }
        return maximum;
    }
}
