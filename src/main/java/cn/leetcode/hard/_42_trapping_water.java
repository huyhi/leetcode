package cn.leetcode.hard;

public class _42_trapping_water {

    public int trap(int[] height) {
        int len = height.length;
        int res = 0;

        // maxLeft[i] indicates max height in height[0:i]
        int[] maxLeft = new int[len];
        // maxRight[i] indicates max height in height[i:len]
        int[] maxRight = new int[len];

        int maxVal = height[0];
        for (int i = 0; i < len; i++) {
            maxVal = Math.max(maxVal, height[i]);
            maxLeft[i] = maxVal;
        }
        maxVal = height[len - 1];
        for (int i = len - 1; i >=0; i--) {
            maxVal = Math.max(maxVal, height[i]);
            maxRight[i] = maxVal;
        }

        for (int i = 0; i < len; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] < min) {
                res += min - height[i];
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        new _42_trapping_water().trap(height);
    }
}
