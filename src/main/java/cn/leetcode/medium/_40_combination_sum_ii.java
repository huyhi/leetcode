package cn.leetcode.medium;

import java.util.*;

public class _40_combination_sum_ii {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }


    public void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int p, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }

        Set<Integer> levelSet = new HashSet<>();
        for (int i = p; i < candidates.length; i++) {
            int num = candidates[i];
            if (levelSet.contains(num)) {
                continue;
            }

            levelSet.add(num);
            path.add(num);
            dfs(result, path, candidates, i + 1, target - num);
            path.remove(path.size() - 1);
        }
    }
}
