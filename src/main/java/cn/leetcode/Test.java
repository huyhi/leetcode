package cn.leetcode;

import java.util.*;

public class Test {

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        String[] sortedStringArr = new String[len];

        for (int i = 0; i < len; i++) {
            sortedStringArr[i] = sortString(strs[i]);
        }

        Map<String, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s = sortedStringArr[i];
            List<Integer> v = m.get(s);
            if (v == null) {
                m.put(s, new ArrayList<>(Collections.singletonList(i)));
            } else {
                v.add(i);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> mapEntry : m.entrySet()) {
            res.add(mapEntry.getValue().stream().map(i -> strs[i]).toList());
        }

        return res;
    }


    public String sortString(String a) {
        if ("".equals(a)) {
            return a;
        }

        char[] charArr = a.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
