package cn.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _77_combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, n, k, 0);
        return res;
    }


    public void dfs(List<List<Integer>> res, List<Integer> path, int startIdx, int n, int k, int depth) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIdx; i <= n - k + depth; i++) {
            path.add(i + 1);
            dfs(res, path, i + 1, n, k, depth + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        _77_combinations s = new _77_combinations();
        System.out.println(s.combine(4, 2));
    }
}
