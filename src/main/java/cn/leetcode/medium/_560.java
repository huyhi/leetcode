package cn.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _560 {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (countMap.containsKey(sum - k)) {
                res += countMap.get(sum - k);
            }

            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        new _560().subarraySum(nums, 3);
    }
}
