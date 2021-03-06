package com.leetcode._78Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // leetcode 官方解法，应该不是回溯的思想，很难理解
    // 回溯思路见 Solution2 和 Solution3
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; ++i) {
            int resLen = res.size();
            for (int k = 0; k < resLen; ++k) {
                List<Integer> newItem = new ArrayList<>(res.get(k));
                newItem.add(nums[i]);

                res.add(newItem);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution().subsets(new int[]{1, 2, 3});

        System.out.println(res);
    }
}
