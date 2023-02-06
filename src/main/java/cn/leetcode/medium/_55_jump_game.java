package cn.leetcode.medium;

public class _55_jump_game {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > m) {
                return false;
            }
            m = Math.max(m, i + nums[i]);
        }

        return true;
    }
}
