package cn.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums);

        for (int p = 0; p <= len - 3; p = move2right(p, nums)) {
            int left = p + 1, right = len - 1;

            while (left < right) {
                if (nums[left] + nums[right] == -nums[p]) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[p]));
                    left = move2right(left, nums);
                    right = move2left(right, nums);
                } else if (nums[left] + nums[right] > -nums[p]) {
                    right = move2left(right, nums);
                } else {
                    left = move2right(left, nums);
                }
            }
        }
        return result;
    }


    private int move2right(int left, int[] nums) {
        int len = nums.length;
        while (left + 1 < len && nums[left] == nums[left + 1]) {
            left++;
        }
        return left + 1;
    }


    private int move2left(int right, int[] nums) {
        while (right > 0 && nums[right] == nums[right - 1]) {
            right--;
        }
        return right - 1;
    }
}
