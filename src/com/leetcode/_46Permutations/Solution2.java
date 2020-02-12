package com.leetcode._46Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return this.res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            this.res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
