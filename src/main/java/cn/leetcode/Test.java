package cn.leetcode;

import java.util.*;

public class Test {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int times = 1;
        int prevMaxReach = 0;
        int maxReach = nums[0];

        while (maxReach < nums.length - 1) {
            int newMaxReach = maxReach;
            for (int i = prevMaxReach; i <= maxReach; i++) {
                newMaxReach = Math.max(newMaxReach, nums[i] + i);
            }

            prevMaxReach = maxReach;
            maxReach = newMaxReach;
            times++;
        }

        return times;
    }

    public static void main(String[] args) {
        new Test().jump(new int[]{1, 2, 3});
    }
}
