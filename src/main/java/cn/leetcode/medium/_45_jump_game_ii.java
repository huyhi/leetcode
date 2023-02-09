package cn.leetcode.medium;

import java.util.Arrays;

public class _45_jump_game_ii {

    public int jump(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] <= 0) {
                continue;
            }
            int nextMinStep = Integer.MAX_VALUE;
            for (int step = 1; step <= nums[i] && step + i < len; step++) {
                nextMinStep = Math.min(nextMinStep, dp[i + step]);
            }

            if (nextMinStep != Integer.MAX_VALUE) {
                dp[i] = 1 + nextMinStep;
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(new _45_jump_game_ii().jump(nums));
    }
}
